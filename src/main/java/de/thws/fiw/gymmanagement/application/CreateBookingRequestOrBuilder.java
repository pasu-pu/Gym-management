// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

public interface CreateBookingRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CreateBookingRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 memberId = 1;</code>
   * @return The memberId.
   */
  long getMemberId();

  /**
   * <code>int64 courseId = 2;</code>
   * @return The courseId.
   */
  long getCourseId();

  /**
   * <pre>
   * ISO 8601 format
   * </pre>
   *
   * <code>string bookingDate = 3;</code>
   * @return The bookingDate.
   */
  java.lang.String getBookingDate();
  /**
   * <pre>
   * ISO 8601 format
   * </pre>
   *
   * <code>string bookingDate = 3;</code>
   * @return The bytes for bookingDate.
   */
  com.google.protobuf.ByteString
      getBookingDateBytes();
}
