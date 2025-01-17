// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

/**
 * Protobuf type {@code CreateBookingResponse}
 */
public final class CreateBookingResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:CreateBookingResponse)
    CreateBookingResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      CreateBookingResponse.class.getName());
  }
  // Use CreateBookingResponse.newBuilder() to construct.
  private CreateBookingResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CreateBookingResponse() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateBookingResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateBookingResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.thws.fiw.gymmanagement.application.CreateBookingResponse.class, de.thws.fiw.gymmanagement.application.CreateBookingResponse.Builder.class);
  }

  public static final int BOOKINGID_FIELD_NUMBER = 1;
  private long bookingId_ = 0L;
  /**
   * <code>int64 bookingId = 1;</code>
   * @return The bookingId.
   */
  @java.lang.Override
  public long getBookingId() {
    return bookingId_;
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
    if (bookingId_ != 0L) {
      output.writeInt64(1, bookingId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bookingId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, bookingId_);
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
    if (!(obj instanceof de.thws.fiw.gymmanagement.application.CreateBookingResponse)) {
      return super.equals(obj);
    }
    de.thws.fiw.gymmanagement.application.CreateBookingResponse other = (de.thws.fiw.gymmanagement.application.CreateBookingResponse) obj;

    if (getBookingId()
        != other.getBookingId()) return false;
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
    hash = (37 * hash) + BOOKINGID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBookingId());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse parseFrom(
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
  public static Builder newBuilder(de.thws.fiw.gymmanagement.application.CreateBookingResponse prototype) {
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
   * Protobuf type {@code CreateBookingResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CreateBookingResponse)
      de.thws.fiw.gymmanagement.application.CreateBookingResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateBookingResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateBookingResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.thws.fiw.gymmanagement.application.CreateBookingResponse.class, de.thws.fiw.gymmanagement.application.CreateBookingResponse.Builder.class);
    }

    // Construct using de.thws.fiw.gymmanagement.application.CreateBookingResponse.newBuilder()
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
      bookingId_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_CreateBookingResponse_descriptor;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateBookingResponse getDefaultInstanceForType() {
      return de.thws.fiw.gymmanagement.application.CreateBookingResponse.getDefaultInstance();
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateBookingResponse build() {
      de.thws.fiw.gymmanagement.application.CreateBookingResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.CreateBookingResponse buildPartial() {
      de.thws.fiw.gymmanagement.application.CreateBookingResponse result = new de.thws.fiw.gymmanagement.application.CreateBookingResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(de.thws.fiw.gymmanagement.application.CreateBookingResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.bookingId_ = bookingId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.thws.fiw.gymmanagement.application.CreateBookingResponse) {
        return mergeFrom((de.thws.fiw.gymmanagement.application.CreateBookingResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.thws.fiw.gymmanagement.application.CreateBookingResponse other) {
      if (other == de.thws.fiw.gymmanagement.application.CreateBookingResponse.getDefaultInstance()) return this;
      if (other.getBookingId() != 0L) {
        setBookingId(other.getBookingId());
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
              bookingId_ = input.readInt64();
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

    private long bookingId_ ;
    /**
     * <code>int64 bookingId = 1;</code>
     * @return The bookingId.
     */
    @java.lang.Override
    public long getBookingId() {
      return bookingId_;
    }
    /**
     * <code>int64 bookingId = 1;</code>
     * @param value The bookingId to set.
     * @return This builder for chaining.
     */
    public Builder setBookingId(long value) {

      bookingId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 bookingId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBookingId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      bookingId_ = 0L;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:CreateBookingResponse)
  }

  // @@protoc_insertion_point(class_scope:CreateBookingResponse)
  private static final de.thws.fiw.gymmanagement.application.CreateBookingResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.thws.fiw.gymmanagement.application.CreateBookingResponse();
  }

  public static de.thws.fiw.gymmanagement.application.CreateBookingResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateBookingResponse>
      PARSER = new com.google.protobuf.AbstractParser<CreateBookingResponse>() {
    @java.lang.Override
    public CreateBookingResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateBookingResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateBookingResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.CreateBookingResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

