package de.thws.fiw.gymmanagement.application;

import de.thws.fiw.gymmanagement.domain.TrainerLogicAdapter;
import de.thws.fiw.gymmanagement.domain.Trainer;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;

public class TrainerServiceImpl extends TrainerServiceGrpc.TrainerServiceImplBase {

    private final TrainerLogicAdapter trainerService;

    public TrainerServiceImpl(TrainerLogicAdapter trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public void createTrainer(CreateTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] createTrainer called with name: " + request.getName()
                + ", expertise: " + request.getExpertise());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for createTrainer");
            Trainer trainer = trainerService.createTrainer(request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[TrainerServiceImpl] createTrainer succeeded: created trainer with id " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerServiceImpl] Error in createTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void updateTrainer(UpdateTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] updateTrainer called for trainerId: " + request.getTrainerId()
                + " with new name: " + request.getName() + ", expertise: " + request.getExpertise());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for updateTrainer");
            Trainer trainer = trainerService.updateTrainer(request.getTrainerId(), request.getName(), request.getExpertise());
            GetTrainerResponse response = GetTrainerResponse.newBuilder()
                    .setTrainerId(trainer.getId())
                    .setName(trainer.getName())
                    .setExpertise(trainer.getExpertise())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            System.out.println("[TrainerServiceImpl] updateTrainer succeeded for trainerId: " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerServiceImpl] Error in updateTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void getTrainer(GetTrainerRequest request, StreamObserver<GetTrainerResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] getTrainer called for trainerId: " + request.getTrainerId());
        try {
            Trainer trainer = trainerService.getTrainer(request.getTrainerId());
            if (trainer == null) {
                System.err.println("[TrainerServiceImpl] getTrainer: Trainer with id " + request.getTrainerId() + " not found");
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
            System.out.println("[TrainerServiceImpl] getTrainer succeeded for trainerId: " + response.getTrainerId());
        } catch (Exception e) {
            System.err.println("[TrainerServiceImpl] Error in getTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void getAllTrainers(GetAllTrainersRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] getAllTrainers called with pagesize: " + request.getPagesize()
                + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for getAllTrainers");
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
            System.out.println("[TrainerServiceImpl] getAllTrainers succeeded: returned " + trainers.size() + " trainers");
        } catch (Exception e) {
            System.err.println("[TrainerServiceImpl] Error in getAllTrainers: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void getTrainerByName(GetTrainerByNameRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] getTrainerByName called with name: " + request.getName()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for getTrainerByName");
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
            System.out.println("[TrainerServiceImpl] getTrainerByName succeeded: returned " + trainers.size() + " trainers");
        } catch(Exception e) {
            System.err.println("[TrainerServiceImpl] Error in getTrainerByName: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void getTrainerByExpertise(GetTrainerByExpertiseRequest request, StreamObserver<GetAllTrainersResponse> responseObserver) {
        System.out.println("[TrainerServiceImpl] getTrainerByExpertise called with expertise: " + request.getExpertise()
                + ", pagesize: " + request.getPagesize() + ", index: " + request.getIndex());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for getTrainerByExpertise");
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
            System.out.println("[TrainerServiceImpl] getTrainerByExpertise succeeded: returned " + trainers.size() + " trainers");
        } catch(Exception e) {
            System.err.println("[TrainerServiceImpl] Error in getTrainerByExpertise: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void deleteTrainer(DeleteTrainerRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {
        System.out.println("[TrainerServiceImpl] deleteTrainer called for trainerId: " + request.getTrainerId());
        try {
            System.out.println("[TrainerServiceImpl] Invoking business logic for deleteTrainer");
            trainerService.deleteTrainer(request.getTrainerId());
            responseObserver.onNext(com.google.protobuf.Empty.getDefaultInstance());
            responseObserver.onCompleted();
            System.out.println("[TrainerServiceImpl] deleteTrainer succeeded for trainerId: " + request.getTrainerId());
        } catch(Exception e) {
            System.err.println("[TrainerServiceImpl] Error in deleteTrainer: " + e.getMessage());
            responseObserver.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
        System.out.println("-------------------------------------------------");
    }
}
