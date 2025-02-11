package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.MemberService; // Business-Logik
import de.thws.fiw.gymmanagement.application.service.MemberServiceAdapter;
import de.thws.fiw.gymmanagement.domain.Member;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;

public class MemberServiceImpl extends MemberServiceGrpc.MemberServiceImplBase {

    private final MemberServiceAdapter memberService;

    public MemberServiceImpl(MemberServiceAdapter memberService) {

        this.memberService = memberService;
    }

    @Override
    public void createMember(CreateMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        try {
            Member member = memberService.createMember(request.getName(), request.getMembership());
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembership(member.getMembershipType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateMember(UpdateMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        try {
            Member member = memberService.updateMember(request.getMemberId(), request.getName(), request.getMembership());
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembership(member.getMembershipType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        try {
            Member member = memberService.getMember(request.getMemberId());
            if (member == null) {
                responseObserver.onError(Status.NOT_FOUND.withDescription("Member not found").asRuntimeException());
                return;
            }
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembership(member.getMembershipType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllMembers(GetAllMembersRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        try {
            List<Member> members = memberService.getAllMembers(request.getPagesize(), request.getIndex());
            GetAllMembersResponse.Builder builder = GetAllMembersResponse.newBuilder();
            for (Member member : members) {
                builder.addMembers(GetMemberResponse.newBuilder()
                        .setMemberId(member.getId())
                        .setName(member.getName())
                        .setMembership(member.getMembershipType())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMemberByName(GetMemberByNameRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        try {
            List<Member> members = memberService.getMemberByName(request.getPagesize(), request.getIndex(), request.getName());
            GetAllMembersResponse.Builder builder = GetAllMembersResponse.newBuilder();
            for (Member member : members) {
                builder.addMembers(GetMemberResponse.newBuilder()
                        .setMemberId(member.getId())
                        .setName(member.getName())
                        .setMembership(member.getMembershipType())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMemberByMembership(GetMemberByMembershipRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        try {
            List<Member> members = memberService.getMemberByMembership(request.getPagesize(), request.getIndex(), request.getMembership());
            GetAllMembersResponse.Builder builder = GetAllMembersResponse.newBuilder();
            for (Member member : members) {
                builder.addMembers(GetMemberResponse.newBuilder()
                        .setMemberId(member.getId())
                        .setName(member.getName())
                        .setMembership(member.getMembershipType())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteMember(DeleteMemberRequest request, StreamObserver<DeleteMemberResponse> responseObserver) {
        try {
            boolean success = memberService.deleteMember(request.getMemberId());
            DeleteMemberResponse response = DeleteMemberResponse.newBuilder().setSuccess(success).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
