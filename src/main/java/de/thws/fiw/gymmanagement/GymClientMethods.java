package de.thws.fiw.gymmanagement;

import de.thws.fiw.gymmanagement.application.*;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GymClientMethods {

    private final MemberServiceGrpc.MemberServiceBlockingStub memberStub;
    private final TrainerServiceGrpc.TrainerServiceBlockingStub trainerStub;
    private final CourseServiceGrpc.CourseServiceBlockingStub courseStub;
    private final BookingServiceGrpc.BookingServiceBlockingStub bookingStub;

    public GymClientMethods(ManagedChannel channel) {
        // Initialisiere alle Service-Stubs über denselben Channel
        this.memberStub = MemberServiceGrpc.newBlockingStub(channel);
        this.trainerStub = TrainerServiceGrpc.newBlockingStub(channel);
        this.courseStub = CourseServiceGrpc.newBlockingStub(channel);
        this.bookingStub = BookingServiceGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) {
        // Erstelle den ManagedChannel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext() // ohne TLS für Testzwecke
                .build();

        // Erstelle eine Instanz des GymClientMethods
        GymClientMethods client = new GymClientMethods(channel);

        // Beispiel: Erstelle einen neuen Member und gib seinen Namen aus
        Member createdMember = client.createMember("Alice", "Premium");
        if (createdMember != null) {
            System.out.println("Erstelltes Member: " + createdMember.getName());
        } else {
            System.err.println("Member konnte nicht erstellt werden.");
        }

        // Hier können weitere Testaufrufe erfolgen, z.B. getAllMembers, updateMember, etc.

        // Schließe den Channel, wenn alle Aufrufe erfolgt sind
        channel.shutdown();
    }

    // --------------------
    // Hilfsmethoden zum Mapping
    // --------------------
    private Member mapMember(GetMemberResponse resp) {
        Member member = new Member(resp.getMemberId(), resp.getName(), resp.getMembership());
        return member;
    }

    private Trainer mapTrainer(GetTrainerResponse resp) {
        Trainer trainer = new Trainer(resp.getTrainerId(), resp.getName(), resp.getExpertise());
        return trainer;
    }

    private Course mapCourse(GetCourseResponse resp) throws RuntimeException{
        Trainer trainer = getTrainer(resp.getTrainerId());
        if (trainer == null) {
            throw new RuntimeException("Failed to retrieve created trainer with id: " + resp.getTrainerId());
        }
        Course course = new Course(resp.getCourseId(), resp.getName(), resp.getCapacity(), trainer);
        return course;
    }

    private Booking mapBooking(GetBookingResponse resp) throws RuntimeException{
        Member member = getMember(resp.getMemberId());
        if (member == null) {
            throw new RuntimeException("Failed to retrieve created member with id: " + resp.getMemberId());
        }
        Course course = getCourse(resp.getCourseId());
        if (course == null) {
            throw new RuntimeException("Failed to retrieve created course with id: " + resp.getCourseId());
        }
        Booking booking = new Booking(resp.getBookingId(), member, course,LocalDate.parse(resp.getBookingDate()));
        return booking;
    }

    // ======================
    // Member-Methoden (über MemberService)
    // ======================

    public Member createMember(String name, String membership) {
        System.out.println("[GymClient] createMember called with name: " + name + ", membership: " + membership);
        try {
            System.out.println("[GymClient] Invoking gRPC call for createMember");
            GetMemberResponse resp = memberStub.createMember(
                    CreateMemberRequest.newBuilder()
                            .setName(name)
                            .setMembership(membership)
                            .build());
            System.out.println("[GymClient] createMember RPC succeeded, received memberId: " + resp.getMemberId());
            Member member = getMember(resp.getMemberId());
            if (member == null) {
                throw new RuntimeException("Failed to retrieve created member with id: " + resp.getMemberId());
            }
            System.out.println("[GymClient] Retrieved created member: " + member.getName());
            return member;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in createMember: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createMember: " + e.getMessage());
            return null;
        }

    }

    public Member updateMember(long id, String name, String membership) {
        System.out.println("[GymClient] updateMember called for memberId: " + id + " with new name: " + name + ", membership: " + membership);
        try {
            System.out.println("[GymClient] Invoking gRPC call for updateMember");
            GetMemberResponse resp = memberStub.updateMember(
                    UpdateMemberRequest.newBuilder()
                            .setMemberId(id)
                            .setName(name)
                            .setMembership(membership)
                            .build());
            System.out.println("[GymClient] updateMember RPC succeeded, updated memberId: " + resp.getMemberId());
            Member member = getMember(resp.getMemberId());
            if (member == null) {
                throw new RuntimeException("Failed to retrieve created member with id: " + resp.getMemberId());
            }
            System.out.println("[GymClient] Retrieved updated member: " + member.getName());
            return member;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in updateMember: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createMember: " + e.getMessage());
            return null;
        }
    }

    public Member getMember(long id) {
        System.out.println("[GymClient] getMember called for memberId: " + id);
        try {
            GetMemberResponse resp = memberStub.getMember(
                    GetMemberRequest.newBuilder()
                            .setMemberId(id)
                            .build());
            System.out.println("[GymClient] getMember RPC succeeded for memberId: " + resp.getMemberId());
            return mapMember(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getMember: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Member> getAllMembers(int pageSize, int index) {
        System.out.println("[GymClient] getAllMembers called with pagesize: " + pageSize + ", index: " + index);
        List<Member> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getAllMembers");
            GetAllMembersResponse resp = memberStub.getAllMembers(
                    GetAllMembersRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
            System.out.println("[GymClient] getAllMembers succeeded: returned " + list.size() + " members");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getAllMembers: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Member> getMemberByName(int pageSize, int index, String name) {
        System.out.println("[GymClient] getMemberByName called with name: " + name + ", pagesize: " + pageSize + ", index: " + index);
        List<Member> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getMemberByName");
            GetAllMembersResponse resp = memberStub.getMemberByName(
                    GetMemberByNameRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setName(name)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
            System.out.println("[GymClient] getMemberByName succeeded: returned " + list.size() + " members");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getMemberByName: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Member> getMemberByMembership(int pageSize, int index, String membership) {
        System.out.println("[GymClient] getMemberByMembership called with membership: " + membership + ", pagesize: " + pageSize + ", index: " + index);
        List<Member> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getMemberByMembership");
            GetAllMembersResponse resp = memberStub.getMemberByMembership(
                    GetMemberByMembershipRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setMembership(membership)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
            System.out.println("[GymClient] getMemberByMembership succeeded: returned " + list.size() + " members");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getMemberByMembership: " + e.getStatus().getDescription());
            return null;
        }
    }

    public void deleteMember(long id) {
        System.out.println("[GymClient] deleteMember called for memberId: " + id);
        try {
            System.out.println("[GymClient] Invoking gRPC call for deleteMember");
            memberStub.deleteMember(
                    DeleteMemberRequest.newBuilder()
                            .setMemberId(id)
                            .build());
            System.out.println("[GymClient] deleteMember succeeded for memberId: " + id);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in deleteMember: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Trainer-Methoden (über TrainerService)
    // ======================

    public Trainer createTrainer(String name, String expertise) {
        System.out.println("[GymClient] createTrainer called with name: " + name + ", expertise: " + expertise);
        try {
            System.out.println("[GymClient] Invoking gRPC call for createTrainer");
            GetTrainerResponse resp = trainerStub.createTrainer(
                    CreateTrainerRequest.newBuilder()
                            .setName(name)
                            .setExpertise(expertise)
                            .build());
            System.out.println("[GymClient] createTrainer RPC succeeded, received trainerId: " + resp.getTrainerId());
            Trainer trainer = getTrainer(resp.getTrainerId());
            if (trainer == null) {
                throw new RuntimeException("Failed to retrieve created trainer with id: " + resp.getTrainerId());
            }
            System.out.println("[GymClient] Retrieved created trainer: " + trainer.getName());
            return trainer;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in createTrainer: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createTrainer: " + e.getMessage());
            return null;
        }
    }

    public Trainer updateTrainer(long id, String name, String expertise) {
        System.out.println("[GymClient] updateTrainer called for trainerId: " + id + " with new name: " + name + ", expertise: " + expertise);
        try {
            System.out.println("[GymClient] Invoking gRPC call for updateTrainer");
            GetTrainerResponse resp = trainerStub.updateTrainer(
                    UpdateTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .setName(name)
                            .setExpertise(expertise)
                            .build());
            System.out.println("[GymClient] updateTrainer RPC succeeded, updated trainerId: " + resp.getTrainerId());
            Trainer trainer = getTrainer(resp.getTrainerId());
            if (trainer == null) {
                throw new RuntimeException("Failed to retrieve created trainer with id: " + resp.getTrainerId());
            }
            System.out.println("[GymClient] Retrieved updated trainer: " + trainer.getName());
            return trainer;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in updateTrainer: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createTrainer: " + e.getMessage());
            return null;
        }
    }

    public Trainer getTrainer(long id) {
        System.out.println("[GymClient] getTrainer called for trainerId: " + id);
        try {
            GetTrainerResponse resp = trainerStub.getTrainer(
                    GetTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .build());
            System.out.println("[GymClient] getTrainer RPC succeeded for trainerId: " + resp.getTrainerId());
            return mapTrainer(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getTrainer: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Trainer> getAllTrainers(int pageSize, int index) {
        System.out.println("[GymClient] getAllTrainers called with pagesize: " + pageSize + ", index: " + index);
        List<Trainer> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getAllTrainers");
            GetAllTrainersResponse resp = trainerStub.getAllTrainers(
                    GetAllTrainersRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
            System.out.println("[GymClient] getAllTrainers succeeded: returned " + list.size() + " trainers");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getAllTrainers: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Trainer> getTrainerByName(int pageSize, int index, String name) {
        System.out.println("[GymClient] getTrainerByName called with name: " + name + ", pagesize: " + pageSize + ", index: " + index);
        List<Trainer> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getTrainerByName");
            GetAllTrainersResponse resp = trainerStub.getTrainerByName(
                    GetTrainerByNameRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setName(name)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
            System.out.println("[GymClient] getTrainerByName succeeded: returned " + list.size() + " trainers");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getTrainerByName: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise) {
        System.out.println("[GymClient] getTrainerByExpertise called with expertise: " + expertise + ", pagesize: " + pageSize + ", index: " + index);
        List<Trainer> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getTrainerByExpertise");
            GetAllTrainersResponse resp = trainerStub.getTrainerByExpertise(
                    GetTrainerByExpertiseRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setExpertise(expertise)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
            System.out.println("[GymClient] getTrainerByExpertise succeeded: returned " + list.size() + " trainers");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getTrainerByExpertise: " + e.getStatus().getDescription());
            return null;
        }
    }

    public void deleteTrainer(long id) {
        System.out.println("[GymClient] deleteTrainer called for trainerId: " + id);
        try {
            System.out.println("[GymClient] Invoking gRPC call for deleteTrainer");
            trainerStub.deleteTrainer(
                    DeleteTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .build());
            System.out.println("[GymClient] deleteTrainer succeeded for trainerId: " + id);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in deleteTrainer: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Course-Methoden (über CourseService)
    // ======================

    public Course createCourse(String name, int capacity, long trainerId) {
        System.out.println("[GymClient] createCourse called with name: " + name
                + ", capacity: " + capacity + ", trainerId: " + trainerId);
        try {
            System.out.println("[GymClient] Invoking gRPC call for createCourse");
            GetCourseResponse resp = courseStub.createCourse(
                    CreateCourseRequest.newBuilder()
                            .setName(name)
                            .setCapacity(capacity)
                            .setTrainerId(trainerId)
                            .build());
            System.out.println("[GymClient] createCourse RPC succeeded, received courseId: " + resp.getCourseId());
            Course course = getCourse(resp.getCourseId());
            if (course == null) {
                throw new RuntimeException("Failed to retrieve created course with id: " + resp.getCourseId());
            }
            System.out.println("[GymClient] Retrieved created course: " + course.getName());
            return course;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in createCourse: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createCourse: " + e.getMessage());
            return null;
        }
    }

    public Course updateCourse(long id, String name, int capacity, long trainerId) {
        System.out.println("[GymClient] updateCourse called for courseId: " + id
                + " with new name: " + name + ", capacity: " + capacity + ", trainerId: " + trainerId);
        try {
            System.out.println("[GymClient] Invoking gRPC call for updateCourse");
            GetCourseResponse resp = courseStub.updateCourse(
                    UpdateCourseRequest.newBuilder()
                            .setCourseId(id)
                            .setName(name)
                            .setCapacity(capacity)
                            .setTrainerId(trainerId)
                            .build());
            System.out.println("[GymClient] updateCourse RPC succeeded, updated courseId: " + resp.getCourseId());
            Course course = getCourse(resp.getCourseId());
            if (course == null) {
                throw new RuntimeException("Failed to retrieve created course with id: " + resp.getCourseId());
            }
            System.out.println("[GymClient] Retrieved updated course: " + course.getName());
            return course;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in updateCourse: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createCourse: " + e.getMessage());
            return null;
        }
    }

    public Course getCourse(long id) {
        System.out.println("[GymClient] getCourse called for courseId: " + id);
        try {
            GetCourseResponse resp = courseStub.getCourse(
                    GetCourseRequest.newBuilder()
                            .setCourseId(id)
                            .build());
            System.out.println("[GymClient] getCourse RPC succeeded for courseId: " + resp.getCourseId());
            return mapCourse(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getCourse: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getCourse: " + e.getMessage());
            return null;
        }
    }

    public List<Course> getCourseByName(String name, int pageSize, int index) {
        System.out.println("[GymClient] getCourseByName called with name: " + name
                + ", pagesize: " + pageSize + ", index: " + index);
        List<Course> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getCourseByName");
            GetAllCoursesResponse resp = courseStub.getCourseByName(
                    GetCourseByNameRequest.newBuilder()
                            .setName(name)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetCourseResponse r : resp.getCoursesList()) {
                list.add(mapCourse(r));
            }
            System.out.println("[GymClient] getCourseByName succeeded: returned " + list.size() + " courses");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getCourseByName: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getCourseByName: " + e.getMessage());
            return null;
        }

    }

    public List<Course> getCourseByTrainer(long trainerId, int pageSize, int index) {
        System.out.println("[GymClient] getCourseByTrainer called for trainerId: " + trainerId
                + ", pagesize: " + pageSize + ", index: " + index);
        List<Course> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getCourseByTrainer");
            GetAllCoursesResponse resp = courseStub.getCourseByTrainer(
                    GetCourseByTrainerRequest.newBuilder()
                            .setTrainerId(trainerId)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetCourseResponse r : resp.getCoursesList()) {
                list.add(mapCourse(r));
            }
            System.out.println("[GymClient] getCourseByTrainer succeeded: returned " + list.size() + " courses");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getCourseByTrainer: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getCourseByTrainer: " + e.getMessage());
            return null;
        }
    }

    public void deleteCourse(long id) {
        System.out.println("[GymClient] deleteCourse called for courseId: " + id);
        try {
            System.out.println("[GymClient] Invoking gRPC call for deleteCourse");
            courseStub.deleteCourse(
                    DeleteCourseRequest.newBuilder()
                            .setCourseId(id)
                            .build());
            System.out.println("[GymClient] deleteCourse succeeded for courseId: " + id);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in deleteCourse: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Booking-Methoden (über BookingService)
    // ======================

    public Booking createBooking(long memberId, long courseId, LocalDate bookingDate) {
        System.out.println("[GymClient] createBooking called with memberId: " + memberId
                + ", courseId: " + courseId + ", bookingDate: " + bookingDate.toString());
        try {
            System.out.println("[GymClient] Invoking gRPC call for createBooking");
            GetBookingResponse resp = bookingStub.createBooking(
                    CreateBookingRequest.newBuilder()
                            .setMemberId(memberId)
                            .setCourseId(courseId)
                            .setBookingDate(bookingDate.toString())
                            .build());
            System.out.println("[GymClient] createBooking RPC succeeded, received bookingId: " + resp.getBookingId());
            Booking booking = getBooking(resp.getBookingId());
            if (booking == null) {
                throw new RuntimeException("Failed to retrieve created booking with id: " + resp.getBookingId());
            }
            System.out.println("[GymClient] Retrieved created booking with id: " + booking.getId());
            return booking;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in createBooking: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in createBooking: " + e.getMessage());
            return null;
        }
    }

    public Booking getBooking(long id) {
        System.out.println("[GymClient] getBooking called for bookingId: " + id);
        try {
            GetBookingResponse resp = bookingStub.getBooking(
                    GetBookingRequest.newBuilder()
                            .setBookingId(id)
                            .build());
            System.out.println("[GymClient] getBooking RPC succeeded for bookingId: " + resp.getBookingId());
            return mapBooking(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getBooking: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getBooking: " + e.getMessage());
            return null;
        }
    }

    public List<Booking> getBookingByMember(long memberId, int pageSize, int index) {
        System.out.println("[GymClient] getBookingByMember called for memberId: " + memberId
                + ", pagesize: " + pageSize + ", index: " + index);
        List<Booking> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getBookingByMember");
            GetAllBookingsResponse resp = bookingStub.getBookingByMember(
                    GetBookingByMemberRequest.newBuilder()
                            .setMemberId(memberId)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
            System.out.println("[GymClient] getBookingByMember succeeded: returned " + list.size() + " bookings");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getBookingByMember: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getBookingByMember: " + e.getMessage());
            return null;
        }
    }

    public List<Booking> getBookingByCourse(long courseId, int pageSize, int index) {
        System.out.println("[GymClient] getBookingByCourse called for courseId: " + courseId
                + ", pagesize: " + pageSize + ", index: " + index);
        List<Booking> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getBookingByCourse");
            GetAllBookingsResponse resp = bookingStub.getBookingByCourse(
                    GetBookingByCourseRequest.newBuilder()
                            .setCourseId(courseId)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
            System.out.println("[GymClient] getBookingByCourse succeeded: returned " + list.size() + " bookings");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getBookingByCourse: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getBookingByMember: " + e.getMessage());
            return null;
        }
    }

    public List<Booking> getBookingByDate(String date, int pageSize, int index) {
        System.out.println("[GymClient] getBookingByDate called for bookingDate: " + date
                + ", pagesize: " + pageSize + ", index: " + index);
        List<Booking> list = new ArrayList<>();
        try {
            System.out.println("[GymClient] Invoking gRPC call for getBookingByDate");
            GetAllBookingsResponse resp = bookingStub.getBookingByDate(
                    GetBookingByDateRequest.newBuilder()
                            .setBookingDate(date)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
            System.out.println("[GymClient] getBookingByDate succeeded: returned " + list.size() + " bookings");
            return list;
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in getBookingByDate: " + e.getStatus().getDescription());
            return null;
        } catch (RuntimeException e) {
            System.err.println("[GymClient] Error in getBookingByDate: " + e.getMessage());
            return null;
        }
    }

    public void deleteBooking(long id) {
        System.out.println("[GymClient] deleteBooking called for bookingId: " + id);
        try {
            System.out.println("[GymClient] Invoking gRPC call for deleteBooking");
            bookingStub.deleteBooking(
                    DeleteBookingRequest.newBuilder()
                            .setBookingId(id)
                            .build());
            System.out.println("[GymClient] deleteBooking succeeded for bookingId: " + id);
        } catch (StatusRuntimeException e) {
            System.err.println("[GymClient] Server Error in deleteBooking: " + e.getStatus().getDescription());
        }
    }
}