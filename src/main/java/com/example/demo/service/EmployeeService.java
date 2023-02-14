package com.example.demo.service;

import com.example.demo.v1.EmployeeServiceGrpc;
import com.example.demo.v1.GetEmployeeRequest;
import com.example.demo.v1.RegisterEmployeeRequest;
import com.example.demo.v1.type.EmployeeProto;
import com.example.demo.v1.type.Role;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.RandomStringUtils;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Override
    public void registerEmployee(RegisterEmployeeRequest request, StreamObserver<EmployeeProto> responseObserver) {
        EmployeeProto employeeProto = EmployeeProto.newBuilder()
                .setEmpId(RandomStringUtils.randomAlphanumeric(10))
                .setName(request.getName())
                .setJoinDate(request.getJoinDate())
                .setRole(request.getRole())
                .build();
        responseObserver.onNext(employeeProto);
        responseObserver.onCompleted();
    }

    @Override
    public void getEmployee(GetEmployeeRequest request, StreamObserver<EmployeeProto> responseObserver) {
        com.google.type.Date joinDate = com.google.type.Date.newBuilder()
                .setDay(11)
                .setMonth(1)
                .setYear(2020)
                .build();

        EmployeeProto employeeProto = EmployeeProto.newBuilder()
                .setEmpId(request.getEmpId())
                .setName("John Doe")
                .setJoinDate(joinDate)
                .setRole(Role.HR)
                .build();

        responseObserver.onNext(employeeProto);
        responseObserver.onCompleted();
    }
}
