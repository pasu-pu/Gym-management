package de.thws.fiw.gymmanagement.application;

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
        System.out.println("[MemberService] createMember called with name: " + request.getName()
                + ", membership: " + request.getMembership());
        try {
            System.out.println("[MemberService] Invoking business logic for createMember");
            Member member = memberService.createMember(request.getName(), request.getMembership());
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembership(member.getMembershipType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[MemberService] createMember succeeded: created member with id " + response.getMemberId());
        } catch (Exception e) {
            System.err.println("[MemberService] Error in createMember: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateMember(UpdateMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        System.out.println("[MemberService] updateMember called for memberId: " + request.getMemberId()
                + " with new name: " + request.getName() + ", membership: " + request.getMembership());
        try {
            System.out.println("[MemberService] Invoking business logic for updateMember");
            Member member = memberService.updateMember(request.getMemberId(), request.getName(), request.getMembership());
            GetMemberResponse response = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembership(member.getMembershipType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[MemberService] updateMember succeeded for memberId: " + response.getMemberId());
        } catch (Exception e) {
            System.err.println("[MemberService] Error in updateMember: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        System.out.println("[MemberService] getMember called for memberId: " + request.getMemberId());
        try {
            Member member = memberService.getMember(request.getMemberId());
            if (member == null) {
                System.err.println("[MemberService] getMember: Member with id " + request.getMemberId() + " not found");
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
            System.out.println("[MemberService] getMember succeeded for memberId: " + response.getMemberId());
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMember: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllMembers(GetAllMembersRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        System.out.println("[MemberService] getAllMembers called with pagesize: " + request.getPagesize()
                + ", index: " + request.getIndex());
        try {
            System.out.println("[MemberService] Invoking business logic for getAllMembers");
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
            System.out.println("[MemberService] getAllMembers succeeded: returned " + members.size() + " members");
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getAllMembers: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMemberByName(GetMemberByNameRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        System.out.println("[MemberService] getMemberByName called with name: " + request.getName()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[MemberService] Invoking business logic for getMemberByName");
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
            System.out.println("[MemberService] getMemberByName succeeded: returned " + members.size() + " members");
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMemberByName: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getMemberByMembership(GetMemberByMembershipRequest request, StreamObserver<GetAllMembersResponse> responseObserver) {
        System.out.println("[MemberService] getMemberByMembership called with membership: " + request.getMembership()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[MemberService] Invoking business logic for getMemberByMembership");
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
            System.out.println("[MemberService] getMemberByMembership succeeded: returned " + members.size() + " members");
        } catch (Exception e) {
            System.err.println("[MemberService] Error in getMemberByMembership: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteMember(DeleteMemberRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        System.out.println("[MemberService] deleteMember called for memberId: " + request.getMemberId());
        try {
            System.out.println("[MemberService] Invoking business logic for deleteMember");
            memberService.deleteMember(request.getMemberId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
            System.out.println("[MemberService] deleteMember succeeded for memberId: " + request.getMemberId());
        } catch (Exception e) {
            System.err.println("[MemberService] Error in deleteMember: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
