package de.thws.fiw.gymmanagement.application;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * -------------------------
 * Course Service
 * -------------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CourseServiceGrpc {

  private CourseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CourseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getCreateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourse",
      requestType = de.thws.fiw.gymmanagement.application.CreateCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getCreateCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse> getCreateCourseMethod;
    if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getCreateCourseMethod = CourseServiceGrpc.getCreateCourseMethod) == null) {
          CourseServiceGrpc.getCreateCourseMethod = getCreateCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("CreateCourse"))
              .build();
        }
      }
    }
    return getCreateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourse",
      requestType = de.thws.fiw.gymmanagement.application.UpdateCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getUpdateCourseMethod = CourseServiceGrpc.getUpdateCourseMethod) == null) {
          CourseServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("UpdateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getGetCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourse",
      requestType = de.thws.fiw.gymmanagement.application.GetCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseRequest,
      de.thws.fiw.gymmanagement.application.GetCourseResponse> getGetCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse> getGetCourseMethod;
    if ((getGetCourseMethod = CourseServiceGrpc.getGetCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseMethod = CourseServiceGrpc.getGetCourseMethod) == null) {
          CourseServiceGrpc.getGetCourseMethod = getGetCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourse"))
              .build();
        }
      }
    }
    return getGetCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourseByName",
      requestType = de.thws.fiw.gymmanagement.application.GetCourseByNameRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByNameMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByNameRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByNameMethod;
    if ((getGetCourseByNameMethod = CourseServiceGrpc.getGetCourseByNameMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseByNameMethod = CourseServiceGrpc.getGetCourseByNameMethod) == null) {
          CourseServiceGrpc.getGetCourseByNameMethod = getGetCourseByNameMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetCourseByNameRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourseByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourseByName"))
              .build();
        }
      }
    }
    return getGetCourseByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourseByTrainer",
      requestType = de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetCourseByTrainerMethod;
    if ((getGetCourseByTrainerMethod = CourseServiceGrpc.getGetCourseByTrainerMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetCourseByTrainerMethod = CourseServiceGrpc.getGetCourseByTrainerMethod) == null) {
          CourseServiceGrpc.getGetCourseByTrainerMethod = getGetCourseByTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourseByTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetCourseByTrainer"))
              .build();
        }
      }
    }
    return getGetCourseByTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllCoursesRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCourses",
      requestType = de.thws.fiw.gymmanagement.application.GetAllCoursesRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllCoursesRequest,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllCoursesRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = CourseServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getGetAllCoursesMethod = CourseServiceGrpc.getGetAllCoursesMethod) == null) {
          CourseServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetAllCoursesRequest, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("GetAllCourses"))
              .build();
        }
      }
    }
    return getGetAllCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
      com.google.protobuf.Empty> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourse",
      requestType = de.thws.fiw.gymmanagement.application.DeleteCourseRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
      com.google.protobuf.Empty> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest, com.google.protobuf.Empty> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (CourseServiceGrpc.class) {
        if ((getDeleteCourseMethod = CourseServiceGrpc.getDeleteCourseMethod) == null) {
          CourseServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteCourseRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CourseServiceMethodDescriptorSupplier("DeleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceStub>() {
        @java.lang.Override
        public CourseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceStub(channel, callOptions);
        }
      };
    return CourseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceBlockingStub>() {
        @java.lang.Override
        public CourseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceBlockingStub(channel, callOptions);
        }
      };
    return CourseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CourseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CourseServiceFutureStub>() {
        @java.lang.Override
        public CourseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CourseServiceFutureStub(channel, callOptions);
        }
      };
    return CourseServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * -------------------------
   * Course Service
   * -------------------------
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseMethod(), responseObserver);
    }

    /**
     */
    default void updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    /**
     */
    default void getCourse(de.thws.fiw.gymmanagement.application.GetCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseMethod(), responseObserver);
    }

    /**
     */
    default void getCourseByName(de.thws.fiw.gymmanagement.application.GetCourseByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseByNameMethod(), responseObserver);
    }

    /**
     */
    default void getCourseByTrainer(de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseByTrainerMethod(), responseObserver);
    }

    /**
     */
    default void getAllCourses(de.thws.fiw.gymmanagement.application.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    /**
     */
    default void deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CourseService.
   * <pre>
   * -------------------------
   * Course Service
   * -------------------------
   * </pre>
   */
  public static abstract class CourseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CourseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CourseService.
   * <pre>
   * -------------------------
   * Course Service
   * -------------------------
   * </pre>
   */
  public static final class CourseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CourseServiceStub> {
    private CourseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourse(de.thws.fiw.gymmanagement.application.GetCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseByName(de.thws.fiw.gymmanagement.application.GetCourseByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseByTrainer(de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseByTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourses(de.thws.fiw.gymmanagement.application.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CourseService.
   * <pre>
   * -------------------------
   * Course Service
   * -------------------------
   * </pre>
   */
  public static final class CourseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CourseServiceBlockingStub> {
    private CourseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetCourseResponse createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetCourseResponse updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetCourseResponse getCourse(de.thws.fiw.gymmanagement.application.GetCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllCoursesResponse getCourseByName(de.thws.fiw.gymmanagement.application.GetCourseByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllCoursesResponse getCourseByTrainer(de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseByTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllCoursesResponse getAllCourses(de.thws.fiw.gymmanagement.application.GetAllCoursesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CourseService.
   * <pre>
   * -------------------------
   * Course Service
   * -------------------------
   * </pre>
   */
  public static final class CourseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CourseServiceFutureStub> {
    private CourseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CourseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetCourseResponse> createCourse(
        de.thws.fiw.gymmanagement.application.CreateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetCourseResponse> updateCourse(
        de.thws.fiw.gymmanagement.application.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetCourseResponse> getCourse(
        de.thws.fiw.gymmanagement.application.GetCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getCourseByName(
        de.thws.fiw.gymmanagement.application.GetCourseByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getCourseByTrainer(
        de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseByTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getAllCourses(
        de.thws.fiw.gymmanagement.application.GetAllCoursesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteCourse(
        de.thws.fiw.gymmanagement.application.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COURSE = 0;
  private static final int METHODID_UPDATE_COURSE = 1;
  private static final int METHODID_GET_COURSE = 2;
  private static final int METHODID_GET_COURSE_BY_NAME = 3;
  private static final int METHODID_GET_COURSE_BY_TRAINER = 4;
  private static final int METHODID_GET_ALL_COURSES = 5;
  private static final int METHODID_DELETE_COURSE = 6;

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
        case METHODID_CREATE_COURSE:
          serviceImpl.createCourse((de.thws.fiw.gymmanagement.application.CreateCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((de.thws.fiw.gymmanagement.application.UpdateCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE:
          serviceImpl.getCourse((de.thws.fiw.gymmanagement.application.GetCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_BY_NAME:
          serviceImpl.getCourseByName((de.thws.fiw.gymmanagement.application.GetCourseByNameRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_BY_TRAINER:
          serviceImpl.getCourseByTrainer((de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((de.thws.fiw.gymmanagement.application.GetAllCoursesRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((de.thws.fiw.gymmanagement.application.DeleteCourseRequest) request,
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
          getCreateCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateCourseRequest,
              de.thws.fiw.gymmanagement.application.GetCourseResponse>(
                service, METHODID_CREATE_COURSE)))
        .addMethod(
          getUpdateCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
              de.thws.fiw.gymmanagement.application.GetCourseResponse>(
                service, METHODID_UPDATE_COURSE)))
        .addMethod(
          getGetCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetCourseRequest,
              de.thws.fiw.gymmanagement.application.GetCourseResponse>(
                service, METHODID_GET_COURSE)))
        .addMethod(
          getGetCourseByNameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetCourseByNameRequest,
              de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>(
                service, METHODID_GET_COURSE_BY_NAME)))
        .addMethod(
          getGetCourseByTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetCourseByTrainerRequest,
              de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>(
                service, METHODID_GET_COURSE_BY_TRAINER)))
        .addMethod(
          getGetAllCoursesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetAllCoursesRequest,
              de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>(
                service, METHODID_GET_ALL_COURSES)))
        .addMethod(
          getDeleteCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_COURSE)))
        .build();
  }

  private static abstract class CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseService");
    }
  }

  private static final class CourseServiceFileDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier {
    CourseServiceFileDescriptorSupplier() {}
  }

  private static final class CourseServiceMethodDescriptorSupplier
      extends CourseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CourseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CourseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseServiceFileDescriptorSupplier())
              .addMethod(getCreateCourseMethod())
              .addMethod(getUpdateCourseMethod())
              .addMethod(getGetCourseMethod())
              .addMethod(getGetCourseByNameMethod())
              .addMethod(getGetCourseByTrainerMethod())
              .addMethod(getGetAllCoursesMethod())
              .addMethod(getDeleteCourseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
