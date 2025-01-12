package de.thws.fiw.gymmanagement.application;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GymServiceGrpc {

  private GymServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "GymService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getGetMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMember",
      requestType = de.thws.fiw.gymmanagement.application.GetMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getGetMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse> getGetMemberMethod;
    if ((getGetMemberMethod = GymServiceGrpc.getGetMemberMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetMemberMethod = GymServiceGrpc.getGetMemberMethod) == null) {
          GymServiceGrpc.getGetMemberMethod = getGetMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetMember"))
              .build();
        }
      }
    }
    return getGetMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest,
      de.thws.fiw.gymmanagement.application.CreateMemberResponse> getCreateMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMember",
      requestType = de.thws.fiw.gymmanagement.application.CreateMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.CreateMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest,
      de.thws.fiw.gymmanagement.application.CreateMemberResponse> getCreateMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest, de.thws.fiw.gymmanagement.application.CreateMemberResponse> getCreateMemberMethod;
    if ((getCreateMemberMethod = GymServiceGrpc.getCreateMemberMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getCreateMemberMethod = GymServiceGrpc.getCreateMemberMethod) == null) {
          GymServiceGrpc.getCreateMemberMethod = getCreateMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateMemberRequest, de.thws.fiw.gymmanagement.application.CreateMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("CreateMember"))
              .build();
        }
      }
    }
    return getCreateMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMembers",
      requestType = de.thws.fiw.gymmanagement.application.Empty.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod;
    if ((getGetAllMembersMethod = GymServiceGrpc.getGetAllMembersMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetAllMembersMethod = GymServiceGrpc.getGetAllMembersMethod) == null) {
          GymServiceGrpc.getGetAllMembersMethod = getGetAllMembersMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllMembersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllMembers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetAllMembers"))
              .build();
        }
      }
    }
    return getGetAllMembersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
      de.thws.fiw.gymmanagement.application.UpdateMemberResponse> getUpdateMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMember",
      requestType = de.thws.fiw.gymmanagement.application.UpdateMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.UpdateMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
      de.thws.fiw.gymmanagement.application.UpdateMemberResponse> getUpdateMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest, de.thws.fiw.gymmanagement.application.UpdateMemberResponse> getUpdateMemberMethod;
    if ((getUpdateMemberMethod = GymServiceGrpc.getUpdateMemberMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getUpdateMemberMethod = GymServiceGrpc.getUpdateMemberMethod) == null) {
          GymServiceGrpc.getUpdateMemberMethod = getUpdateMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateMemberRequest, de.thws.fiw.gymmanagement.application.UpdateMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("UpdateMember"))
              .build();
        }
      }
    }
    return getUpdateMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteMemberRequest,
      de.thws.fiw.gymmanagement.application.DeleteMemberResponse> getDeleteMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMember",
      requestType = de.thws.fiw.gymmanagement.application.DeleteMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.DeleteMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteMemberRequest,
      de.thws.fiw.gymmanagement.application.DeleteMemberResponse> getDeleteMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteMemberRequest, de.thws.fiw.gymmanagement.application.DeleteMemberResponse> getDeleteMemberMethod;
    if ((getDeleteMemberMethod = GymServiceGrpc.getDeleteMemberMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getDeleteMemberMethod = GymServiceGrpc.getDeleteMemberMethod) == null) {
          GymServiceGrpc.getDeleteMemberMethod = getDeleteMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteMemberRequest, de.thws.fiw.gymmanagement.application.DeleteMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("DeleteMember"))
              .build();
        }
      }
    }
    return getDeleteMemberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GymServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceStub>() {
        @java.lang.Override
        public GymServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceStub(channel, callOptions);
        }
      };
    return GymServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GymServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceBlockingStub>() {
        @java.lang.Override
        public GymServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceBlockingStub(channel, callOptions);
        }
      };
    return GymServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GymServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GymServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GymServiceFutureStub>() {
        @java.lang.Override
        public GymServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GymServiceFutureStub(channel, callOptions);
        }
      };
    return GymServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getMember(de.thws.fiw.gymmanagement.application.GetMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemberMethod(), responseObserver);
    }

    /**
     */
    default void createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMemberMethod(), responseObserver);
    }

    /**
     */
    default void getAllMembers(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMembersMethod(), responseObserver);
    }

    /**
     */
    default void updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMemberMethod(), responseObserver);
    }

    /**
     */
    default void deleteMember(de.thws.fiw.gymmanagement.application.DeleteMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMemberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GymService.
   */
  public static abstract class GymServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GymServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GymService.
   */
  public static final class GymServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GymServiceStub> {
    private GymServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMember(de.thws.fiw.gymmanagement.application.GetMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllMembers(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMembersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteMember(de.thws.fiw.gymmanagement.application.DeleteMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GymService.
   */
  public static final class GymServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GymServiceBlockingStub> {
    private GymServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse getMember(de.thws.fiw.gymmanagement.application.GetMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.CreateMemberResponse createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getAllMembers(de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMembersMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.UpdateMemberResponse updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.DeleteMemberResponse deleteMember(de.thws.fiw.gymmanagement.application.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GymService.
   */
  public static final class GymServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GymServiceFutureStub> {
    private GymServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GymServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetMemberResponse> getMember(
        de.thws.fiw.gymmanagement.application.GetMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.CreateMemberResponse> createMember(
        de.thws.fiw.gymmanagement.application.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getAllMembers(
        de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMembersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.UpdateMemberResponse> updateMember(
        de.thws.fiw.gymmanagement.application.UpdateMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.DeleteMemberResponse> deleteMember(
        de.thws.fiw.gymmanagement.application.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MEMBER = 0;
  private static final int METHODID_CREATE_MEMBER = 1;
  private static final int METHODID_GET_ALL_MEMBERS = 2;
  private static final int METHODID_UPDATE_MEMBER = 3;
  private static final int METHODID_DELETE_MEMBER = 4;

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
        case METHODID_GET_MEMBER:
          serviceImpl.getMember((de.thws.fiw.gymmanagement.application.GetMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse>) responseObserver);
          break;
        case METHODID_CREATE_MEMBER:
          serviceImpl.createMember((de.thws.fiw.gymmanagement.application.CreateMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateMemberResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MEMBERS:
          serviceImpl.getAllMembers((de.thws.fiw.gymmanagement.application.Empty) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBER:
          serviceImpl.updateMember((de.thws.fiw.gymmanagement.application.UpdateMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateMemberResponse>) responseObserver);
          break;
        case METHODID_DELETE_MEMBER:
          serviceImpl.deleteMember((de.thws.fiw.gymmanagement.application.DeleteMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteMemberResponse>) responseObserver);
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
          getGetMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetMemberRequest,
              de.thws.fiw.gymmanagement.application.GetMemberResponse>(
                service, METHODID_GET_MEMBER)))
        .addMethod(
          getCreateMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateMemberRequest,
              de.thws.fiw.gymmanagement.application.CreateMemberResponse>(
                service, METHODID_CREATE_MEMBER)))
        .addMethod(
          getGetAllMembersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.Empty,
              de.thws.fiw.gymmanagement.application.GetAllMembersResponse>(
                service, METHODID_GET_ALL_MEMBERS)))
        .addMethod(
          getUpdateMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
              de.thws.fiw.gymmanagement.application.UpdateMemberResponse>(
                service, METHODID_UPDATE_MEMBER)))
        .addMethod(
          getDeleteMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteMemberRequest,
              de.thws.fiw.gymmanagement.application.DeleteMemberResponse>(
                service, METHODID_DELETE_MEMBER)))
        .build();
  }

  private static abstract class GymServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GymServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GymService");
    }
  }

  private static final class GymServiceFileDescriptorSupplier
      extends GymServiceBaseDescriptorSupplier {
    GymServiceFileDescriptorSupplier() {}
  }

  private static final class GymServiceMethodDescriptorSupplier
      extends GymServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GymServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GymServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GymServiceFileDescriptorSupplier())
              .addMethod(getGetMemberMethod())
              .addMethod(getCreateMemberMethod())
              .addMethod(getGetAllMembersMethod())
              .addMethod(getUpdateMemberMethod())
              .addMethod(getDeleteMemberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
