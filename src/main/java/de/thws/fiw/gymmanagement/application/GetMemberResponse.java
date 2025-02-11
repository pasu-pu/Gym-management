// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

/**
 * Protobuf type {@code GetMemberResponse}
 */
public final class GetMemberResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:GetMemberResponse)
    GetMemberResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      GetMemberResponse.class.getName());
  }
  // Use GetMemberResponse.newBuilder() to construct.
  private GetMemberResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetMemberResponse() {
    name_ = "";
    membership_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetMemberResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetMemberResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.thws.fiw.gymmanagement.application.GetMemberResponse.class, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder.class);
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

  public static final int NAME_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MEMBERSHIP_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object membership_ = "";
  /**
   * <code>string membership = 3;</code>
   * @return The membership.
   */
  @java.lang.Override
  public java.lang.String getMembership() {
    java.lang.Object ref = membership_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      membership_ = s;
      return s;
    }
  }
  /**
   * <code>string membership = 3;</code>
   * @return The bytes for membership.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMembershipBytes() {
    java.lang.Object ref = membership_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      membership_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, name_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(membership_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, membership_);
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, name_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(membership_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, membership_);
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
    if (!(obj instanceof de.thws.fiw.gymmanagement.application.GetMemberResponse)) {
      return super.equals(obj);
    }
    de.thws.fiw.gymmanagement.application.GetMemberResponse other = (de.thws.fiw.gymmanagement.application.GetMemberResponse) obj;

    if (getMemberId()
        != other.getMemberId()) return false;
    if (!getName()
        .equals(other.getName())) return false;
    if (!getMembership()
        .equals(other.getMembership())) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + MEMBERSHIP_FIELD_NUMBER;
    hash = (53 * hash) + getMembership().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetMemberResponse parseFrom(
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
  public static Builder newBuilder(de.thws.fiw.gymmanagement.application.GetMemberResponse prototype) {
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
   * Protobuf type {@code GetMemberResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetMemberResponse)
      de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetMemberResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetMemberResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.thws.fiw.gymmanagement.application.GetMemberResponse.class, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder.class);
    }

    // Construct using de.thws.fiw.gymmanagement.application.GetMemberResponse.newBuilder()
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
      name_ = "";
      membership_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetMemberResponse_descriptor;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetMemberResponse getDefaultInstanceForType() {
      return de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance();
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetMemberResponse build() {
      de.thws.fiw.gymmanagement.application.GetMemberResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetMemberResponse buildPartial() {
      de.thws.fiw.gymmanagement.application.GetMemberResponse result = new de.thws.fiw.gymmanagement.application.GetMemberResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(de.thws.fiw.gymmanagement.application.GetMemberResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.memberId_ = memberId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.name_ = name_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.membership_ = membership_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.thws.fiw.gymmanagement.application.GetMemberResponse) {
        return mergeFrom((de.thws.fiw.gymmanagement.application.GetMemberResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.thws.fiw.gymmanagement.application.GetMemberResponse other) {
      if (other == de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance()) return this;
      if (other.getMemberId() != 0L) {
        setMemberId(other.getMemberId());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getMembership().isEmpty()) {
        membership_ = other.membership_;
        bitField0_ |= 0x00000004;
        onChanged();
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
            case 18: {
              name_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              membership_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
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

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object membership_ = "";
    /**
     * <code>string membership = 3;</code>
     * @return The membership.
     */
    public java.lang.String getMembership() {
      java.lang.Object ref = membership_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        membership_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string membership = 3;</code>
     * @return The bytes for membership.
     */
    public com.google.protobuf.ByteString
        getMembershipBytes() {
      java.lang.Object ref = membership_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        membership_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string membership = 3;</code>
     * @param value The membership to set.
     * @return This builder for chaining.
     */
    public Builder setMembership(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      membership_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string membership = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMembership() {
      membership_ = getDefaultInstance().getMembership();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string membership = 3;</code>
     * @param value The bytes for membership to set.
     * @return This builder for chaining.
     */
    public Builder setMembershipBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      membership_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:GetMemberResponse)
  }

  // @@protoc_insertion_point(class_scope:GetMemberResponse)
  private static final de.thws.fiw.gymmanagement.application.GetMemberResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.thws.fiw.gymmanagement.application.GetMemberResponse();
  }

  public static de.thws.fiw.gymmanagement.application.GetMemberResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetMemberResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetMemberResponse>() {
    @java.lang.Override
    public GetMemberResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetMemberResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetMemberResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.GetMemberResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

