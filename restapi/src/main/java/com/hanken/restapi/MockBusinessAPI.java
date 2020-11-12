package com.hanken.restapi;

public class MockBusinessAPI implements BusinessAPI{

    public MockBusinessAPI() {}

    public int createCustomer(String birthDate, String name, String surname, String email) {
        // Note: The business system should validate the customer parameters.
        int customerId = 5;
        return customerId;
    }

    public int createContract(int customerId, String registrationNumber, String bonus) {
        // Note: The business system should validate that the customer exists.
        int newContractId = 5;
        return newContractId;
    }

    public String updateContractStatus(int ContractId, String newStatus) {
        // Note: The business system should validate that the contract exists and that new status is a valid one.
        return newStatus;
    }
}
