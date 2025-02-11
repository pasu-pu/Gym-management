package de.thws.fiw.gymmanagement.application;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * -------------------------
 * Member Service
 * -------------------------
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: gym.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MemberServiceGrpc {

  private MemberServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MemberService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getCreateMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMember",
      requestType = de.thws.fiw.gymmanagement.application.CreateMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getCreateMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse> getCreateMemberMethod;
    if ((getCreateMemberMethod = MemberServiceGrpc.getCreateMemberMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getCreateMemberMethod = MemberServiceGrpc.getCreateMemberMethod) == null) {
          MemberServiceGrpc.getCreateMemberMethod = getCreateMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("CreateMember"))
              .build();
        }
      }
    }
    return getCreateMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getUpdateMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMember",
      requestType = de.thws.fiw.gymmanagement.application.UpdateMemberRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetMemberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
      de.thws.fiw.gymmanagement.application.GetMemberResponse> getUpdateMemberMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse> getUpdateMemberMethod;
    if ((getUpdateMemberMethod = MemberServiceGrpc.getUpdateMemberMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getUpdateMemberMethod = MemberServiceGrpc.getUpdateMemberMethod) == null) {
          MemberServiceGrpc.getUpdateMemberMethod = getUpdateMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("UpdateMember"))
              .build();
        }
      }
    }
    return getUpdateMemberMethod;
  }

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
    if ((getGetMemberMethod = MemberServiceGrpc.getGetMemberMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getGetMemberMethod = MemberServiceGrpc.getGetMemberMethod) == null) {
          MemberServiceGrpc.getGetMemberMethod = getGetMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetMemberRequest, de.thws.fiw.gymmanagement.application.GetMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("GetMember"))
              .build();
        }
      }
    }
    return getGetMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllMembersRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllMembers",
      requestType = de.thws.fiw.gymmanagement.application.GetAllMembersRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllMembersRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetAllMembersRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetAllMembersMethod;
    if ((getGetAllMembersMethod = MemberServiceGrpc.getGetAllMembersMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getGetAllMembersMethod = MemberServiceGrpc.getGetAllMembersMethod) == null) {
          MemberServiceGrpc.getGetAllMembersMethod = getGetAllMembersMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetAllMembersRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllMembers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllMembersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("GetAllMembers"))
              .build();
        }
      }
    }
    return getGetAllMembersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMemberByName",
      requestType = de.thws.fiw.gymmanagement.application.GetMemberByNameRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByNameRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByNameMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByNameRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByNameMethod;
    if ((getGetMemberByNameMethod = MemberServiceGrpc.getGetMemberByNameMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getGetMemberByNameMethod = MemberServiceGrpc.getGetMemberByNameMethod) == null) {
          MemberServiceGrpc.getGetMemberByNameMethod = getGetMemberByNameMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetMemberByNameRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMemberByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("GetMemberByName"))
              .build();
        }
      }
    }
    return getGetMemberByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMemberByMembership",
      requestType = de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest,
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByMembershipMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getGetMemberByMembershipMethod;
    if ((getGetMemberByMembershipMethod = MemberServiceGrpc.getGetMemberByMembershipMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getGetMemberByMembershipMethod = MemberServiceGrpc.getGetMemberByMembershipMethod) == null) {
          MemberServiceGrpc.getGetMemberByMembershipMethod = getGetMemberByMembershipMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest, de.thws.fiw.gymmanagement.application.GetAllMembersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMemberByMembership"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("GetMemberByMembership"))
              .build();
        }
      }
    }
    return getGetMemberByMembershipMethod;
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
    if ((getDeleteMemberMethod = MemberServiceGrpc.getDeleteMemberMethod) == null) {
      synchronized (MemberServiceGrpc.class) {
        if ((getDeleteMemberMethod = MemberServiceGrpc.getDeleteMemberMethod) == null) {
          MemberServiceGrpc.getDeleteMemberMethod = getDeleteMemberMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteMemberRequest, de.thws.fiw.gymmanagement.application.DeleteMemberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteMemberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MemberServiceMethodDescriptorSupplier("DeleteMember"))
              .build();
        }
      }
    }
    return getDeleteMemberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MemberServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemberServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MemberServiceStub>() {
        @java.lang.Override
        public MemberServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MemberServiceStub(channel, callOptions);
        }
      };
    return MemberServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MemberServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemberServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MemberServiceBlockingStub>() {
        @java.lang.Override
        public MemberServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MemberServiceBlockingStub(channel, callOptions);
        }
      };
    return MemberServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MemberServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemberServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MemberServiceFutureStub>() {
        @java.lang.Override
        public MemberServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MemberServiceFutureStub(channel, callOptions);
        }
      };
    return MemberServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * -------------------------
   * Member Service
   * -------------------------
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMemberMethod(), responseObserver);
    }

    /**
     */
    default void updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMemberMethod(), responseObserver);
    }

    /**
     */
    default void getMember(de.thws.fiw.gymmanagement.application.GetMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemberMethod(), responseObserver);
    }

    /**
     */
    default void getAllMembers(de.thws.fiw.gymmanagement.application.GetAllMembersRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMembersMethod(), responseObserver);
    }

    /**
     */
    default void getMemberByName(de.thws.fiw.gymmanagement.application.GetMemberByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemberByNameMethod(), responseObserver);
    }

    /**
     */
    default void getMemberByMembership(de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemberByMembershipMethod(), responseObserver);
    }

    /**
     */
    default void deleteMember(de.thws.fiw.gymmanagement.application.DeleteMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteMemberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMemberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MemberService.
   * <pre>
   * -------------------------
   * Member Service
   * -------------------------
   * </pre>
   */
  public static abstract class MemberServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MemberServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MemberService.
   * <pre>
   * -------------------------
   * Member Service
   * -------------------------
   * </pre>
   */
  public static final class MemberServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MemberServiceStub> {
    private MemberServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemberServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemberServiceStub(channel, callOptions);
    }

    /**
     */
    public void createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMemberMethod(), getCallOptions()), request, responseObserver);
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
    public void getAllMembers(de.thws.fiw.gymmanagement.application.GetAllMembersRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllMembersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMemberByName(de.thws.fiw.gymmanagement.application.GetMemberByNameRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMemberByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMemberByMembership(de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMemberByMembershipMethod(), getCallOptions()), request, responseObserver);
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
   * A stub to allow clients to do synchronous rpc calls to service MemberService.
   * <pre>
   * -------------------------
   * Member Service
   * -------------------------
   * </pre>
   */
  public static final class MemberServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MemberServiceBlockingStub> {
    private MemberServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemberServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemberServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse createMember(de.thws.fiw.gymmanagement.application.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse updateMember(de.thws.fiw.gymmanagement.application.UpdateMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse getMember(de.thws.fiw.gymmanagement.application.GetMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemberMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getAllMembers(de.thws.fiw.gymmanagement.application.GetAllMembersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllMembersMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getMemberByName(de.thws.fiw.gymmanagement.application.GetMemberByNameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemberByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getMemberByMembership(de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemberByMembershipMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.DeleteMemberResponse deleteMember(de.thws.fiw.gymmanagement.application.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MemberService.
   * <pre>
   * -------------------------
   * Member Service
   * -------------------------
   * </pre>
   */
  public static final class MemberServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MemberServiceFutureStub> {
    private MemberServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemberServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemberServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetMemberResponse> createMember(
        de.thws.fiw.gymmanagement.application.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetMemberResponse> updateMember(
        de.thws.fiw.gymmanagement.application.UpdateMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMemberMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getAllMembers(
        de.thws.fiw.gymmanagement.application.GetAllMembersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllMembersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getMemberByName(
        de.thws.fiw.gymmanagement.application.GetMemberByNameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMemberByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllMembersResponse> getMemberByMembership(
        de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMemberByMembershipMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.DeleteMemberResponse> deleteMember(
        de.thws.fiw.gymmanagement.application.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MEMBER = 0;
  private static final int METHODID_UPDATE_MEMBER = 1;
  private static final int METHODID_GET_MEMBER = 2;
  private static final int METHODID_GET_ALL_MEMBERS = 3;
  private static final int METHODID_GET_MEMBER_BY_NAME = 4;
  private static final int METHODID_GET_MEMBER_BY_MEMBERSHIP = 5;
  private static final int METHODID_DELETE_MEMBER = 6;

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
        case METHODID_CREATE_MEMBER:
          serviceImpl.createMember((de.thws.fiw.gymmanagement.application.CreateMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBER:
          serviceImpl.updateMember((de.thws.fiw.gymmanagement.application.UpdateMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBER:
          serviceImpl.getMember((de.thws.fiw.gymmanagement.application.GetMemberRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetMemberResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_MEMBERS:
          serviceImpl.getAllMembers((de.thws.fiw.gymmanagement.application.GetAllMembersRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBER_BY_NAME:
          serviceImpl.getMemberByName((de.thws.fiw.gymmanagement.application.GetMemberByNameRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse>) responseObserver);
          break;
        case METHODID_GET_MEMBER_BY_MEMBERSHIP:
          serviceImpl.getMemberByMembership((de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllMembersResponse>) responseObserver);
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
          getCreateMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateMemberRequest,
              de.thws.fiw.gymmanagement.application.GetMemberResponse>(
                service, METHODID_CREATE_MEMBER)))
        .addMethod(
          getUpdateMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateMemberRequest,
              de.thws.fiw.gymmanagement.application.GetMemberResponse>(
                service, METHODID_UPDATE_MEMBER)))
        .addMethod(
          getGetMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetMemberRequest,
              de.thws.fiw.gymmanagement.application.GetMemberResponse>(
                service, METHODID_GET_MEMBER)))
        .addMethod(
          getGetAllMembersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetAllMembersRequest,
              de.thws.fiw.gymmanagement.application.GetAllMembersResponse>(
                service, METHODID_GET_ALL_MEMBERS)))
        .addMethod(
          getGetMemberByNameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetMemberByNameRequest,
              de.thws.fiw.gymmanagement.application.GetAllMembersResponse>(
                service, METHODID_GET_MEMBER_BY_NAME)))
        .addMethod(
          getGetMemberByMembershipMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetMemberByMembershipRequest,
              de.thws.fiw.gymmanagement.application.GetAllMembersResponse>(
                service, METHODID_GET_MEMBER_BY_MEMBERSHIP)))
        .addMethod(
          getDeleteMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteMemberRequest,
              de.thws.fiw.gymmanagement.application.DeleteMemberResponse>(
                service, METHODID_DELETE_MEMBER)))
        .build();
  }

  private static abstract class MemberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MemberServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MemberService");
    }
  }

  private static final class MemberServiceFileDescriptorSupplier
      extends MemberServiceBaseDescriptorSupplier {
    MemberServiceFileDescriptorSupplier() {}
  }

  private static final class MemberServiceMethodDescriptorSupplier
      extends MemberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MemberServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MemberServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MemberServiceFileDescriptorSupplier())
              .addMethod(getCreateMemberMethod())
              .addMethod(getUpdateMemberMethod())
              .addMethod(getGetMemberMethod())
              .addMethod(getGetAllMembersMethod())
              .addMethod(getGetMemberByNameMethod())
              .addMethod(getGetMemberByMembershipMethod())
              .addMethod(getDeleteMemberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
