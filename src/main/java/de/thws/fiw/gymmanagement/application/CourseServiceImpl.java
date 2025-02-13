package de.thws.fiw.gymmanagement.application;

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
        System.out.println("[CourseServiceImpl] createCourse called with name: " + request.getName() +
                ", capacity: " + request.getCapacity() + ", trainerId: " + request.getTrainerId());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for createCourse");
            // Hier wird angenommen, dass courseService.createCourse einen Trainer anhand der trainerId intern ermittelt
            Course course = courseService.createCourse(request.getName(), request.getCapacity(), request.getTrainerId());
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[CourseServiceImpl] createCourse succeeded: created course with id " + response.getCourseId());
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in createCourse: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateCourse(UpdateCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        System.out.println("[CourseServiceImpl] updateCourse called for courseId: " + request.getCourseId() +
                " with new name: " + request.getName() + ", capacity: " + request.getCapacity() +
                ", trainerId: " + request.getTrainerId());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for updateCourse");
            Course course = courseService.updateCourse(request.getCourseId(), request.getName(), request.getCapacity(), request.getTrainerId());
            GetCourseResponse response = GetCourseResponse.newBuilder()
                    .setCourseId(course.getId())
                    .setName(course.getName())
                    .setCapacity(course.getCapacity())
                    .setTrainerId(course.getTrainer().getId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[CourseServiceImpl] updateCourse succeeded for courseId: " + response.getCourseId());
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in updateCourse: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourse(GetCourseRequest request, StreamObserver<GetCourseResponse> responseObserver) {
        System.out.println("[CourseServiceImpl] getCourse called for courseId: " + request.getCourseId());
        try {
            Course course = courseService.getCourse(request.getCourseId());
            if (course == null) {
                System.err.println("[CourseServiceImpl] getCourse: Course with id " + request.getCourseId() + " not found");
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
            System.out.println("[CourseServiceImpl] getCourse succeeded for courseId: " + response.getCourseId());
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in getCourse: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourseByName(GetCourseByNameRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        System.out.println("[CourseServiceImpl] getCourseByName called with name: " + request.getName() +
                ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for getCourseByName");
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
            System.out.println("[CourseServiceImpl] getCourseByName succeeded: returned " + courses.size() + " courses");
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in getCourseByName: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getCourseByTrainer(GetCourseByTrainerRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        System.out.println("[CourseServiceImpl] getCourseByTrainer called for trainerId: " + request.getTrainerId() +
                ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for getCourseByTrainer");
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
            System.out.println("[CourseServiceImpl] getCourseByTrainer succeeded: returned " + courses.size() + " courses");
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in getCourseByTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllCourses(GetAllCoursesRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        System.out.println("[CourseServiceImpl] getAllCourses called with pagesize: " + request.getPagesize() +
                ", index: " + request.getIndex());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for getAllCourses");
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
            System.out.println("[CourseServiceImpl] getAllCourses succeeded: returned " + courses.size() + " courses");
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in getAllCourses: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteCourse(DeleteCourseRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        System.out.println("[CourseServiceImpl] deleteCourse called for courseId: " + request.getCourseId());
        try {
            System.out.println("[CourseServiceImpl] Invoking business logic for deleteCourse");
            courseService.deleteCourse(request.getCourseId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
            System.out.println("[CourseServiceImpl] deleteCourse succeeded for courseId: " + request.getCourseId());
        } catch (Exception e) {
            System.err.println("[CourseServiceImpl] Error in deleteCourse: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
