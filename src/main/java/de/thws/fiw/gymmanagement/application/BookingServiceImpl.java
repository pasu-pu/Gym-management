package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.BookingService;
import de.thws.fiw.gymmanagement.application.service.BookingServiceAdapter;
import de.thws.fiw.gymmanagement.domain.Booking;
import de.thws.fiw.gymmanagement.domain.Member;
import de.thws.fiw.gymmanagement.domain.Course;
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
        try {
            // In der Geschäftslogik wird erwartet, dass Member und Course schon existieren.
            Booking booking = bookingService.createBooking(request.getMemberId(), request.getCourseId(), LocalDate.parse(request.getBookingDate()));
            GetBookingResponse response = GetBookingResponse.newBuilder()
                    .setBookingId(booking.getId())
                    .setMemberId(booking.getMember().getId())
                    .setCourseId(booking.getCourse().getId())
                    .setBookingDate(booking.getBookingDate().toString())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBooking(GetBookingRequest request, StreamObserver<GetBookingResponse> responseObserver) {
        try {
            Booking booking = bookingService.getBooking(request.getBookingId());
            if (booking == null) {
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
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByMember(GetBookingByMemberRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        try {
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
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByCourse(GetBookingByCourseRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        try {
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
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getBookingByDate(GetBookingByDateRequest request, StreamObserver<GetAllBookingsResponse> responseObserver) {
        try {
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
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteBooking(DeleteBookingRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        try {
            bookingService.deleteBooking(request.getBookingId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

}
