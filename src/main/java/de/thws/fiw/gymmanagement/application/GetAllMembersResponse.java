// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: gym.proto
// Protobuf Java Version: 4.27.4

package de.thws.fiw.gymmanagement.application;

/**
 * Protobuf type {@code GetAllMembersResponse}
 */
public final class GetAllMembersResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:GetAllMembersResponse)
    GetAllMembersResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 4,
      /* suffix= */ "",
      GetAllMembersResponse.class.getName());
  }
  // Use GetAllMembersResponse.newBuilder() to construct.
  private GetAllMembersResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetAllMembersResponse() {
    members_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetAllMembersResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetAllMembersResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class, de.thws.fiw.gymmanagement.application.GetAllMembersResponse.Builder.class);
  }

  public static final int MEMBERS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<de.thws.fiw.gymmanagement.application.GetMemberResponse> members_;
  /**
   * <code>repeated .GetMemberResponse members = 1;</code>
   */
  @java.lang.Override
  public java.util.List<de.thws.fiw.gymmanagement.application.GetMemberResponse> getMembersList() {
    return members_;
  }
  /**
   * <code>repeated .GetMemberResponse members = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder> 
      getMembersOrBuilderList() {
    return members_;
  }
  /**
   * <code>repeated .GetMemberResponse members = 1;</code>
   */
  @java.lang.Override
  public int getMembersCount() {
    return members_.size();
  }
  /**
   * <code>repeated .GetMemberResponse members = 1;</code>
   */
  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.GetMemberResponse getMembers(int index) {
    return members_.get(index);
  }
  /**
   * <code>repeated .GetMemberResponse members = 1;</code>
   */
  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder getMembersOrBuilder(
      int index) {
    return members_.get(index);
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
    for (int i = 0; i < members_.size(); i++) {
      output.writeMessage(1, members_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < members_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, members_.get(i));
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
    if (!(obj instanceof de.thws.fiw.gymmanagement.application.GetAllMembersResponse)) {
      return super.equals(obj);
    }
    de.thws.fiw.gymmanagement.application.GetAllMembersResponse other = (de.thws.fiw.gymmanagement.application.GetAllMembersResponse) obj;

    if (!getMembersList()
        .equals(other.getMembersList())) return false;
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
    if (getMembersCount() > 0) {
      hash = (37 * hash) + MEMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getMembersList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse parseFrom(
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
  public static Builder newBuilder(de.thws.fiw.gymmanagement.application.GetAllMembersResponse prototype) {
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
   * Protobuf type {@code GetAllMembersResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GetAllMembersResponse)
      de.thws.fiw.gymmanagement.application.GetAllMembersResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetAllMembersResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetAllMembersResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.thws.fiw.gymmanagement.application.GetAllMembersResponse.class, de.thws.fiw.gymmanagement.application.GetAllMembersResponse.Builder.class);
    }

    // Construct using de.thws.fiw.gymmanagement.application.GetAllMembersResponse.newBuilder()
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
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
      } else {
        members_ = null;
        membersBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return de.thws.fiw.gymmanagement.application.Gym.internal_static_GetAllMembersResponse_descriptor;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getDefaultInstanceForType() {
      return de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance();
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse build() {
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public de.thws.fiw.gymmanagement.application.GetAllMembersResponse buildPartial() {
      de.thws.fiw.gymmanagement.application.GetAllMembersResponse result = new de.thws.fiw.gymmanagement.application.GetAllMembersResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(de.thws.fiw.gymmanagement.application.GetAllMembersResponse result) {
      if (membersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          members_ = java.util.Collections.unmodifiableList(members_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.members_ = members_;
      } else {
        result.members_ = membersBuilder_.build();
      }
    }

    private void buildPartial0(de.thws.fiw.gymmanagement.application.GetAllMembersResponse result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof de.thws.fiw.gymmanagement.application.GetAllMembersResponse) {
        return mergeFrom((de.thws.fiw.gymmanagement.application.GetAllMembersResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(de.thws.fiw.gymmanagement.application.GetAllMembersResponse other) {
      if (other == de.thws.fiw.gymmanagement.application.GetAllMembersResponse.getDefaultInstance()) return this;
      if (membersBuilder_ == null) {
        if (!other.members_.isEmpty()) {
          if (members_.isEmpty()) {
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMembersIsMutable();
            members_.addAll(other.members_);
          }
          onChanged();
        }
      } else {
        if (!other.members_.isEmpty()) {
          if (membersBuilder_.isEmpty()) {
            membersBuilder_.dispose();
            membersBuilder_ = null;
            members_ = other.members_;
            bitField0_ = (bitField0_ & ~0x00000001);
            membersBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getMembersFieldBuilder() : null;
          } else {
            membersBuilder_.addAllMessages(other.members_);
          }
        }
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
            case 10: {
              de.thws.fiw.gymmanagement.application.GetMemberResponse m =
                  input.readMessage(
                      de.thws.fiw.gymmanagement.application.GetMemberResponse.parser(),
                      extensionRegistry);
              if (membersBuilder_ == null) {
                ensureMembersIsMutable();
                members_.add(m);
              } else {
                membersBuilder_.addMessage(m);
              }
              break;
            } // case 10
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

    private java.util.List<de.thws.fiw.gymmanagement.application.GetMemberResponse> members_ =
      java.util.Collections.emptyList();
    private void ensureMembersIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        members_ = new java.util.ArrayList<de.thws.fiw.gymmanagement.application.GetMemberResponse>(members_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        de.thws.fiw.gymmanagement.application.GetMemberResponse, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder, de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder> membersBuilder_;

    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public java.util.List<de.thws.fiw.gymmanagement.application.GetMemberResponse> getMembersList() {
      if (membersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(members_);
      } else {
        return membersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public int getMembersCount() {
      if (membersBuilder_ == null) {
        return members_.size();
      } else {
        return membersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse getMembers(int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);
      } else {
        return membersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder setMembers(
        int index, de.thws.fiw.gymmanagement.application.GetMemberResponse value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.set(index, value);
        onChanged();
      } else {
        membersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder setMembers(
        int index, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.set(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder addMembers(de.thws.fiw.gymmanagement.application.GetMemberResponse value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(value);
        onChanged();
      } else {
        membersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder addMembers(
        int index, de.thws.fiw.gymmanagement.application.GetMemberResponse value) {
      if (membersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMembersIsMutable();
        members_.add(index, value);
        onChanged();
      } else {
        membersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder addMembers(
        de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder addMembers(
        int index, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder builderForValue) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.add(index, builderForValue.build());
        onChanged();
      } else {
        membersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder addAllMembers(
        java.lang.Iterable<? extends de.thws.fiw.gymmanagement.application.GetMemberResponse> values) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, members_);
        onChanged();
      } else {
        membersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder clearMembers() {
      if (membersBuilder_ == null) {
        members_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        membersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public Builder removeMembers(int index) {
      if (membersBuilder_ == null) {
        ensureMembersIsMutable();
        members_.remove(index);
        onChanged();
      } else {
        membersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder getMembersBuilder(
        int index) {
      return getMembersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder getMembersOrBuilder(
        int index) {
      if (membersBuilder_ == null) {
        return members_.get(index);  } else {
        return membersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public java.util.List<? extends de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder> 
         getMembersOrBuilderList() {
      if (membersBuilder_ != null) {
        return membersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(members_);
      }
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder addMembersBuilder() {
      return getMembersFieldBuilder().addBuilder(
          de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder addMembersBuilder(
        int index) {
      return getMembersFieldBuilder().addBuilder(
          index, de.thws.fiw.gymmanagement.application.GetMemberResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .GetMemberResponse members = 1;</code>
     */
    public java.util.List<de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder> 
         getMembersBuilderList() {
      return getMembersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        de.thws.fiw.gymmanagement.application.GetMemberResponse, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder, de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder> 
        getMembersFieldBuilder() {
      if (membersBuilder_ == null) {
        membersBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            de.thws.fiw.gymmanagement.application.GetMemberResponse, de.thws.fiw.gymmanagement.application.GetMemberResponse.Builder, de.thws.fiw.gymmanagement.application.GetMemberResponseOrBuilder>(
                members_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        members_ = null;
      }
      return membersBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:GetAllMembersResponse)
  }

  // @@protoc_insertion_point(class_scope:GetAllMembersResponse)
  private static final de.thws.fiw.gymmanagement.application.GetAllMembersResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new de.thws.fiw.gymmanagement.application.GetAllMembersResponse();
  }

  public static de.thws.fiw.gymmanagement.application.GetAllMembersResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAllMembersResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetAllMembersResponse>() {
    @java.lang.Override
    public GetAllMembersResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetAllMembersResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAllMembersResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public de.thws.fiw.gymmanagement.application.GetAllMembersResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
