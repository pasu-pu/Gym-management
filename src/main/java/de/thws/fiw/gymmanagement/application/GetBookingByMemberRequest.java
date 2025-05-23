// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

/**
 * Protobuf type {@code GetBookingByMemberRequest}
 */
public final class GetBookingByMemberRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:GetBookingByMemberRequest)
    GetBookingByMemberRequestOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      GetBookingByMemberRequest.class.getName());
  }
  // Use GetBookingByMemberRequest.newBuilder() to construct.
  private GetBookingByMemberRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetBookingByMemberRequest() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetBookingByMemberRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetBookingByMemberRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.class, de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.Builder.class);
  }

  public static final int MEMBERID_FIELD_NUMBER = 1;
  private long memberId_ = 0L;
  /**
   * <code>int64 memberId = 1;</code>
   * @return The memberId.
   */
  @java.lang.Override
  public long getMemberId() {
    return memberId_;
  }

  public static final int PAGESIZE_FIELD_NUMBER = 2;
  private int pagesize_ = 0;
  /**
   * <code>int32 pagesize = 2;</code>
   * @return The pagesize.
   */
  @java.lang.Override
  public int getPagesize() {
    return pagesize_;
  }

  public static final int INDEX_FIELD_NUMBER = 3;
  private int index_ = 0;
  /**
   * <code>int32 index = 3;</code>
   * @return The index.
   */
  @java.lang.Override
  public int getIndex() {
    return index_;
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
    if (memberId_ != 0L) {
      output.writeInt64(1, memberId_);
    }
    if (pagesize_ != 0) {
      output.writeInt32(2, pagesize_);
    }
    if (index_ != 0) {
      output.writeInt32(3, index_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (memberId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, memberId_);
    }
    if (pagesize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, pagesize_);
    }
    if (index_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, index_);
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
    if (!(obj instanceof de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest)) {
      return super.equals(obj);
    }
    de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest other = (de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest) obj;

    if (getMemberId()
        != other.getMemberId()) return false;
    if (getPagesize()
        != other.getPagesize()) return false;
    if (getIndex()
        != other.getIndex()) return false;
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
    hash = (37 * hash) + MEMBERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMemberId());
    hash = (37 * hash) + PAGESIZE_FIELD_NUMBER;
    hash = (53 * hash) + getPagesize();
    hash = (37 * hash) + INDEX_FIELD_NUMBER;
    hash = (53 * hash) + getIndex();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest parseFrom(
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
  public static Builder newBuilder(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest prototype) {
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
   * Protobuf type {@code GetBookingByMemberRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetBookingByMemberRequest)
      de.thws.fiw.gymmanagement.application.GetBookingByMemberRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetBookingByMemberRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetBookingByMemberRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.class, de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.Builder.class);
    }

    // Construct using de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.newBuilder()
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
      memberId_ = 0L;
      pagesize_ = 0;
      index_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetBookingByMemberRequest_descriptor;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest getDefaultInstanceForType() {
      return de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.getDefaultInstance();
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest build() {
      de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest buildPartial() {
      de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest result = new de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.memberId_ = memberId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.pagesize_ = pagesize_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.index_ = index_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest) {
        return mergeFrom((de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest other) {
      if (other == de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest.getDefaultInstance()) return this;
      if (other.getMemberId() != 0L) {
        setMemberId(other.getMemberId());
      }
      if (other.getPagesize() != 0) {
        setPagesize(other.getPagesize());
      }
      if (other.getIndex() != 0) {
        setIndex(other.getIndex());
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
              memberId_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              pagesize_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              index_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private long memberId_ ;
    /**
     * <code>int64 memberId = 1;</code>
     * @return The memberId.
     */
    @java.lang.Override
    public long getMemberId() {
      return memberId_;
    }
    /**
     * <code>int64 memberId = 1;</code>
     * @param value The memberId to set.
     * @return This builder for chaining.
     */
    public Builder setMemberId(long value) {

      memberId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 memberId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMemberId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      memberId_ = 0L;
      onChanged();
      return this;
    }

    private int pagesize_ ;
    /**
     * <code>int32 pagesize = 2;</code>
     * @return The pagesize.
     */
    @java.lang.Override
    public int getPagesize() {
      return pagesize_;
    }
    /**
     * <code>int32 pagesize = 2;</code>
     * @param value The pagesize to set.
     * @return This builder for chaining.
     */
    public Builder setPagesize(int value) {

      pagesize_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 pagesize = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPagesize() {
      bitField0_ = (bitField0_ & ~0x00000002);
      pagesize_ = 0;
      onChanged();
      return this;
    }

    private int index_ ;
    /**
     * <code>int32 index = 3;</code>
     * @return The index.
     */
    @java.lang.Override
    public int getIndex() {
      return index_;
    }
    /**
     * <code>int32 index = 3;</code>
     * @param value The index to set.
     * @return This builder for chaining.
     */
    public Builder setIndex(int value) {

      index_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 index = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearIndex() {
      bitField0_ = (bitField0_ & ~0x00000004);
      index_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:GetBookingByMemberRequest)
  }

  // @@protoc_insertion_point(class_scope:GetBookingByMemberRequest)
  private static final de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest();
  }

  public static de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetBookingByMemberRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetBookingByMemberRequest>() {
    @java.lang.Override
    public GetBookingByMemberRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetBookingByMemberRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetBookingByMemberRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.GetBookingByMemberRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

