package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.CourseService;
import de.thws.fiw.gymmanagement.application.service.CourseServiceAdapter;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;

public class CourseServiceImpl extends CourseServiceGrpc.CourseServiceImplBase {

    private final CourseServiceAdapter courseService;

    public CourseServiceImpl(CourseServiceAdapter courseService) {
        this.courseService = courseService;
    }

    @Override
    public void createCourse(CreateCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        try {
            // Hole den Trainer (hier wird angenommen, dass die Geschäftslogik dies übernimmt)
            Course course = courseService.createCourse(request.getName(), request.getCapacity(), request.getTrainerId());
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateCourse(UpdateCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        try {
            Course course = courseService.updateCourse(request.getCourseId(), request.getName(), request.getCapacity(), request.getTrainerId());
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourse(GetCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        try {
            Course course = courseService.getCourse(request.getCourseId());
            if (course == null) {
                responseObserver.onError(Status.NOT_FOUND.withDescription("Course not found").asRuntimeException());
                return;
            }
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourseByName(GetCourseByNameRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        try {
            List<Course> courses = courseService.getCourseByName(request.getName(), request.getPagesize(), request.getIndex());
            GetAllCoursesResponse.Builder builder = GetAllCoursesResponse.newBuilder();
            for (Course course : courses) {
                builder.addCourses(GetCourseResponse.newBuilder()
                        .setCourseId(course.getId())
                        .setName(course.getName())
                        .setCapacity(course.getCapacity())
                        .setTrainerId(course.getTrainer().getId())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourseByTrainer(GetCourseByTrainerRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        try {
            List<Course> courses = courseService.getCourseByTrainer(request.getTrainerId(), request.getPagesize(), request.getIndex());
            GetAllCoursesResponse.Builder builder = GetAllCoursesResponse.newBuilder();
            for (Course course : courses) {
                builder.addCourses(GetCourseResponse.newBuilder()
                        .setCourseId(course.getId())
                        .setName(course.getName())
                        .setCapacity(course.getCapacity())
                        .setTrainerId(course.getTrainer().getId())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllCourses(GetAllCoursesRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        try {
            List<Course> courses = courseService.getAllCourses(request.getPagesize(), request.getIndex());
            GetAllCoursesResponse.Builder builder = GetAllCoursesResponse.newBuilder();
            for (Course course : courses) {
                builder.addCourses(GetCourseResponse.newBuilder()
                        .setCourseId(course.getId())
                        .setName(course.getName())
                        .setCapacity(course.getCapacity())
                        .setTrainerId(course.getTrainer().getId())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        try {
            courseService.deleteCourse(request.getCourseId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

}
