package ru.vironit.app.entities;

import java.sql.Date;
import java.util.Objects;

public class Passport {

    private int id;
    private int clientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String passportNumber;
    private String identificationNumber;
    private Date issueDate;
    private String issuingAuthority;
    private boolean confirmation;

    public Passport() {
    }

    public Passport(int id, int clientId, String firstName, String lastName, Date birthDate, String passportNumber,
                        String identificationNumber, Date issueDate, String issuingAuthority, boolean confirmation) {
        this.id = id;
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.identificationNumber = identificationNumber;
        this.issueDate = issueDate;
        this.issuingAuthority = issuingAuthority;
        this.confirmation = confirmation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String  getPassportNumber() {
        return passportNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    @Override
    public String toString() {
        return "Passport: " + "Id='" + id + '\''
                + "client Id='" + clientId + '\''
                + "first name='" + firstName + '\''
                + ", last name='" + lastName + '\''
                + ", birth date='" + birthDate.toString() + '\''
                + ", passport number='" + passportNumber + '\''
                + ", identification number='" + identificationNumber + '\''
                + ", issue date='" + issueDate.toString() + '\''
                + ", issuing authority='" + issuingAuthority + '\''
                + ", confirmation='" + String.valueOf(confirmation) + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;
        if (!Objects.equals(id, passport.id)) return false;
        if (!Objects.equals(clientId, passport.clientId)) return false;
        if (!Objects.equals(firstName, passport.firstName)) return false;
        if (!Objects.equals(lastName, passport.lastName)) return false;
        if (!Objects.equals(birthDate, passport.birthDate)) return false;
        if (!Objects.equals(passportNumber, passport.passportNumber)) return false;
        if (!Objects.equals(identificationNumber, passport.identificationNumber)) return false;
        if (!Objects.equals(issueDate, passport.issueDate)) return false;
        if (!Objects.equals(issuingAuthority, passport.issuingAuthority)) return false;
        return Objects.equals(confirmation, passport.confirmation);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + clientId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (identificationNumber != null ? identificationNumber.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (issuingAuthority != null ? issuingAuthority.hashCode() : 0);
        result = 31 * result + (confirmation ? 1 : 0);
        return result;
    }
}
