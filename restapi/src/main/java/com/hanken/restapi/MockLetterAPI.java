package com.hanken.restapi;

public class MockLetterAPI implements LetterAPI {

    public String sendContractToCustomer(Contract contract) {
        String sentStatus = "";
         // Perhaps the LetterAPI might be able to validate some of the contract data?
        if (contract.getCustomerId() != 0 && contract.getContractId() != 0) {
            return "avtale sendt";
        }
        else {
            return "Feil: Avtale kunne ikke sendes.";
        }
    }
}
