package de.thws.fiw.gymmanagement.application;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * -------------------------
 * Booking Service
 * -------------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BookingServiceGrpc {

  private BookingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "BookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateBookingRequest,
      de.thws.fiw.gymmanagement.application.GetBookingResponse> getCreateBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBooking",
      requestType = de.thws.fiw.gymmanagement.application.CreateBookingRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetBookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateBookingRequest,
      de.thws.fiw.gymmanagement.application.GetBookingResponse> getCreateBookingMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateBookingRequest, de.thws.fiw.gymmanagement.application.GetBookingResponse> getCreateBookingMethod;
    if ((getCreateBookingMethod = BookingServiceGrpc.getCreateBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getCreateBookingMethod = BookingServiceGrpc.getCreateBookingMethod) == null) {
          BookingServiceGrpc.getCreateBookingMethod = getCreateBookingMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateBookingRequest, de.thws.fiw.gymmanagement.application.GetBookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateBookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("CreateBooking"))
              .build();
        }
      }
    }
    return getCreateBookingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingRequest,
      de.thws.fiw.gymmanagement.application.GetBookingResponse> getGetBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBooking",
      requestType = de.thws.fiw.gymmanagement.application.GetBookingRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetBookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingRequest,
      de.thws.fiw.gymmanagement.application.GetBookingResponse> getGetBookingMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingRequest, de.thws.fiw.gymmanagement.application.GetBookingResponse> getGetBookingMethod;
    if ((getGetBookingMethod = BookingServiceGrpc.getGetBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetBookingMethod = BookingServiceGrpc.getGetBookingMethod) == null) {
          BookingServiceGrpc.getGetBookingMethod = getGetBookingMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetBookingRequest, de.thws.fiw.gymmanagement.application.GetBookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetBooking"))
              .build();
        }
      }
    }
    return getGetBookingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBookingByMember",
      requestType = de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByMemberMethod;
    if ((getGetBookingByMemberMethod = BookingServiceGrpc.getGetBookingByMemberMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetBookingByMemberMethod = BookingServiceGrpc.getGetBookingByMemberMethod) == null) {
          BookingServiceGrpc.getGetBookingByMemberMethod = getGetBookingByMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBookingByMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetBookingByMember"))
              .build();
        }
      }
    }
    return getGetBookingByMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBookingByCourse",
      requestType = de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByCourseMethod;
    if ((getGetBookingByCourseMethod = BookingServiceGrpc.getGetBookingByCourseMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetBookingByCourseMethod = BookingServiceGrpc.getGetBookingByCourseMethod) == null) {
          BookingServiceGrpc.getGetBookingByCourseMethod = getGetBookingByCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBookingByCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetBookingByCourse"))
              .build();
        }
      }
    }
    return getGetBookingByCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByDateRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBookingByDate",
      requestType = de.thws.fiw.gymmanagement.application.GetBookingByDateRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByDateRequest,
      de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByDateMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetBookingByDateRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getGetBookingByDateMethod;
    if ((getGetBookingByDateMethod = BookingServiceGrpc.getGetBookingByDateMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetBookingByDateMethod = BookingServiceGrpc.getGetBookingByDateMethod) == null) {
          BookingServiceGrpc.getGetBookingByDateMethod = getGetBookingByDateMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetBookingByDateRequest, de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBookingByDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetBookingByDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllBookingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetBookingByDate"))
              .build();
        }
      }
    }
    return getGetBookingByDateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteBookingRequest,
      com.google.protobuf.Empty> getDeleteBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBooking",
      requestType = de.thws.fiw.gymmanagement.application.DeleteBookingRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteBookingRequest,
      com.google.protobuf.Empty> getDeleteBookingMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteBookingRequest, com.google.protobuf.Empty> getDeleteBookingMethod;
    if ((getDeleteBookingMethod = BookingServiceGrpc.getDeleteBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getDeleteBookingMethod = BookingServiceGrpc.getDeleteBookingMethod) == null) {
          BookingServiceGrpc.getDeleteBookingMethod = getDeleteBookingMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteBookingRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteBookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("DeleteBooking"))
              .build();
        }
      }
    }
    return getDeleteBookingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingServiceStub>() {
        @java.lang.Override
        public BookingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingServiceStub(channel, callOptions);
        }
      };
    return BookingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingServiceBlockingStub>() {
        @java.lang.Override
        public BookingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingServiceBlockingStub(channel, callOptions);
        }
      };
    return BookingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BookingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BookingServiceFutureStub>() {
        @java.lang.Override
        public BookingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BookingServiceFutureStub(channel, callOptions);
        }
      };
    return BookingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * -------------------------
   * Booking Service
   * -------------------------
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createBooking(de.thws.fiw.gymmanagement.application.CreateBookingRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBookingMethod(), responseObserver);
    }

    /**
     */
    default void getBooking(de.thws.fiw.gymmanagement.application.GetBookingRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookingMethod(), responseObserver);
    }

    /**
     */
    default void getBookingByMember(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookingByMemberMethod(), responseObserver);
    }

    /**
     */
    default void getBookingByCourse(de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookingByCourseMethod(), responseObserver);
    }

    /**
     */
    default void getBookingByDate(de.thws.fiw.gymmanagement.application.GetBookingByDateRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBookingByDateMethod(), responseObserver);
    }

    /**
     */
    default void deleteBooking(de.thws.fiw.gymmanagement.application.DeleteBookingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBookingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BookingService.
   * <pre>
   * -------------------------
   * Booking Service
   * -------------------------
   * </pre>
   */
  public static abstract class BookingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BookingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BookingService.
   * <pre>
   * -------------------------
   * Booking Service
   * -------------------------
   * </pre>
   */
  public static final class BookingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BookingServiceStub> {
    private BookingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void createBooking(de.thws.fiw.gymmanagement.application.CreateBookingRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBookingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBooking(de.thws.fiw.gymmanagement.application.GetBookingRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBookingByMember(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookingByMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBookingByCourse(de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookingByCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBookingByDate(de.thws.fiw.gymmanagement.application.GetBookingByDateRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBookingByDateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteBooking(de.thws.fiw.gymmanagement.application.DeleteBookingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BookingService.
   * <pre>
   * -------------------------
   * Booking Service
   * -------------------------
   * </pre>
   */
  public static final class BookingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BookingServiceBlockingStub> {
    private BookingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetBookingResponse createBooking(de.thws.fiw.gymmanagement.application.CreateBookingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBookingMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetBookingResponse getBooking(de.thws.fiw.gymmanagement.application.GetBookingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookingMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllBookingsResponse getBookingByMember(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookingByMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllBookingsResponse getBookingByCourse(de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookingByCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllBookingsResponse getBookingByDate(de.thws.fiw.gymmanagement.application.GetBookingByDateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBookingByDateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteBooking(de.thws.fiw.gymmanagement.application.DeleteBookingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBookingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BookingService.
   * <pre>
   * -------------------------
   * Booking Service
   * -------------------------
   * </pre>
   */
  public static final class BookingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BookingServiceFutureStub> {
    private BookingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetBookingResponse> createBooking(
        de.thws.fiw.gymmanagement.application.CreateBookingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBookingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetBookingResponse> getBooking(
        de.thws.fiw.gymmanagement.application.GetBookingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getBookingByMember(
        de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookingByMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getBookingByCourse(
        de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookingByCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse> getBookingByDate(
        de.thws.fiw.gymmanagement.application.GetBookingByDateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBookingByDateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBooking(
        de.thws.fiw.gymmanagement.application.DeleteBookingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BOOKING = 0;
  private static final int METHODID_GET_BOOKING = 1;
  private static final int METHODID_GET_BOOKING_BY_MEMBER = 2;
  private static final int METHODID_GET_BOOKING_BY_COURSE = 3;
  private static final int METHODID_GET_BOOKING_BY_DATE = 4;
  private static final int METHODID_DELETE_BOOKING = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BOOKING:
          serviceImpl.createBooking((de.thws.fiw.gymmanagement.application.CreateBookingRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse>) responseObserver);
          break;
        case METHODID_GET_BOOKING:
          serviceImpl.getBooking((de.thws.fiw.gymmanagement.application.GetBookingRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetBookingResponse>) responseObserver);
          break;
        case METHODID_GET_BOOKING_BY_MEMBER:
          serviceImpl.getBookingByMember((de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>) responseObserver);
          break;
        case METHODID_GET_BOOKING_BY_COURSE:
          serviceImpl.getBookingByCourse((de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>) responseObserver);
          break;
        case METHODID_GET_BOOKING_BY_DATE:
          serviceImpl.getBookingByDate((de.thws.fiw.gymmanagement.application.GetBookingByDateRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>) responseObserver);
          break;
        case METHODID_DELETE_BOOKING:
          serviceImpl.deleteBooking((de.thws.fiw.gymmanagement.application.DeleteBookingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateBookingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateBookingRequest,
              de.thws.fiw.gymmanagement.application.GetBookingResponse>(
                service, METHODID_CREATE_BOOKING)))
        .addMethod(
          getGetBookingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetBookingRequest,
              de.thws.fiw.gymmanagement.application.GetBookingResponse>(
                service, METHODID_GET_BOOKING)))
        .addMethod(
          getGetBookingByMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest,
              de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>(
                service, METHODID_GET_BOOKING_BY_MEMBER)))
        .addMethod(
          getGetBookingByCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetBookingByCourseRequest,
              de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>(
                service, METHODID_GET_BOOKING_BY_COURSE)))
        .addMethod(
          getGetBookingByDateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetBookingByDateRequest,
              de.thws.fiw.gymmanagement.application.GetAllBookingsResponse>(
                service, METHODID_GET_BOOKING_BY_DATE)))
        .addMethod(
          getDeleteBookingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteBookingRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_BOOKING)))
        .build();
  }

  private static abstract class BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookingService");
    }
  }

  private static final class BookingServiceFileDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier {
    BookingServiceFileDescriptorSupplier() {}
  }

  private static final class BookingServiceMethodDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BookingServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingServiceFileDescriptorSupplier())
              .addMethod(getCreateBookingMethod())
              .addMethod(getGetBookingMethod())
              .addMethod(getGetBookingByMemberMethod())
              .addMethod(getGetBookingByCourseMethod())
              .addMethod(getGetBookingByDateMethod())
              .addMethod(getDeleteBookingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
