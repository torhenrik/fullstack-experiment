package com.hanken.restapi;

public class Contract {
    /** Exchanged data **/
    private String registrationNumber;
    private String bonus;
    private String birthDate;
    private String name;
    private String surname;
    private String email;

    /** Derived data **/
    private int customerId = 0;
    private int contractId = 0;
    /* Note: The contract is activated if the Business system has updated the contract status to "avtale sendt".
    *  This is not modelled in this special purpose class.
    */
    public Contract() {};
    public Contract (String registrationNumber, String bonus, String birthDate, String name, String surname, String email){
        this.registrationNumber = registrationNumber;
        this.bonus = bonus;
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }
}
