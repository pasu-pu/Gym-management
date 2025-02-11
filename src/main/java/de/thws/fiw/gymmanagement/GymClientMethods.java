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
        Member m = new Member();
        m.setId(resp.getMemberId());
        m.setName(resp.getName());
        m.setMembershipType(resp.getMembership()); // Feldname muss mit Proto übereinstimmen
        return m;
    }

    private Trainer mapTrainer(GetTrainerResponse resp) {
        Trainer t = new Trainer();
        t.setId(resp.getTrainerId());
        t.setName(resp.getName());
        t.setExpertise(resp.getExpertise());
        return t;
    }

    private Course mapCourse(GetCourseResponse resp) {
        Course c = new Course();
        c.setId(resp.getCourseId());
        c.setName(resp.getName());
        c.setCapacity(resp.getCapacity());
        // Hole das Trainer-Objekt über den TrainerService
        Trainer trainer = getTrainer(resp.getTrainerId());
        c.setTrainer(trainer);
        return c;
    }

    private Booking mapBooking(GetBookingResponse resp) {
        Booking b = new Booking();
        b.setId(resp.getBookingId());
        // Hole Member und Course über die jeweiligen Methoden
        Member m = getMember(resp.getMemberId());
        Course c = getCourse(resp.getCourseId());
        b.setMember(m);
        b.setCourse(c);
        // Optional: Buchungsdatum setzen
        // b.setBookingDate(LocalDate.parse(resp.getBookingDate()));
        return b;
    }

    // ======================
    // Member-Methoden (über MemberService)
    // ======================

    public Member createMember(String name, String membership) {
        try {
            GetMemberResponse resp = memberStub.createMember(
                    CreateMemberRequest.newBuilder()
                            .setName(name)
                            .setMembership(membership)
                            .build());
            return getMember(resp.getMemberId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Erstellen des Members: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Member updateMember(long id, String name, String membership) {
        try {
            GetMemberResponse resp = memberStub.updateMember(
                    UpdateMemberRequest.newBuilder()
                            .setMemberId(id)
                            .setName(name)
                            .setMembership(membership)
                            .build());
            return getMember(resp.getMemberId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Aktualisieren des Members: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Member getMember(long id) {
        try {
            GetMemberResponse resp = memberStub.getMember(
                    GetMemberRequest.newBuilder()
                            .setMemberId(id)
                            .build());
            return mapMember(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen des Members: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Member> getAllMembers(int pageSize, int index) {
        List<Member> list = new ArrayList<>();
        try {
            GetAllMembersResponse resp = memberStub.getAllMembers(
                    GetAllMembersRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen aller Members: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Member> getMemberByName(int pageSize, int index, String name) {
        List<Member> list = new ArrayList<>();
        try {
            GetAllMembersResponse resp = memberStub.getMemberByName(
                    GetMemberByNameRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setName(name)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Members nach Namen: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Member> getMemberByMembership(int pageSize, int index, String membership) {
        List<Member> list = new ArrayList<>();
        try {
            GetAllMembersResponse resp = memberStub.getMemberByMembership(
                    GetMemberByMembershipRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setMembership(membership)
                            .build());
            for (GetMemberResponse r : resp.getMembersList()) {
                list.add(mapMember(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Members nach Membership: " + e.getStatus().getDescription());
        }
        return list;
    }

    public void deleteMember(long id) {
        try {
            DeleteMemberResponse resp = memberStub.deleteMember(
                    DeleteMemberRequest.newBuilder()
                            .setMemberId(id)
                            .build());
            if (!resp.getSuccess()) {
                System.err.println("Löschen des Members mit ID " + id + " fehlgeschlagen.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Löschen des Members: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Trainer-Methoden (über TrainerService)
    // ======================

    public Trainer createTrainer(String name, String expertise) {
        try {
            GetTrainerResponse resp = trainerStub.createTrainer(
                    CreateTrainerRequest.newBuilder()
                            .setName(name)
                            .setExpertise(expertise)
                            .build());
            return getTrainer(resp.getTrainerId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Erstellen des Trainers: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Trainer updateTrainer(long id, String name, String expertise) {
        try {
            GetTrainerResponse resp = trainerStub.updateTrainer(
                    UpdateTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .setName(name)
                            .setExpertise(expertise)
                            .build());
            return getTrainer(resp.getTrainerId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Aktualisieren des Trainers: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Trainer getTrainer(long id) {
        try {
            GetTrainerResponse resp = trainerStub.getTrainer(
                    GetTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .build());
            return mapTrainer(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen des Trainers: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Trainer> getAllTrainers(int pageSize, int index) {
        List<Trainer> list = new ArrayList<>();
        try {
            GetAllTrainersResponse resp = trainerStub.getAllTrainers(
                    GetAllTrainersRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen aller Trainer: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Trainer> getTrainerByName(int pageSize, int index, String name) {
        List<Trainer> list = new ArrayList<>();
        try {
            GetAllTrainersResponse resp = trainerStub.getTrainerByName(
                    GetTrainerByNameRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setName(name)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Trainer nach Namen: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Trainer> getTrainerByExpertise(int pageSize, int index, String expertise) {
        List<Trainer> list = new ArrayList<>();
        try {
            GetAllTrainersResponse resp = trainerStub.getTrainerByExpertise(
                    GetTrainerByExpertiseRequest.newBuilder()
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .setExpertise(expertise)
                            .build());
            for (GetTrainerResponse r : resp.getTrainersList()) {
                list.add(mapTrainer(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Trainer nach Expertise: " + e.getStatus().getDescription());
        }
        return list;
    }

    public void deleteTrainer(long id) {
        try {
            DeleteTrainerResponse resp = trainerStub.deleteTrainer(
                    DeleteTrainerRequest.newBuilder()
                            .setTrainerId(id)
                            .build());
            if (!resp.getSuccess()) {
                System.err.println("Löschen des Trainers mit ID " + id + " fehlgeschlagen.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Löschen des Trainers: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Course-Methoden (über CourseService)
    // ======================

    public Course createCourse(String name, int capacity, Trainer trainer) {
        try {
            GetCourseResponse resp = courseStub.createCourse(
                    CreateCourseRequest.newBuilder()
                            .setName(name)
                            .setCapacity(capacity)
                            .setTrainerId(trainer.getId())
                            .build());
            return getCourse(resp.getCourseId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Erstellen des Kurses: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Course updateCourse(long id, String name, int capacity, Trainer trainer) {
        try {
            GetCourseResponse resp = courseStub.updateCourse(
                    UpdateCourseRequest.newBuilder()
                            .setCourseId(id)
                            .setName(name)
                            .setCapacity(capacity)
                            .setTrainerId(trainer.getId())
                            .build());
            return getCourse(resp.getCourseId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Aktualisieren des Kurses: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Course getCourse(long id) {
        try {
            GetCourseResponse resp = courseStub.getCourse(
                    GetCourseRequest.newBuilder()
                            .setCourseId(id)
                            .build());
            return mapCourse(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen des Kurses: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Course> getCourseByName(String name, int pageSize, int index) {
        List<Course> list = new ArrayList<>();
        try {
            GetAllCoursesResponse resp = courseStub.getCourseByName(
                    GetCourseByNameRequest.newBuilder()
                            .setName(name)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetCourseResponse r : resp.getCoursesList()) {
                list.add(mapCourse(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Kurse nach Namen: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Course> getCourseByTrainer(Trainer trainer, int pageSize, int index) {
        List<Course> list = new ArrayList<>();
        try {
            GetAllCoursesResponse resp = courseStub.getCourseByTrainer(
                    GetCourseByTrainerRequest.newBuilder()
                            .setTrainerId(trainer.getId())
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetCourseResponse r : resp.getCoursesList()) {
                list.add(mapCourse(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Kurse nach Trainer: " + e.getStatus().getDescription());
        }
        return list;
    }

    public void deleteCourse(long id) {
        try {
            DeleteCourseResponse resp = courseStub.deleteCourse(
                    DeleteCourseRequest.newBuilder()
                            .setCourseId(id)
                            .build());
            if (!resp.getSuccess()) {
                System.err.println("Löschen des Kurses mit ID " + id + " fehlgeschlagen.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Löschen des Kurses: " + e.getStatus().getDescription());
        }
    }

    // ======================
    // Booking-Methoden (über BookingService)
    // ======================

    public Booking createBooking(Member member, Course course, LocalDate bookingDate) {
        try {
            GetBookingResponse resp = bookingStub.createBooking(
                    CreateBookingRequest.newBuilder()
                            .setMemberId(member.getId())
                            .setCourseId(course.getId())
                            .setBookingDate(bookingDate.toString())
                            .build());
            return getBooking(resp.getBookingId());
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Erstellen der Buchung: " + e.getStatus().getDescription());
            return null;
        }
    }

    public Booking getBooking(long id) {
        try {
            GetBookingResponse resp = bookingStub.getBooking(
                    GetBookingRequest.newBuilder()
                            .setBookingId(id)
                            .build());
            return mapBooking(resp);
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Buchung: " + e.getStatus().getDescription());
            return null;
        }
    }

    public List<Booking> getBookingByMember(Member member, int pageSize, int index) {
        List<Booking> list = new ArrayList<>();
        try {
            GetAllBookingsResponse resp = bookingStub.getBookingByMember(
                    GetBookingByMemberRequest.newBuilder()
                            .setMemberId(member.getId())
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Buchungen für Member: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Booking> getBookingByCourse(Course course, int pageSize, int index) {
        List<Booking> list = new ArrayList<>();
        try {
            GetAllBookingsResponse resp = bookingStub.getBookingByCourse(
                    GetBookingByCourseRequest.newBuilder()
                            .setCourseId(course.getId())
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Buchungen für Kurs: " + e.getStatus().getDescription());
        }
        return list;
    }

    public List<Booking> getBookingByDate(String date, int pageSize, int index) {
        List<Booking> list = new ArrayList<>();
        try {
            GetAllBookingsResponse resp = bookingStub.getBookingByDate(
                    GetBookingByDateRequest.newBuilder()
                            .setBookingDate(date)
                            .setPagesize(pageSize)
                            .setIndex(index)
                            .build());
            for (GetBookingResponse r : resp.getBookingsList()) {
                list.add(mapBooking(r));
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Abrufen der Buchungen nach Datum: " + e.getStatus().getDescription());
        }
        return list;
    }

    public void deleteBooking(long id) {
        try {
            DeleteBookingResponse resp = bookingStub.deleteBooking(
                    DeleteBookingRequest.newBuilder()
                            .setBookingId(id)
                            .build());
            if (!resp.getSuccess()) {
                System.err.println("Löschen der Buchung mit ID " + id + " fehlgeschlagen.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Fehler beim Löschen der Buchung: " + e.getStatus().getDescription());
        }
    }
}
