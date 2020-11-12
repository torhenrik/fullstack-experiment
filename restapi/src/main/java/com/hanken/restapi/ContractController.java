package com.hanken.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    private final BusinessAPI businessAPI;
    private final LetterAPI letterAPI;

    /*
     * Use mock classes by default.
     */
    public ContractController() {
        this.businessAPI = new MockBusinessAPI();
        this.letterAPI = new MockLetterAPI();
    }

    /*
     * Inject real implementations of businessAPI and/or LetterAPI here.
     * TODO: There is probably a better way to do this in Spring Boot.
     */
    public ContractController(BusinessAPI businessAPI, LetterAPI letterAPI) {
        this.businessAPI = businessAPI;
        this.letterAPI = letterAPI;
    }

    /*
     * NB! This service obviously needs an authentication mechanism too.
     * This has not been implemented.
     */

    @PostMapping("/createContract")
    public String createContract(Contract contract) {
        String contractStatus = ""; // Keep track of what's happening to the contract

        /*
         * TODO: Validate all fields serverside and return an error if a field is invalid.
         * Could also be done by raising and catching exceptions.
         */

        /*
         * The operations involved in creating a new contract.
         * NB: Checking for errors could also be done by catching exceptions raised in the BusinessAPI.
         */

        // 1) Create customer
        int customerId = this.businessAPI.createCustomer(contract.getBirthDate(), contract.getName(), contract.getSurname(), contract.getEmail());
        if (customerId == 0) {
            contractStatus = "Feil: Kunne ikke opprette kunde";
        } else {
            contract.setCustomerId(customerId);

            // 2) Create contract
            int contractId = this.businessAPI.createContract(contract.getCustomerId(), contract.getRegistrationNumber(), contract.getBonus());
            if (contractId == 0) {
                contractStatus = "Feil: Kunne ikke opprette kontrakt";
            } else {
                contract.setContractId(contractId);

                // 3) Send contract to customer
                contractStatus = this.letterAPI.sendContractToCustomer(contract);
                if (!(contractStatus.equals("avtale sendt"))) {
                    contractStatus = "Feil: Kunne ikke sende kontrakt til kunde.";
                } else {

                    // 4) Update contract status
                    contractStatus = this.businessAPI.updateContractStatus(contract.getContractId(), "avtale sendt");
                    if (!contractStatus.equals("avtale sendt")) {
                        contractStatus = "Feil: Kunde har fått bekreftelse på avtale som ikke kunne aktiveres.";
                    }
                }
            }
        }
        // TODO: We probably shouldn't return HTTP 200 in case of an error.
        return "{avtalenummer:" + contract.getContractId() + ", status: \"" + contractStatus + "\"}";
    }
}
