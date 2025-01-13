// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

/**
 * Protobuf type {@code CreateCourseResponse}
 */
public final class CreateCourseResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:CreateCourseResponse)
    CreateCourseResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      CreateCourseResponse.class.getName());
  }
  // Use CreateCourseResponse.newBuilder() to construct.
  private CreateCourseResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CreateCourseResponse() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateCourseResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateCourseResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.thws.fiw.gymmanagement.application.CreateCourseResponse.class, de.thws.fiw.gymmanagement.application.CreateCourseResponse.Builder.class);
  }

  public static final int COURSEID_FIELD_NUMBER = 1;
  private long courseId_ = 0L;
  /**
   * <code>int64 courseId = 1;</code>
   * @return The courseId.
   */
  @java.lang.Override
  public long getCourseId() {
    return courseId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (courseId_ != 0L) {
      output.writeInt64(1, courseId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (courseId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, courseId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof de.thws.fiw.gymmanagement.application.CreateCourseResponse)) {
      return super.equals(obj);
    }
    de.thws.fiw.gymmanagement.application.CreateCourseResponse other = (de.thws.fiw.gymmanagement.application.CreateCourseResponse) obj;

    if (getCourseId()
        != other.getCourseId()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + COURSEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCourseId());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(de.thws.fiw.gymmanagement.application.CreateCourseResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code CreateCourseResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CreateCourseResponse)
      de.thws.fiw.gymmanagement.application.CreateCourseResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateCourseResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateCourseResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.thws.fiw.gymmanagement.application.CreateCourseResponse.class, de.thws.fiw.gymmanagement.application.CreateCourseResponse.Builder.class);
    }

    // Construct using de.thws.fiw.gymmanagement.application.CreateCourseResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      courseId_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateCourseResponse_descriptor;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateCourseResponse getDefaultInstanceForType() {
      return de.thws.fiw.gymmanagement.application.CreateCourseResponse.getDefaultInstance();
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateCourseResponse build() {
      de.thws.fiw.gymmanagement.application.CreateCourseResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateCourseResponse buildPartial() {
      de.thws.fiw.gymmanagement.application.CreateCourseResponse result = new de.thws.fiw.gymmanagement.application.CreateCourseResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(de.thws.fiw.gymmanagement.application.CreateCourseResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.courseId_ = courseId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.thws.fiw.gymmanagement.application.CreateCourseResponse) {
        return mergeFrom((de.thws.fiw.gymmanagement.application.CreateCourseResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.thws.fiw.gymmanagement.application.CreateCourseResponse other) {
      if (other == de.thws.fiw.gymmanagement.application.CreateCourseResponse.getDefaultInstance()) return this;
      if (other.getCourseId() != 0L) {
        setCourseId(other.getCourseId());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              courseId_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private long courseId_ ;
    /**
     * <code>int64 courseId = 1;</code>
     * @return The courseId.
     */
    @java.lang.Override
    public long getCourseId() {
      return courseId_;
    }
    /**
     * <code>int64 courseId = 1;</code>
     * @param value The courseId to set.
     * @return This builder for chaining.
     */
    public Builder setCourseId(long value) {

      courseId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 courseId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCourseId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      courseId_ = 0L;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:CreateCourseResponse)
  }

  // @@protoc_insertion_point(class_scope:CreateCourseResponse)
  private static final de.thws.fiw.gymmanagement.application.CreateCourseResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.thws.fiw.gymmanagement.application.CreateCourseResponse();
  }

  public static de.thws.fiw.gymmanagement.application.CreateCourseResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateCourseResponse>
      PARSER = new com.google.protobuf.AbstractParser<CreateCourseResponse>() {
    @java.lang.Override
    public CreateCourseResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CreateCourseResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateCourseResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.CreateCourseResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

