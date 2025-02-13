package de.thws.fiw.gymmanagement.application;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * -------------------------
 * Trainer Service
 * -------------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrainerServiceGrpc {

  private TrainerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TrainerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getCreateTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrainer",
      requestType = de.thws.fiw.gymmanagement.application.CreateTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getCreateTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse> getCreateTrainerMethod;
    if ((getCreateTrainerMethod = TrainerServiceGrpc.getCreateTrainerMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getCreateTrainerMethod = TrainerServiceGrpc.getCreateTrainerMethod) == null) {
          TrainerServiceGrpc.getCreateTrainerMethod = getCreateTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("CreateTrainer"))
              .build();
        }
      }
    }
    return getCreateTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getUpdateTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrainer",
      requestType = de.thws.fiw.gymmanagement.application.UpdateTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getUpdateTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse> getUpdateTrainerMethod;
    if ((getUpdateTrainerMethod = TrainerServiceGrpc.getUpdateTrainerMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getUpdateTrainerMethod = TrainerServiceGrpc.getUpdateTrainerMethod) == null) {
          TrainerServiceGrpc.getUpdateTrainerMethod = getUpdateTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("UpdateTrainer"))
              .build();
        }
      }
    }
    return getUpdateTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getGetTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrainer",
      requestType = de.thws.fiw.gymmanagement.application.GetTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetTrainerResponse> getGetTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse> getGetTrainerMethod;
    if ((getGetTrainerMethod = TrainerServiceGrpc.getGetTrainerMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getGetTrainerMethod = TrainerServiceGrpc.getGetTrainerMethod) == null) {
          TrainerServiceGrpc.getGetTrainerMethod = getGetTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("GetTrainer"))
              .build();
        }
      }
    }
    return getGetTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllTrainersRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllTrainers",
      requestType = de.thws.fiw.gymmanagement.application.GetAllTrainersRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllTrainersRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllTrainersRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod;
    if ((getGetAllTrainersMethod = TrainerServiceGrpc.getGetAllTrainersMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getGetAllTrainersMethod = TrainerServiceGrpc.getGetAllTrainersMethod) == null) {
          TrainerServiceGrpc.getGetAllTrainersMethod = getGetAllTrainersMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetAllTrainersRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllTrainers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllTrainersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("GetAllTrainers"))
              .build();
        }
      }
    }
    return getGetAllTrainersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrainerByName",
      requestType = de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByNameMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByNameMethod;
    if ((getGetTrainerByNameMethod = TrainerServiceGrpc.getGetTrainerByNameMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getGetTrainerByNameMethod = TrainerServiceGrpc.getGetTrainerByNameMethod) == null) {
          TrainerServiceGrpc.getGetTrainerByNameMethod = getGetTrainerByNameMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainerByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("GetTrainerByName"))
              .build();
        }
      }
    }
    return getGetTrainerByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByExpertiseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrainerByExpertise",
      requestType = de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByExpertiseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetTrainerByExpertiseMethod;
    if ((getGetTrainerByExpertiseMethod = TrainerServiceGrpc.getGetTrainerByExpertiseMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getGetTrainerByExpertiseMethod = TrainerServiceGrpc.getGetTrainerByExpertiseMethod) == null) {
          TrainerServiceGrpc.getGetTrainerByExpertiseMethod = getGetTrainerByExpertiseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainerByExpertise"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("GetTrainerByExpertise"))
              .build();
        }
      }
    }
    return getGetTrainerByExpertiseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
      com.google.protobuf.Empty> getDeleteTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrainer",
      requestType = de.thws.fiw.gymmanagement.application.DeleteTrainerRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
      com.google.protobuf.Empty> getDeleteTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest, com.google.protobuf.Empty> getDeleteTrainerMethod;
    if ((getDeleteTrainerMethod = TrainerServiceGrpc.getDeleteTrainerMethod) == null) {
      synchronized (TrainerServiceGrpc.class) {
        if ((getDeleteTrainerMethod = TrainerServiceGrpc.getDeleteTrainerMethod) == null) {
          TrainerServiceGrpc.getDeleteTrainerMethod = getDeleteTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new TrainerServiceMethodDescriptorSupplier("DeleteTrainer"))
              .build();
        }
      }
    }
    return getDeleteTrainerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrainerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceStub>() {
        @java.lang.Override
        public TrainerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainerServiceStub(channel, callOptions);
        }
      };
    return TrainerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrainerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceBlockingStub>() {
        @java.lang.Override
        public TrainerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainerServiceBlockingStub(channel, callOptions);
        }
      };
    return TrainerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrainerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainerServiceFutureStub>() {
        @java.lang.Override
        public TrainerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainerServiceFutureStub(channel, callOptions);
        }
      };
    return TrainerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * -------------------------
   * Trainer Service
   * -------------------------
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTrainerMethod(), responseObserver);
    }

    /**
     */
    default void updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTrainerMethod(), responseObserver);
    }

    /**
     */
    default void getTrainer(de.thws.fiw.gymmanagement.application.GetTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainerMethod(), responseObserver);
    }

    /**
     */
    default void getAllTrainers(de.thws.fiw.gymmanagement.application.GetAllTrainersRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllTrainersMethod(), responseObserver);
    }

    /**
     */
    default void getTrainerByName(de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainerByNameMethod(), responseObserver);
    }

    /**
     */
    default void getTrainerByExpertise(de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainerByExpertiseMethod(), responseObserver);
    }

    /**
     */
    default void deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTrainerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TrainerService.
   * <pre>
   * -------------------------
   * Trainer Service
   * -------------------------
   * </pre>
   */
  public static abstract class TrainerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TrainerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TrainerService.
   * <pre>
   * -------------------------
   * Trainer Service
   * -------------------------
   * </pre>
   */
  public static final class TrainerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TrainerServiceStub> {
    private TrainerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTrainer(de.thws.fiw.gymmanagement.application.GetTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllTrainers(de.thws.fiw.gymmanagement.application.GetAllTrainersRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllTrainersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTrainerByName(de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrainerByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTrainerByExpertise(de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrainerByExpertiseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTrainerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TrainerService.
   * <pre>
   * -------------------------
   * Trainer Service
   * -------------------------
   * </pre>
   */
  public static final class TrainerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TrainerServiceBlockingStub> {
    private TrainerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetTrainerResponse createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetTrainerResponse updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetTrainerResponse getTrainer(de.thws.fiw.gymmanagement.application.GetTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllTrainersResponse getAllTrainers(de.thws.fiw.gymmanagement.application.GetAllTrainersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllTrainersMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllTrainersResponse getTrainerByName(de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrainerByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllTrainersResponse getTrainerByExpertise(de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrainerByExpertiseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTrainerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TrainerService.
   * <pre>
   * -------------------------
   * Trainer Service
   * -------------------------
   * </pre>
   */
  public static final class TrainerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TrainerServiceFutureStub> {
    private TrainerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetTrainerResponse> createTrainer(
        de.thws.fiw.gymmanagement.application.CreateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetTrainerResponse> updateTrainer(
        de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetTrainerResponse> getTrainer(
        de.thws.fiw.gymmanagement.application.GetTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getAllTrainers(
        de.thws.fiw.gymmanagement.application.GetAllTrainersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllTrainersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getTrainerByName(
        de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrainerByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getTrainerByExpertise(
        de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrainerByExpertiseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTrainer(
        de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTrainerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TRAINER = 0;
  private static final int METHODID_UPDATE_TRAINER = 1;
  private static final int METHODID_GET_TRAINER = 2;
  private static final int METHODID_GET_ALL_TRAINERS = 3;
  private static final int METHODID_GET_TRAINER_BY_NAME = 4;
  private static final int METHODID_GET_TRAINER_BY_EXPERTISE = 5;
  private static final int METHODID_DELETE_TRAINER = 6;

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
        case METHODID_CREATE_TRAINER:
          serviceImpl.createTrainer((de.thws.fiw.gymmanagement.application.CreateTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TRAINER:
          serviceImpl.updateTrainer((de.thws.fiw.gymmanagement.application.UpdateTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse>) responseObserver);
          break;
        case METHODID_GET_TRAINER:
          serviceImpl.getTrainer((de.thws.fiw.gymmanagement.application.GetTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_TRAINERS:
          serviceImpl.getAllTrainers((de.thws.fiw.gymmanagement.application.GetAllTrainersRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>) responseObserver);
          break;
        case METHODID_GET_TRAINER_BY_NAME:
          serviceImpl.getTrainerByName((de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>) responseObserver);
          break;
        case METHODID_GET_TRAINER_BY_EXPERTISE:
          serviceImpl.getTrainerByExpertise((de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>) responseObserver);
          break;
        case METHODID_DELETE_TRAINER:
          serviceImpl.deleteTrainer((de.thws.fiw.gymmanagement.application.DeleteTrainerRequest) request,
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
          getCreateTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
              de.thws.fiw.gymmanagement.application.GetTrainerResponse>(
                service, METHODID_CREATE_TRAINER)))
        .addMethod(
          getUpdateTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
              de.thws.fiw.gymmanagement.application.GetTrainerResponse>(
                service, METHODID_UPDATE_TRAINER)))
        .addMethod(
          getGetTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetTrainerRequest,
              de.thws.fiw.gymmanagement.application.GetTrainerResponse>(
                service, METHODID_GET_TRAINER)))
        .addMethod(
          getGetAllTrainersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetAllTrainersRequest,
              de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>(
                service, METHODID_GET_ALL_TRAINERS)))
        .addMethod(
          getGetTrainerByNameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetTrainerByNameRequest,
              de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>(
                service, METHODID_GET_TRAINER_BY_NAME)))
        .addMethod(
          getGetTrainerByExpertiseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetTrainerByExpertiseRequest,
              de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>(
                service, METHODID_GET_TRAINER_BY_EXPERTISE)))
        .addMethod(
          getDeleteTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_TRAINER)))
        .build();
  }

  private static abstract class TrainerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrainerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrainerService");
    }
  }

  private static final class TrainerServiceFileDescriptorSupplier
      extends TrainerServiceBaseDescriptorSupplier {
    TrainerServiceFileDescriptorSupplier() {}
  }

  private static final class TrainerServiceMethodDescriptorSupplier
      extends TrainerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TrainerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TrainerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrainerServiceFileDescriptorSupplier())
              .addMethod(getCreateTrainerMethod())
              .addMethod(getUpdateTrainerMethod())
              .addMethod(getGetTrainerMethod())
              .addMethod(getGetAllTrainersMethod())
              .addMethod(getGetTrainerByNameMethod())
              .addMethod(getGetTrainerByExpertiseMethod())
              .addMethod(getDeleteTrainerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
