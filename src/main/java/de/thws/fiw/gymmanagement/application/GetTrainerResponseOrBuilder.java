// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

public interface GetTrainerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetTrainerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 trainerId = 1;</code>
   * @return The trainerId.
   */
  long getTrainerId();

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
