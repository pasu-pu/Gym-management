// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

public final class Gym {
  private Gym() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      Gym.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetAllMembersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_GetAllMembersResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetMemberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_GetMemberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetMemberResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_GetMemberResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMemberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_CreateMemberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CreateMemberResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_CreateMemberResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tgym.proto\"<\n\025GetAllMembersResponse\022#\n\007" +
      "members\030\001 \003(\0132\022.GetMemberResponse\"\007\n\005Emp" +
      "ty\"$\n\020GetMemberRequest\022\020\n\010memberId\030\001 \001(\003" +
      "\"K\n\021GetMemberResponse\022\020\n\010memberId\030\001 \001(\003\022" +
      "\014\n\004name\030\002 \001(\t\022\026\n\016membershipType\030\003 \001(\t\";\n" +
      "\023CreateMemberRequest\022\014\n\004name\030\001 \001(\t\022\026\n\016me" +
      "mbershipType\030\002 \001(\t\"(\n\024CreateMemberRespon" +
      "se\022\020\n\010memberId\030\001 \001(\0032\256\001\n\nGymService\0222\n\tG" +
      "etMember\022\021.GetMemberRequest\032\022.GetMemberR" +
      "esponse\022;\n\014CreateMember\022\024.CreateMemberRe" +
      "quest\032\025.CreateMemberResponse\022/\n\rGetAllMe" +
      "mbers\022\006.Empty\032\026.GetAllMembersResponseB)\n" +
      "%de.thws.fiw.gymmanagement.applicationP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_GetAllMembersResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GetAllMembersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_GetAllMembersResponse_descriptor,
        new java.lang.String[] { "Members", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_GetMemberRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GetMemberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_GetMemberRequest_descriptor,
        new java.lang.String[] { "MemberId", });
    internal_static_GetMemberResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GetMemberResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_GetMemberResponse_descriptor,
        new java.lang.String[] { "MemberId", "Name", "MembershipType", });
    internal_static_CreateMemberRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_CreateMemberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_CreateMemberRequest_descriptor,
        new java.lang.String[] { "Name", "MembershipType", });
    internal_static_CreateMemberResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_CreateMemberResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_CreateMemberResponse_descriptor,
        new java.lang.String[] { "MemberId", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
