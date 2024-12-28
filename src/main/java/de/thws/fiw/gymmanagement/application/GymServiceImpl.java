package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.infrastructure.MemberRepository;
import de.thws.fiw.gymmanagement.domain.Member;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GymServiceImpl extends GymServiceGrpc.GymServiceImplBase {
    private final MemberRepository repository = new MemberRepository();

    @Override
    public void createMember(CreateMemberRequest request, StreamObserver<CreateMemberResponse> responseObserver) {
        Member member = new Member();
        member.setName(request.getName());
        member.setMembershipType(request.getMembershipType());

        Member savedMember = repository.save(member);

        CreateMemberResponse response = CreateMemberResponse.newBuilder()
                .setMemberId(savedMember.getId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMember(GetMemberRequest request, StreamObserver<GetMemberResponse> responseObserver) {
        Member member = repository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        GetMemberResponse response = GetMemberResponse.newBuilder()
                .setMemberId(member.getId())
                .setName(member.getName())
                .setMembershipType(member.getMembershipType())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void getAllMembers(Empty request, StreamObserver<GetAllMembersResponse> responseObserver) {
        List<Member> allMembers = repository.findAll();
        GetAllMembersResponse.Builder responseBuilder = GetAllMembersResponse.newBuilder();

        for (Member member : allMembers) {
            GetMemberResponse memberResponse = GetMemberResponse.newBuilder()
                    .setMemberId(member.getId())
                    .setName(member.getName())
                    .setMembershipType(member.getMembershipType())
                    .build();
            responseBuilder.addMembers(memberResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

}
