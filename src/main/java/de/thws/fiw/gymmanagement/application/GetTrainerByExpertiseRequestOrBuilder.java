// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

public interface GetTrainerByExpertiseRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetTrainerByExpertiseRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 pagesize = 1;</code>
   * @return The pagesize.
   */
  int getPagesize();

  /**
   * <code>int32 index = 2;</code>
   * @return The index.
   */
  int getIndex();

  /**
   * <code>string expertise = 3;</code>
   * @return The expertise.
   */
  java.lang.String getExpertise();
  /**
   * <code>string expertise = 3;</code>
   * @return The bytes for expertise.
   */
  com.google.protobuf.ByteString
      getExpertiseBytes();
}
