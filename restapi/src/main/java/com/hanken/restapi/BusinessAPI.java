package com.hanken.restapi;

public interface BusinessAPI {
    public int createCustomer(String birthDate, String name, String surname, String email);

    public int createContract(int customerId, String registrationNumber, String bonus);

    public String updateContractStatus(int ContractId, String newStatus);
}
