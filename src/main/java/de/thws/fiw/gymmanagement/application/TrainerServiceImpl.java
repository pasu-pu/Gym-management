package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.application.service.TrainerService;
import de.thws.fiw.gymmanagement.application.service.TrainerServiceAdapter;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;

public class TrainerServiceImpl extends TrainerServiceGrpc.TrainerServiceImplBase {

    private final TrainerServiceAdapter trainerService;

    public TrainerServiceImpl(TrainerServiceAdapter trainerService) {

        this.trainerService = trainerService;
    }

    @Override
    public void createTrainer(CreateTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        try {
            Trainer trainer = trainerService.createTrainer(request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        try {
            Trainer trainer = trainerService.updateTrainer(request.getTrainerId(), request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        try {
            Trainer trainer = trainerService.getTrainer(request.getTrainerId());
            if (trainer == null) {
                responseObserver.onError(Status.NOT_FOUND.withDescription("Trainer not found").asRuntimeException());
                return;
            }
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllTrainers(GetAllTrainersRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        try {
            List<Trainer> trainers = trainerService.getAllTrainers(request.getPagesize(), request.getIndex());
            GetAllTrainersResponse.Builder builder = GetAllTrainersResponse.newBuilder();
            for (Trainer trainer : trainers) {
                builder.addTrainers(GetTrainerResponse.newBuilder()
                        .setTrainerId(trainer.getId())
                        .setName(trainer.getName())
                        .setExpertise(trainer.getExpertise())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainerByName(GetTrainerByNameRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        try {
            List<Trainer> trainers = trainerService.getTrainerByName(request.getPagesize(), request.getIndex(), request.getName());
            GetAllTrainersResponse.Builder builder = GetAllTrainersResponse.newBuilder();
            for (Trainer trainer : trainers) {
                builder.addTrainers(GetTrainerResponse.newBuilder()
                        .setTrainerId(trainer.getId())
                        .setName(trainer.getName())
                        .setExpertise(trainer.getExpertise())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainerByExpertise(GetTrainerByExpertiseRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        try {
            List<Trainer> trainers = trainerService.getTrainerByExpertise(request.getPagesize(), request.getIndex(), request.getExpertise());
            GetAllTrainersResponse.Builder builder = GetAllTrainersResponse.newBuilder();
            for (Trainer trainer : trainers) {
                builder.addTrainers(GetTrainerResponse.newBuilder()
                        .setTrainerId(trainer.getId())
                        .setName(trainer.getName())
                        .setExpertise(trainer.getExpertise())
                        .build());
            }
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<DeleteTrainerResponse> responseObserver) {
        try {
            boolean success = trainerService.deleteTrainer(request.getTrainerId());
            DeleteTrainerResponse response = DeleteTrainerResponse.newBuilder().setSuccess(success).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch(Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
