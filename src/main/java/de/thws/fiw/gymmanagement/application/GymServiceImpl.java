package de.thws.fiw.gymmanagement.application;

import java.time.LocalDate;
import java.util.List;

import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepository;
import de.thws.fiw.gymmanagement.infrastructure.BookingRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepository;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.infrastructure.MemberRepositoryInterface;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepository;
import de.thws.fiw.gymmanagement.infrastructure.TrainerRepositoryInterface;
import io.grpc.stub.StreamObserver;

public class GymServiceImpl extends GymServiceGrpc.GymServiceImplBase {
    private final MemberRepositoryInterface memberRepository = new MemberRepository();
    private final TrainerRepositoryInterface trainerRepository = new TrainerRepository();
    private final CourseRepositoryInterface courseRepository = new CourseRepository();
    private final BookingRepositoryInterface bookingRepository = new BookingRepository();


    public GymServiceImpl() {

    }

    @Override
    public void createMember(CreateMemberRequest request, StreamObserver<CreateMemberResponse> responseObserver) {
        try {
            Member member = new Member();
            member.setName(request.getName());
            member.setMembershipType(request.getMembershipType());

            Member savedMember = memberRepository.save(member);

            CreateMemberResponse response = CreateMemberResponse.newBuilder()
                    .setMemberId(savedMember.getId())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace(); // Fehlerausgabe auf dem Server
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Speichern des Mitglieds: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        try {
            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembershipType(member.getMembershipType())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen des Mitglieds: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getAllMembers(Empty request, StreamObserver<GetAllMembersResponse> responseObserver) {
        try {
            List<Member> allMembers = memberRepository.findAll();
            GetAllMembersResponse.Builder responseBuilder = GetAllMembersResponse.newBuilder();

            for (Member member : allMembers) {
                GetMemberResponse memberResponse = GetMemberResponse.newBuilder()
                        .setMemberId(member.getId())
                        .setName(member.getName())
                        .setMembershipType(member.getMembershipType())
                        .build();
                responseBuilder.addMembers(memberResponse);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen der Mitglieder: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateMember(UpdateMemberRequest request, StreamObserver<UpdateMemberResponse> responseObserver) {
        try {
            Member member = memberRepository.update(request.getMemberId(), request.getName(), request.getMembershipType());
            boolean success = member != null;

            UpdateMemberResponse response = UpdateMemberResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Aktualisieren des Mitglieds: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deleteMember(DeleteMemberRequest request, StreamObserver<DeleteMemberResponse> responseObserver) {
        try {
            boolean success = memberRepository.findById(request.getMemberId())
                    .map(member -> {
                        memberRepository.deleteById(member.getId());
                        return true;
                    })
                    .orElse(false);

            DeleteMemberResponse response = DeleteMemberResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Löschen des Mitglieds: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void createTrainer(CreateTrainerRequest request, StreamObserver<CreateTrainerResponse> responseObserver) {
        try {
            Trainer trainer = new Trainer();
            trainer.setName(request.getName());
            trainer.setExpertise(request.getExpertise());

            Trainer savedTrainer = trainerRepository.save(trainer);

            CreateTrainerResponse response = CreateTrainerResponse.newBuilder()
                    .setTrainerId(savedTrainer.getId())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace(); // Fehlerausgabe auf dem Server
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Speichern des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        try {
            Trainer trainer = trainerRepository.findById(request.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));

            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getAllTrainers(Empty request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        try {
            List<Trainer> allTrainers = trainerRepository.findAll();
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
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen der Trainer: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<UpdateTrainerResponse> responseObserver) {
        try {
            boolean success = trainerRepository.update(request.getTrainerId(), request.getName(), request.getExpertise()) != null;

            UpdateTrainerResponse response = UpdateTrainerResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Aktualisieren des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<DeleteTrainerResponse> responseObserver) {
        try {
            boolean success = trainerRepository.findById(request.getTrainerId())
                    .map(trainer -> {
                        trainerRepository.deleteById(trainer.getId());
                        return true;
                    })
                    .orElse(false);

            DeleteTrainerResponse response = DeleteTrainerResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Löschen des Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void createCourse(CreateCourseRequest request, StreamObserver<CreateCourseResponse> responseObserver) {
        try {
            Course course = new Course();
            course.setName(request.getName());
            course.setCapacity(request.getCapacity());

            Trainer trainer = trainerRepository.findById(request.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));

            if (courseRepository.findByName(course.getName()).isEmpty()) {
                course.setTrainer(trainer);
                Course savedCourse = courseRepository.save(course);

                CreateCourseResponse response = CreateCourseResponse.newBuilder()
                        .setCourseId(savedCourse.getId())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                throw new RuntimeException("Course already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Speichern des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getCourse(GetCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        try {
            Course course = courseRepository.findById(request.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getAllCourses(Empty request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        try {
            List<Course> allCourses = courseRepository.findAll();
            GetAllCoursesResponse.Builder responseBuilder = GetAllCoursesResponse.newBuilder();

            for (Course course : allCourses) {
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
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen aller Kurse: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<DeleteCourseResponse> responseObserver) {
        try {
            boolean success = courseRepository.findById(request.getCourseId())
                    .map(course -> {
                        courseRepository.deleteById(course.getId());
                        return true;
                    })
                    .orElse(false);

            DeleteCourseResponse response = DeleteCourseResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Löschen des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateCourse(UpdateCourseRequest request, StreamObserver<UpdateCourseResponse> responseObserver) {
        try {
            boolean success = courseRepository.update(
                    request.getCourseId(),
                    request.getName(),
                    request.getCapacity(),
                    request.getTrainerId()
            ) != null;

            UpdateCourseResponse response = UpdateCourseResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Aktualisieren des Kurses: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void getCoursesByTrainer(GetCoursesByTrainerRequest request, StreamObserver<GetCoursesByTrainerResponse> responseObserver) {
        try {
            List<Course> courses = trainerRepository.findCoursesByTrainerId(request.getTrainerId());

            GetCoursesByTrainerResponse.Builder responseBuilder = GetCoursesByTrainerResponse.newBuilder();
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
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen der Kurse eines Trainers: " + e.getMessage())
                    .asRuntimeException());
        }
    }


    @Override
    public void createBooking(CreateBookingRequest request, StreamObserver<CreateBookingResponse> responseObserver) {
        try {
            // Überprüfen, ob Mitglied und Kurs existieren
            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));
            Course course = courseRepository.findById(request.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            // Buchung erstellen und den Kurs sowie das Mitglied zuweisen
            Booking booking = new Booking();
            booking.setMember(member); // Zuordnung des Mitglieds
            booking.setCourse(course); // Zuordnung des Kurses
            booking.setBookingDate(LocalDate.now()); // Beispiel für das Setzen des Buchungsdatums

            // Speichern der Buchung mit den zusätzlichen Parametern: memberId und courseId
            Booking savedBooking = bookingRepository.save(booking, request.getMemberId(), request.getCourseId());

            if (savedBooking == null || savedBooking.getId() == null) {
                throw new RuntimeException("Fehler: Buchung wurde nicht gespeichert!");
            }

            CreateBookingResponse response = CreateBookingResponse.newBuilder()
                    .setBookingId(savedBooking.getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace(); // Fehlerausgabe auf dem Server
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Speichern der Buchung: " + e.getMessage())
                    .asRuntimeException());
        }
    }



    @Override
    public void getBookingsByMember(GetBookingsByMemberRequest request, StreamObserver<GetBookingsByMemberResponse> responseObserver) {
        try {
            List<Booking> bookings = bookingRepository.findByMemberId(request.getMemberId());
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
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription("Fehler beim Abrufen der Buchungen eines Mitglieds: " + e.getMessage())
                    .asRuntimeException());
        }
    }
}