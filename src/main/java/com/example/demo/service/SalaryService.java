package com.example.demo.service;

import com.example.demo.v1.GetSalaryRequest;
import com.example.demo.v1.SalaryServiceGrpc;
import com.example.demo.v1.UpdateSalaryRequest;
import com.example.demo.v1.type.SalaryProto;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class SalaryService extends SalaryServiceGrpc.SalaryServiceImplBase {

    @Override
    public void updateSalary(UpdateSalaryRequest request, StreamObserver<SalaryProto> responseObserver) {
        SalaryProto salary = SalaryProto.newBuilder()
                .setEmpId(request.getEmpId())
                .setSalary(request.getSalary())
                .setName("John Doe")
                .setBonus(3_000_000)
                .build();

        responseObserver.onNext(salary);
        responseObserver.onCompleted();
    }

    @Override
    public void getSalary(GetSalaryRequest request, StreamObserver<SalaryProto> responseObserver) {
        SalaryProto salary = SalaryProto.newBuilder()
                .setEmpId(request.getEmpId())
                .setSalary(10_000_000)
                .setName("John Doe")
                .setBonus(3_000_000)
                .build();

        responseObserver.onNext(salary);
        responseObserver.onCompleted();
    }
}
