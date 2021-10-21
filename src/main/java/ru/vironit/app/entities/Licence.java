package ru.vironit.app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "licences", schema = "public", catalog = "insurance_service")
public class Licence {

    private int id;
    private int insurerId;
    private String insurerName;
    private String address;
    private int taxpayerIdentificationNumber;
    private String licenceNumber;
    private Date issueDecisionDate;
    private Integer issueDecisionNumber;
    private Boolean confirmation;

    public Licence() {
    }

    public Licence(int id, int insurerId, String insurerName, String address, int taxpayerIdentificationNumber,
                   String licenceNumber, Date issueDecisionDate, int issueDecisionNumber, boolean confirmation) {
        this.id = id;
        this.insurerId = insurerId;
        this.insurerName = insurerName;
        this.address = address;
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.licenceNumber = licenceNumber;
        this.issueDecisionDate = issueDecisionDate;
        this.issueDecisionNumber = issueDecisionNumber;
        this.confirmation = confirmation;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "insurer_id")
    public int getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(int insurerId) {
        this.insurerId = insurerId;
    }

    @Basic
    @Column(name = "insurer_name")
    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "taxpayer_identification_number")
    public int getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(Integer taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    @Basic
    @Column(name = "licence_number")
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @Basic
    @Column(name = "issue_decision_date")
    public Date getIssueDecisionDate() {
        return issueDecisionDate;
    }

    public void setIssueDecisionDate(Date issueDecisionDate) {
        this.issueDecisionDate = issueDecisionDate;
    }

    @Basic
    @Column(name = "issue_decision_number")
    public Integer getIssueDecisionNumber() {
        return issueDecisionNumber;
    }

    public void setIssueDecisionNumber(int issueDecisionNumber) {
        this.issueDecisionNumber = issueDecisionNumber;
    }

    @Basic
    @Column(name = "confirmation")
    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Licence{" +
                "id=" + id +
                ", insurerId=" + insurerId +
                ", insurerName='" + insurerName + '\'' +
                ", address='" + address + '\'' +
                ", taxpayerIdentificationNumber=" + taxpayerIdentificationNumber +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", issueDecisionDate=" + issueDecisionDate +
                ", issueDecisionNumber=" + issueDecisionNumber +
                ", confirmation=" + confirmation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licence licence = (Licence) o;
        return id == licence.id && insurerId == licence.insurerId && taxpayerIdentificationNumber == licence.taxpayerIdentificationNumber && issueDecisionNumber == licence.issueDecisionNumber && confirmation == licence.confirmation && Objects.equals(insurerName, licence.insurerName) && Objects.equals(address, licence.address) && Objects.equals(licenceNumber, licence.licenceNumber) && Objects.equals(issueDecisionDate, licence.issueDecisionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insurerId, insurerName, address, taxpayerIdentificationNumber, licenceNumber, issueDecisionDate, issueDecisionNumber, confirmation);
    }
}
