package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.BookingServiceAdapter;
import de.thws.fiw.gymmanagement.domain.Booking;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.time.LocalDate;
import java.util.List;

public class BookingServiceImpl extends BookingServiceGrpc.BookingServiceImplBase {

    private final BookingServiceAdapter bookingService;

    public BookingServiceImpl(BookingServiceAdapter bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void createBooking(CreateBookingRequest request, StreamObserver<GetBookingResponse> responseObserver) {
        System.out.println("[BookingService] createBooking called with memberId: " + request.getMemberId()
                + ", courseId: " + request.getCourseId() + ", bookingDate: " + request.getBookingDate());
        try {
            System.out.println("[BookingService] Invoking business logic for createBooking");
            Booking booking = bookingService.createBooking(
                    request.getMemberId(),
                    request.getCourseId(),
                    LocalDate.parse(request.getBookingDate()));
            GetBookingResponse response = GetBookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .setMemberId(booking.getMember().getId())
                    .setCourseId(booking.getCourse().getId())
                    .setBookingDate(booking.getBookingDate().toString())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[BookingService] createBooking succeeded: created booking with id " + response.getBookingId());
        } catch (Exception e) {
            System.err.println("[BookingService] Error in createBooking: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBooking(GetBookingRequest request, StreamObserver<GetBookingResponse> responseObserver) {
        System.out.println("[BookingService] getBooking called for bookingId: " + request.getBookingId());
        try {
            Booking booking = bookingService.getBooking(request.getBookingId());
            if (booking == null) {
                System.err.println("[BookingService] getBooking: Booking with id " + request.getBookingId() + " not found");
                responseObserver.onError(Status.NOT_FOUND.withDescription("Booking not found").asRuntimeException());
                return;
            }
            GetBookingResponse response = GetBookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .setMemberId(booking.getMember().getId())
                    .setCourseId(booking.getCourse().getId())
                    .setBookingDate(booking.getBookingDate().toString())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[BookingService] getBooking succeeded for bookingId: " + response.getBookingId());
        } catch (Exception e) {
            System.err.println("[BookingService] Error in getBooking: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByMember(GetBookingByMemberRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        System.out.println("[BookingService] getBookingByMember called for memberId: " + request.getMemberId()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[BookingService] Invoking business logic for getBookingByMember");
            List<Booking> bookings = bookingService.getBookingByMember(request.getMemberId(), request.getPagesize(), request.getIndex());
            GetAllBookingsResponse.Builder builder = GetAllBookingsResponse.newBuilder();
            for (Booking booking : bookings) {
                builder.addBookings(GetBookingResponse.newBuilder()
                        .setBookingId(booking.getId())
                        .setMemberId(booking.getMember().getId())
                        .setCourseId(booking.getCourse().getId())
                        .setBookingDate(booking.getBookingDate().toString())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
            System.out.println("[BookingService] getBookingByMember succeeded: returned " + bookings.size() + " bookings");
        } catch (Exception e) {
            System.err.println("[BookingService] Error in getBookingByMember: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByCourse(GetBookingByCourseRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        System.out.println("[BookingService] getBookingByCourse called for courseId: " + request.getCourseId()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[BookingService] Invoking business logic for getBookingByCourse");
            List<Booking> bookings = bookingService.getBookingByCourse(request.getCourseId(), request.getPagesize(), request.getIndex());
            GetAllBookingsResponse.Builder builder = GetAllBookingsResponse.newBuilder();
            for (Booking booking : bookings) {
                builder.addBookings(GetBookingResponse.newBuilder()
                        .setBookingId(booking.getId())
                        .setMemberId(booking.getMember().getId())
                        .setCourseId(booking.getCourse().getId())
                        .setBookingDate(booking.getBookingDate().toString())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
            System.out.println("[BookingService] getBookingByCourse succeeded: returned " + bookings.size() + " bookings");
        } catch (Exception e) {
            System.err.println("[BookingService] Error in getBookingByCourse: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByDate(GetBookingByDateRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        System.out.println("[BookingService] getBookingByDate called for bookingDate: " + request.getBookingDate()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[BookingService] Invoking business logic for getBookingByDate");
            List<Booking> bookings = bookingService.getBookingByDate(request.getBookingDate(), request.getPagesize(), request.getIndex());
            GetAllBookingsResponse.Builder builder = GetAllBookingsResponse.newBuilder();
            for (Booking booking : bookings) {
                builder.addBookings(GetBookingResponse.newBuilder()
                        .setBookingId(booking.getId())
                        .setMemberId(booking.getMember().getId())
                        .setCourseId(booking.getCourse().getId())
                        .setBookingDate(booking.getBookingDate().toString())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
            System.out.println("[BookingService] getBookingByDate succeeded: returned " + bookings.size() + " bookings");
        } catch (Exception e) {
            System.err.println("[BookingService] Error in getBookingByDate: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteBooking(DeleteBookingRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        System.out.println("[BookingService] deleteBooking called for bookingId: " + request.getBookingId());
        try {
            System.out.println("[BookingService] Invoking business logic for deleteBooking");
            bookingService.deleteBooking(request.getBookingId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
            System.out.println("[BookingService] deleteBooking succeeded for bookingId: " + request.getBookingId());
        } catch (Exception e) {
            System.err.println("[BookingService] Error in deleteBooking: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
