// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

public interface GetMemberResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetMemberResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 memberId = 1;</code>
   * @return The memberId.
   */
  long getMemberId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string membership = 3;</code>
   * @return The membership.
   */
  java.lang.String getMembership();
  /**
   * <code>string membership = 3;</code>
   * @return The bytes for membership.
   */
  com.google.protobuf.ByteString
      getMembershipBytes();
}
