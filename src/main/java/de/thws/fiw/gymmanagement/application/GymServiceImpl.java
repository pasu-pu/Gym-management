package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.*;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GymServiceImpl extends GymServiceGrpc.GymServiceImplBase {
    private final MemberRepositoryInterface repository;
    private final TrainerRepositoryInterface trainerRepository = new TrainerRepository();
    private final CourseRepositoryInterface courseRepository = new CourseRepository(trainerRepository); // TrainerRepository übergeben

    public GymServiceImpl(MemberRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void createMember(CreateMemberRequest request, StreamObserver<CreateMemberResponse> responseObserver) {
        Member member = new Member();
        member.setName(request.getName());
        member.setMembershipType(request.getMembershipType());

        Member savedMember = repository.save(member);

        CreateMemberResponse response = CreateMemberResponse.newBuilder()
                .setMemberId(savedMember.getId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        Member member = repository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        GetMemberResponse response = GetMemberResponse.newBuilder()
                .setMemberId(member.getId())
                .setName(member.getName())
                .setMembershipType(member.getMembershipType())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void getAllMembers(Empty request, StreamObserver<GetAllMembersResponse> responseObserver) {
        List<Member> allMembers = repository.findAll();
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
    }
    @Override
    public void updateMember(UpdateMemberRequest request, StreamObserver<UpdateMemberResponse> responseObserver) {
        Member member = repository.update(request.getMemberId(), request.getName(), request.getMembershipType());
        boolean success = member != null;

        UpdateMemberResponse response = UpdateMemberResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteMember(DeleteMemberRequest request, StreamObserver<DeleteMemberResponse> responseObserver) {
        boolean success = repository.findById(request.getMemberId())
                .map(member -> {
                    repository.deleteById(member.getId());
                    return true;
                })
                .orElse(false);

        DeleteMemberResponse response = DeleteMemberResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createTrainer(CreateTrainerRequest request, StreamObserver<CreateTrainerResponse> responseObserver) {
        Trainer trainer = new Trainer();
        trainer.setName(request.getName());
        trainer.setExpertise(request.getExpertise());

        Trainer savedTrainer = trainerRepository.save(trainer);

        CreateTrainerResponse response = CreateTrainerResponse.newBuilder()
                .setTrainerId(savedTrainer.getId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        Trainer trainer = trainerRepository.findById(request.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        GetTrainerResponse response = GetTrainerResponse.newBuilder()
                .setTrainerId(trainer.getId())
                .setName(trainer.getName())
                .setExpertise(trainer.getExpertise())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllTrainers(Empty request, StreamObserver<GetAllTrainersResponse> responseObserver) {
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
    }



    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<UpdateTrainerResponse> responseObserver) {
        boolean success = trainerRepository.update(request.getTrainerId(), request.getName(), request.getExpertise()) != null;

        UpdateTrainerResponse response = UpdateTrainerResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<DeleteTrainerResponse> responseObserver) {
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
    }



    @Override
    public void createCourse(CreateCourseRequest request, StreamObserver<CreateCourseResponse> responseObserver) {
        try {
            Course course = new Course();
            course.setName(request.getName());
            course.setCapacity(request.getCapacity());
            course.setTrainerId(request.getTrainerId());

            // Trainer finden
            Trainer trainer = trainerRepository.findById(course.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));

            // Kurs nur hinzufügen, wenn er noch nicht existiert
            boolean courseExists = trainer.getCourses().stream()
                    .anyMatch(existingCourse -> existingCourse.getName().equals(course.getName()) &&
                            existingCourse.getCapacity() == course.getCapacity());
            if (!courseExists) {
                trainer.getCourses().add(course);
            }

            Course savedCourse = courseRepository.save(course);

            CreateCourseResponse response = CreateCourseResponse.newBuilder()
                    .setCourseId(savedCourse.getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (RuntimeException e) {
            responseObserver.onError(io.grpc.Status.UNKNOWN
                    .withDescription(e.getMessage())
                    .asRuntimeException());
        }
    }



    @Override
    public void getCourse(GetCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        GetCourseResponse response = GetCourseResponse.newBuilder()
                .setCourseId(course.getId())
                .setName(course.getName())
                .setCapacity(course.getCapacity())
                .setTrainerId(course.getTrainerId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCourses(Empty request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        List<Course> allCourses = courseRepository.findAll();
        GetAllCoursesResponse.Builder responseBuilder = GetAllCoursesResponse.newBuilder();

        for (Course course : allCourses) {
            GetCourseResponse courseResponse = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainerId())
                    .build();
            responseBuilder.addCourses(courseResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<DeleteCourseResponse> responseObserver) {
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
    }

    @Override
    public void updateCourse(UpdateCourseRequest request, StreamObserver<UpdateCourseResponse> responseObserver) {
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
    }
    @Override
    public void getCoursesByTrainer(GetCoursesByTrainerRequest request, StreamObserver<GetCoursesByTrainerResponse> responseObserver) {
        List<Course> courses = trainerRepository.findCoursesByTrainerId(request.getTrainerId());

        GetCoursesByTrainerResponse.Builder responseBuilder = GetCoursesByTrainerResponse.newBuilder();
        for (Course course : courses) {
            GetCourseResponse courseResponse = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainerId())
                    .build();
            responseBuilder.addCourses(courseResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
