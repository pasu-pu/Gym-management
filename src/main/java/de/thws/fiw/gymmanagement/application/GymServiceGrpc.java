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

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
      de.thws.fiw.gymmanagement.application.CreateTrainerResponse> getCreateTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrainer",
      requestType = de.thws.fiw.gymmanagement.application.CreateTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.CreateTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
      de.thws.fiw.gymmanagement.application.CreateTrainerResponse> getCreateTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateTrainerRequest, de.thws.fiw.gymmanagement.application.CreateTrainerResponse> getCreateTrainerMethod;
    if ((getCreateTrainerMethod = GymServiceGrpc.getCreateTrainerMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getCreateTrainerMethod = GymServiceGrpc.getCreateTrainerMethod) == null) {
          GymServiceGrpc.getCreateTrainerMethod = getCreateTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateTrainerRequest, de.thws.fiw.gymmanagement.application.CreateTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("CreateTrainer"))
              .build();
        }
      }
    }
    return getCreateTrainerMethod;
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
    if ((getGetTrainerMethod = GymServiceGrpc.getGetTrainerMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetTrainerMethod = GymServiceGrpc.getGetTrainerMethod) == null) {
          GymServiceGrpc.getGetTrainerMethod = getGetTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetTrainerRequest, de.thws.fiw.gymmanagement.application.GetTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetTrainer"))
              .build();
        }
      }
    }
    return getGetTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllTrainers",
      requestType = de.thws.fiw.gymmanagement.application.Empty.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> getGetAllTrainersMethod;
    if ((getGetAllTrainersMethod = GymServiceGrpc.getGetAllTrainersMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetAllTrainersMethod = GymServiceGrpc.getGetAllTrainersMethod) == null) {
          GymServiceGrpc.getGetAllTrainersMethod = getGetAllTrainersMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllTrainers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllTrainersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetAllTrainers"))
              .build();
        }
      }
    }
    return getGetAllTrainersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
      de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> getUpdateTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrainer",
      requestType = de.thws.fiw.gymmanagement.application.UpdateTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.UpdateTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
      de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> getUpdateTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest, de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> getUpdateTrainerMethod;
    if ((getUpdateTrainerMethod = GymServiceGrpc.getUpdateTrainerMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getUpdateTrainerMethod = GymServiceGrpc.getUpdateTrainerMethod) == null) {
          GymServiceGrpc.getUpdateTrainerMethod = getUpdateTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateTrainerRequest, de.thws.fiw.gymmanagement.application.UpdateTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("UpdateTrainer"))
              .build();
        }
      }
    }
    return getUpdateTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
      de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> getDeleteTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrainer",
      requestType = de.thws.fiw.gymmanagement.application.DeleteTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.DeleteTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
      de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> getDeleteTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest, de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> getDeleteTrainerMethod;
    if ((getDeleteTrainerMethod = GymServiceGrpc.getDeleteTrainerMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getDeleteTrainerMethod = GymServiceGrpc.getDeleteTrainerMethod) == null) {
          GymServiceGrpc.getDeleteTrainerMethod = getDeleteTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteTrainerRequest, de.thws.fiw.gymmanagement.application.DeleteTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("DeleteTrainer"))
              .build();
        }
      }
    }
    return getDeleteTrainerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest,
      de.thws.fiw.gymmanagement.application.CreateCourseResponse> getCreateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCourse",
      requestType = de.thws.fiw.gymmanagement.application.CreateCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.CreateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest,
      de.thws.fiw.gymmanagement.application.CreateCourseResponse> getCreateCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.CreateCourseRequest, de.thws.fiw.gymmanagement.application.CreateCourseResponse> getCreateCourseMethod;
    if ((getCreateCourseMethod = GymServiceGrpc.getCreateCourseMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getCreateCourseMethod = GymServiceGrpc.getCreateCourseMethod) == null) {
          GymServiceGrpc.getCreateCourseMethod = getCreateCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.CreateCourseRequest, de.thws.fiw.gymmanagement.application.CreateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.CreateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("CreateCourse"))
              .build();
        }
      }
    }
    return getCreateCourseMethod;
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
    if ((getGetCourseMethod = GymServiceGrpc.getGetCourseMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetCourseMethod = GymServiceGrpc.getGetCourseMethod) == null) {
          GymServiceGrpc.getGetCourseMethod = getGetCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetCourseRequest, de.thws.fiw.gymmanagement.application.GetCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetCourse"))
              .build();
        }
      }
    }
    return getGetCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCourses",
      requestType = de.thws.fiw.gymmanagement.application.Empty.class,
      responseType = de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty,
      de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = GymServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetAllCoursesMethod = GymServiceGrpc.getGetAllCoursesMethod) == null) {
          GymServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.Empty, de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetAllCoursesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetAllCourses"))
              .build();
        }
      }
    }
    return getGetAllCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
      de.thws.fiw.gymmanagement.application.UpdateCourseResponse> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCourse",
      requestType = de.thws.fiw.gymmanagement.application.UpdateCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.UpdateCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
      de.thws.fiw.gymmanagement.application.UpdateCourseResponse> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.UpdateCourseRequest, de.thws.fiw.gymmanagement.application.UpdateCourseResponse> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = GymServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getUpdateCourseMethod = GymServiceGrpc.getUpdateCourseMethod) == null) {
          GymServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.UpdateCourseRequest, de.thws.fiw.gymmanagement.application.UpdateCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.UpdateCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("UpdateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
      de.thws.fiw.gymmanagement.application.DeleteCourseResponse> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourse",
      requestType = de.thws.fiw.gymmanagement.application.DeleteCourseRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.DeleteCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
      de.thws.fiw.gymmanagement.application.DeleteCourseResponse> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.DeleteCourseRequest, de.thws.fiw.gymmanagement.application.DeleteCourseResponse> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = GymServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getDeleteCourseMethod = GymServiceGrpc.getDeleteCourseMethod) == null) {
          GymServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.DeleteCourseRequest, de.thws.fiw.gymmanagement.application.DeleteCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.DeleteCourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("DeleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> getGetCoursesByTrainerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCoursesByTrainer",
      requestType = de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest.class,
      responseType = de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest,
      de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> getGetCoursesByTrainerMethod() {
    io.grpc.MethodDescriptor<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest, de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> getGetCoursesByTrainerMethod;
    if ((getGetCoursesByTrainerMethod = GymServiceGrpc.getGetCoursesByTrainerMethod) == null) {
      synchronized (GymServiceGrpc.class) {
        if ((getGetCoursesByTrainerMethod = GymServiceGrpc.getGetCoursesByTrainerMethod) == null) {
          GymServiceGrpc.getGetCoursesByTrainerMethod = getGetCoursesByTrainerMethod =
              io.grpc.MethodDescriptor.<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest, de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCoursesByTrainer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GymServiceMethodDescriptorSupplier("GetCoursesByTrainer"))
              .build();
        }
      }
    }
    return getGetCoursesByTrainerMethod;
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

    /**
     */
    default void createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTrainerMethod(), responseObserver);
    }

    /**
     */
    default void getTrainer(de.thws.fiw.gymmanagement.application.GetTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainerMethod(), responseObserver);
    }

    /**
     */
    default void getAllTrainers(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllTrainersMethod(), responseObserver);
    }

    /**
     */
    default void updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTrainerMethod(), responseObserver);
    }

    /**
     */
    default void deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTrainerMethod(), responseObserver);
    }

    /**
     */
    default void createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCourseMethod(), responseObserver);
    }

    /**
     */
    default void getCourse(de.thws.fiw.gymmanagement.application.GetCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseMethod(), responseObserver);
    }

    /**
     */
    default void getAllCourses(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    /**
     */
    default void updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    /**
     */
    default void deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    default void getCoursesByTrainer(de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCoursesByTrainerMethod(), responseObserver);
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

    /**
     */
    public void createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTrainerMethod(), getCallOptions()), request, responseObserver);
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
    public void getAllTrainers(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllTrainersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTrainerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request, responseObserver);
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
    public void getAllCourses(de.thws.fiw.gymmanagement.application.Empty request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteCourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCoursesByTrainer(de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest request,
        io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCoursesByTrainerMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public de.thws.fiw.gymmanagement.application.CreateTrainerResponse createTrainer(de.thws.fiw.gymmanagement.application.CreateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetTrainerResponse getTrainer(de.thws.fiw.gymmanagement.application.GetTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllTrainersResponse getAllTrainers(de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllTrainersMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.UpdateTrainerResponse updateTrainer(de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.DeleteTrainerResponse deleteTrainer(de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTrainerMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.CreateCourseResponse createCourse(de.thws.fiw.gymmanagement.application.CreateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetCourseResponse getCourse(de.thws.fiw.gymmanagement.application.GetCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetAllCoursesResponse getAllCourses(de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.UpdateCourseResponse updateCourse(de.thws.fiw.gymmanagement.application.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.DeleteCourseResponse deleteCourse(de.thws.fiw.gymmanagement.application.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse getCoursesByTrainer(de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCoursesByTrainerMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.CreateTrainerResponse> createTrainer(
        de.thws.fiw.gymmanagement.application.CreateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTrainerMethod(), getCallOptions()), request);
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
        de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllTrainersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.UpdateTrainerResponse> updateTrainer(
        de.thws.fiw.gymmanagement.application.UpdateTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.DeleteTrainerResponse> deleteTrainer(
        de.thws.fiw.gymmanagement.application.DeleteTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTrainerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.CreateCourseResponse> createCourse(
        de.thws.fiw.gymmanagement.application.CreateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCourseMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse> getAllCourses(
        de.thws.fiw.gymmanagement.application.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.UpdateCourseResponse> updateCourse(
        de.thws.fiw.gymmanagement.application.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.DeleteCourseResponse> deleteCourse(
        de.thws.fiw.gymmanagement.application.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse> getCoursesByTrainer(
        de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCoursesByTrainerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MEMBER = 0;
  private static final int METHODID_CREATE_MEMBER = 1;
  private static final int METHODID_GET_ALL_MEMBERS = 2;
  private static final int METHODID_UPDATE_MEMBER = 3;
  private static final int METHODID_DELETE_MEMBER = 4;
  private static final int METHODID_CREATE_TRAINER = 5;
  private static final int METHODID_GET_TRAINER = 6;
  private static final int METHODID_GET_ALL_TRAINERS = 7;
  private static final int METHODID_UPDATE_TRAINER = 8;
  private static final int METHODID_DELETE_TRAINER = 9;
  private static final int METHODID_CREATE_COURSE = 10;
  private static final int METHODID_GET_COURSE = 11;
  private static final int METHODID_GET_ALL_COURSES = 12;
  private static final int METHODID_UPDATE_COURSE = 13;
  private static final int METHODID_DELETE_COURSE = 14;
  private static final int METHODID_GET_COURSES_BY_TRAINER = 15;

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
        case METHODID_CREATE_TRAINER:
          serviceImpl.createTrainer((de.thws.fiw.gymmanagement.application.CreateTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateTrainerResponse>) responseObserver);
          break;
        case METHODID_GET_TRAINER:
          serviceImpl.getTrainer((de.thws.fiw.gymmanagement.application.GetTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetTrainerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_TRAINERS:
          serviceImpl.getAllTrainers((de.thws.fiw.gymmanagement.application.Empty) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TRAINER:
          serviceImpl.updateTrainer((de.thws.fiw.gymmanagement.application.UpdateTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateTrainerResponse>) responseObserver);
          break;
        case METHODID_DELETE_TRAINER:
          serviceImpl.deleteTrainer((de.thws.fiw.gymmanagement.application.DeleteTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteTrainerResponse>) responseObserver);
          break;
        case METHODID_CREATE_COURSE:
          serviceImpl.createCourse((de.thws.fiw.gymmanagement.application.CreateCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.CreateCourseResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE:
          serviceImpl.getCourse((de.thws.fiw.gymmanagement.application.GetCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCourseResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((de.thws.fiw.gymmanagement.application.Empty) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((de.thws.fiw.gymmanagement.application.UpdateCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.UpdateCourseResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((de.thws.fiw.gymmanagement.application.DeleteCourseRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.DeleteCourseResponse>) responseObserver);
          break;
        case METHODID_GET_COURSES_BY_TRAINER:
          serviceImpl.getCoursesByTrainer((de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest) request,
              (io.grpc.stub.StreamObserver<de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse>) responseObserver);
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
        .addMethod(
          getCreateTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateTrainerRequest,
              de.thws.fiw.gymmanagement.application.CreateTrainerResponse>(
                service, METHODID_CREATE_TRAINER)))
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
              de.thws.fiw.gymmanagement.application.Empty,
              de.thws.fiw.gymmanagement.application.GetAllTrainersResponse>(
                service, METHODID_GET_ALL_TRAINERS)))
        .addMethod(
          getUpdateTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateTrainerRequest,
              de.thws.fiw.gymmanagement.application.UpdateTrainerResponse>(
                service, METHODID_UPDATE_TRAINER)))
        .addMethod(
          getDeleteTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteTrainerRequest,
              de.thws.fiw.gymmanagement.application.DeleteTrainerResponse>(
                service, METHODID_DELETE_TRAINER)))
        .addMethod(
          getCreateCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.CreateCourseRequest,
              de.thws.fiw.gymmanagement.application.CreateCourseResponse>(
                service, METHODID_CREATE_COURSE)))
        .addMethod(
          getGetCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetCourseRequest,
              de.thws.fiw.gymmanagement.application.GetCourseResponse>(
                service, METHODID_GET_COURSE)))
        .addMethod(
          getGetAllCoursesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.Empty,
              de.thws.fiw.gymmanagement.application.GetAllCoursesResponse>(
                service, METHODID_GET_ALL_COURSES)))
        .addMethod(
          getUpdateCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.UpdateCourseRequest,
              de.thws.fiw.gymmanagement.application.UpdateCourseResponse>(
                service, METHODID_UPDATE_COURSE)))
        .addMethod(
          getDeleteCourseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.DeleteCourseRequest,
              de.thws.fiw.gymmanagement.application.DeleteCourseResponse>(
                service, METHODID_DELETE_COURSE)))
        .addMethod(
          getGetCoursesByTrainerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.thws.fiw.gymmanagement.application.GetCoursesByTrainerRequest,
              de.thws.fiw.gymmanagement.application.GetCoursesByTrainerResponse>(
                service, METHODID_GET_COURSES_BY_TRAINER)))
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
              .addMethod(getCreateTrainerMethod())
              .addMethod(getGetTrainerMethod())
              .addMethod(getGetAllTrainersMethod())
              .addMethod(getUpdateTrainerMethod())
              .addMethod(getDeleteTrainerMethod())
              .addMethod(getCreateCourseMethod())
              .addMethod(getGetCourseMethod())
              .addMethod(getGetAllCoursesMethod())
              .addMethod(getUpdateCourseMethod())
              .addMethod(getDeleteCourseMethod())
              .addMethod(getGetCoursesByTrainerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
