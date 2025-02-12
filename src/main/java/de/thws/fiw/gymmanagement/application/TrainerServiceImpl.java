package de.thws.fiw.gymmanagement.application;

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
        System.out.println("[TrainerService] createTrainer called with name: " + request.getName()
                + ", expertise: " + request.getExpertise());
        try {
            System.out.println("[TrainerService] Invoking business logic for createTrainer");
            Trainer trainer = trainerService.createTrainer(request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[TrainerService] createTrainer succeeded: created trainer with id " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in createTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        System.out.println("[TrainerService] updateTrainer called for trainerId: " + request.getTrainerId()
                + " with new name: " + request.getName() + ", expertise: " + request.getExpertise());
        try {
            System.out.println("[TrainerService] Invoking business logic for updateTrainer");
            Trainer trainer = trainerService.updateTrainer(request.getTrainerId(), request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[TrainerService] updateTrainer succeeded for trainerId: " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in updateTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        System.out.println("[TrainerService] getTrainer called for trainerId: " + request.getTrainerId());
        try {
            Trainer trainer = trainerService.getTrainer(request.getTrainerId());
            if (trainer == null) {
                System.err.println("[TrainerService] getTrainer: Trainer with id " + request.getTrainerId() + " not found");
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
            System.out.println("[TrainerService] getTrainer succeeded for trainerId: " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getAllTrainers(GetAllTrainersRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerService] getAllTrainers called with pagesize: " + request.getPagesize()
                + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerService] Invoking business logic for getAllTrainers");
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
            System.out.println("[TrainerService] getAllTrainers succeeded: returned " + trainers.size() + " trainers");
        } catch (Exception e) {
            System.err.println("[TrainerService] Error in getAllTrainers: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainerByName(GetTrainerByNameRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerService] getTrainerByName called with name: " + request.getName()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerService] Invoking business logic for getTrainerByName");
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
            System.out.println("[TrainerService] getTrainerByName succeeded: returned " + trainers.size() + " trainers");
        } catch(Exception e) {
            System.err.println("[TrainerService] Error in getTrainerByName: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void getTrainerByExpertise(GetTrainerByExpertiseRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerService] getTrainerByExpertise called with expertise: " + request.getExpertise()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerService] Invoking business logic for getTrainerByExpertise");
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
            System.out.println("[TrainerService] getTrainerByExpertise succeeded: returned " + trainers.size() + " trainers");
        } catch(Exception e) {
            System.err.println("[TrainerService] Error in getTrainerByExpertise: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        System.out.println("[TrainerService] deleteTrainer called for trainerId: " + request.getTrainerId());
        try {
            System.out.println("[TrainerService] Invoking business logic for deleteTrainer");
            trainerService.deleteTrainer(request.getTrainerId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
            System.out.println("[TrainerService] deleteTrainer succeeded for trainerId: " + request.getTrainerId());
        } catch(Exception e) {
            System.err.println("[TrainerService] Error in deleteTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
