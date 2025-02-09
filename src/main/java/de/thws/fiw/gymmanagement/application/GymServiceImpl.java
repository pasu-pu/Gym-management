package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.*;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Optional;

public class GymServiceImpl extends GymServiceGrpc.GymServiceImplBase {
    private final MemberService memberService;
    private final TrainerService trainerService;
    private final CourseService courseService;
    private final BookingService bookingService;

    public GymServiceImpl(MemberService memberService, TrainerService trainerService, CourseService courseService, BookingService bookingService) {
        this.memberService = memberService;
        this.trainerService = trainerService;
        this.courseService = courseService;
        this.bookingService = bookingService;
    }

    // --- CRUD für Member ---
    @Override
    public void createMember(CreateMemberRequest request, StreamObserver<CreateMemberResponse> responseObserver) {
        Member member = memberService.createMember(request.getName(), request.getMembershipType());
        CreateMemberResponse response = CreateMemberResponse.newBuilder()
                .setMemberId(member.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        Optional<Member> member = memberService.getMember(request.getMemberId());
        if (member.isPresent()) {
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.get().getId())
                    .setName(member.get().getName())
                    .setMembershipType(member.get().getMembershipType())
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("Member not found").asRuntimeException());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAllMembers(Empty request, StreamObserver<GetAllMembersResponse> responseObserver) {
        List<Member> members = memberService.getAllMembers();
        GetAllMembersResponse.Builder responseBuilder = GetAllMembersResponse.newBuilder();
        for (Member member : members) {
            responseBuilder.addMembers(GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembershipType(member.getMembershipType())
                    .build());
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateMember(UpdateMemberRequest request, StreamObserver<UpdateMemberResponse> responseObserver) {
        boolean success = memberService.updateMember(request.getMemberId(), request.getName(), request.getMembershipType());
        UpdateMemberResponse response = UpdateMemberResponse.newBuilder().setSuccess(success).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteMember(DeleteMemberRequest request, StreamObserver<DeleteMemberResponse> responseObserver) {
        boolean success = memberService.deleteMember(request.getMemberId());
        DeleteMemberResponse response = DeleteMemberResponse.newBuilder().setSuccess(success).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // --- CRUD für Trainer ---
    @Override
    public void createTrainer(CreateTrainerRequest request, StreamObserver<CreateTrainerResponse> responseObserver) {
        try {
            Trainer savedTrainer = trainerService.createTrainer(request.getName(), request.getExpertise());

            CreateTrainerResponse response = CreateTrainerResponse.newBuilder()
                    .setTrainerId(savedTrainer.getId())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Erstellen des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        try {
            Trainer trainer = trainerService.getTrainer(request.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer nicht gefunden"));

            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getAllTrainers(Empty request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        try {
            List<Trainer> allTrainers = trainerService.getAllTrainers();
            GetAllTrainersResponse.Builder responseBuilder = GetAllTrainersResponse.newBuilder();

            for (Trainer trainer : allTrainers) {
                GetTrainerResponse trainerResponse = GetTrainerResponse.newBuilder()
                        .setTrainerId(trainer.getId())
                        .setName(trainer.getName())
                        .setExpertise(trainer.getExpertise())
                        .build();
                responseBuilder.addTrainers(trainerResponse);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen aller Trainer: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<UpdateTrainerResponse> responseObserver) {
        try {
            boolean success = trainerService.updateTrainer(request.getTrainerId(), request.getName(), request.getExpertise());

            UpdateTrainerResponse response = UpdateTrainerResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Aktualisieren des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<DeleteTrainerResponse> responseObserver) {
        try {
            boolean success = trainerService.deleteTrainer(request.getTrainerId());

            DeleteTrainerResponse response = DeleteTrainerResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Löschen des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }


    // --- CRUD für Courses ---
    @Override
    public void createCourse(CreateCourseRequest request, StreamObserver<CreateCourseResponse> responseObserver) {
        Course course = courseService.createCourse(request.getName(), request.getCapacity(), request.getTrainerId());
        CreateCourseResponse response = CreateCourseResponse.newBuilder()
                .setCourseId(course.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateCourse(UpdateCourseRequest request, StreamObserver<UpdateCourseResponse> responseObserver) {
        try {
            // Kurs aktualisieren
            boolean success = courseService.updateCourse(
                    request.getCourseId(),
                    request.getName(),
                    request.getCapacity(),
                    request.getTrainerId()
            );

            // Antwort erstellen
            UpdateCourseResponse response = UpdateCourseResponse.newBuilder()
                    .setSuccess(success)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Aktualisieren des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }


    @Override
    public void getCourse(GetCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        Optional<Course> course = courseService.getCourse(request.getCourseId());
        if (course.isPresent()) {
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.get().getId())
                    .setName(course.get().getName())
                    .setCapacity(course.get().getCapacity())
                    .setTrainerId(course.get().getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("Course not found").asRuntimeException());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCourses(Empty request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        List<Course> courses = courseService.getAllCourses(); // Service-Methode aufrufen
        GetAllCoursesResponse.Builder responseBuilder = GetAllCoursesResponse.newBuilder();

        for (Course course : courses) {
            GetCourseResponse courseResponse = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseBuilder.addCourses(courseResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }



    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<DeleteCourseResponse> responseObserver) {
        try {
            // Kurs löschen
            boolean success = courseService.deleteCourse(request.getCourseId());

            // Antwort erstellen
            DeleteCourseResponse response = DeleteCourseResponse.newBuilder()
                    .setSuccess(success)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Löschen des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }




    // --- Buchungen ---
    @Override
    public void createBooking(CreateBookingRequest request, StreamObserver<CreateBookingResponse> responseObserver) {
        try {
            Booking booking = bookingService.createBooking(request.getMemberId(), request.getCourseId());
            CreateBookingResponse response = CreateBookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Speichern der Buchung: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getBookingsByMember(GetBookingsByMemberRequest request, StreamObserver<GetBookingsByMemberResponse> responseObserver) {
        List<Booking> bookings = bookingService.getBookingsByMember(request.getMemberId());
        GetBookingsByMemberResponse.Builder responseBuilder = GetBookingsByMemberResponse.newBuilder();
        for (Booking booking : bookings) {
            BookingResponse bookingResponse = BookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .setMemberId(booking.getMember().getId())
                    .setCourseId(booking.getCourse().getId())
                    .setBookingDate(booking.getBookingDate().toString())
                    .build();
            responseBuilder.addBookings(bookingResponse);
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getBookingsByCourse(GetBookingsByCourseRequest request, StreamObserver<GetBookingsByCourseResponse> responseObserver) {
        List<Booking> bookings = bookingService.getBookingsByCourse(request.getCourseId());
        GetBookingsByCourseResponse.Builder responseBuilder = GetBookingsByCourseResponse.newBuilder();
        for (Booking booking : bookings) {
            BookingResponse bookingResponse = BookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .setMemberId(booking.getMember().getId())
                    .setCourseId(booking.getCourse().getId())
                    .setBookingDate(booking.getBookingDate().toString())
                    .build();
            responseBuilder.addBookings(bookingResponse);
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteBooking(DeleteBookingRequest request, StreamObserver<DeleteBookingResponse> responseObserver) {
        boolean success = bookingService.deleteBooking(request.getBookingId());
        DeleteBookingResponse response = DeleteBookingResponse.newBuilder().setSuccess(success).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
