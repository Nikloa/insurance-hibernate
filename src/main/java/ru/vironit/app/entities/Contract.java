package ru.vironit.app.entities;

import javax.persistence.*;
import java.beans.Transient;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contracts", schema = "public", catalog = "insurance_service")
public class Contract {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "offer_id")
    private int offerId;

    @Basic
    @Column(name = "client_id")
    private int clientId;

    @Basic
    @Column(name = "insurer_confirm_contract_status")
    private Boolean insurerConfirmContractStatus;

    @Basic
    @Column(name = "client_confirm_payment_status")
    private Boolean insurerConfirmPaymentStatus;

    @Basic
    @Column(name = "contract_date")
    private Date contractDate;

    @Basic
    @Column(name = "client_incident_status")
    private Boolean clientIncidentStatus;

    @Basic
    @Column(name = "insurer_confirm_incident_status")
    private Boolean insurerConfirmIncidentStatus;

    @Basic
    @Column(name = "insurer_confirm_payment_status")
    private Boolean clientConfirmPaymentStatus;

    public Contract() {
    }

    public Contract(int id, Date date, boolean insurerConfirmContractStatus, boolean insurerConfirmPaymentStatus, boolean clientIncidentStatus, boolean insurerConfirmIncidentStatus, boolean clientConfirmPaymentStatus, int clientId, int offerId ) {
        this.id = id;
        this.contractDate = date;
        this.insurerConfirmContractStatus = insurerConfirmContractStatus;
        this.insurerConfirmPaymentStatus = insurerConfirmPaymentStatus;
        this.clientIncidentStatus = clientIncidentStatus;
        this.insurerConfirmIncidentStatus = insurerConfirmIncidentStatus;
        this.clientConfirmPaymentStatus = clientConfirmPaymentStatus;
        this.offerId = offerId;
        this.clientId = clientId;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }


    public Boolean getInsurerConfirmContractStatus() {
        return insurerConfirmContractStatus;
    }

    public void setInsurerConfirmContractStatus(boolean insurerConfirmContractStatus) {
        this.insurerConfirmContractStatus = insurerConfirmContractStatus;
    }

    public Boolean getInsurerConfirmPaymentStatus() {
        return insurerConfirmPaymentStatus;
    }

    public void setInsurerConfirmPaymentStatus(Boolean insurerConfirmPaymentStatus) {
        this.insurerConfirmPaymentStatus = insurerConfirmPaymentStatus;
    }

    public Boolean getClientIncidentStatus() {
        return clientIncidentStatus;
    }

    public void setClientIncidentStatus(Boolean clientIncidentStatus) {
        this.clientIncidentStatus = clientIncidentStatus;
    }


    public Boolean getInsurerConfirmIncidentStatus() {
        return insurerConfirmIncidentStatus;
    }

    public void setInsurerConfirmIncidentStatus(Boolean insurerConfirmIncidentStatus) {
        this.insurerConfirmIncidentStatus = insurerConfirmIncidentStatus;
    }

    public Boolean getClientConfirmPaymentStatus() {
        return clientConfirmPaymentStatus;
    }

    public void setClientConfirmPaymentStatus(Boolean clientConfirmPaymentStatus) {
        this.clientConfirmPaymentStatus = clientConfirmPaymentStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", offerId=" + offerId +
                ", clientId=" + clientId +
                ", date=" + contractDate +
                ", insurerConfirmContractStatus=" + insurerConfirmContractStatus +
                ", insurerConfirmPaymentStatus=" + insurerConfirmPaymentStatus +
                ", clientIncidentStatus=" + clientIncidentStatus +
                ", insurerConfirmIncidentStatus=" + insurerConfirmIncidentStatus +
                ", clientConfirmPaymentStatus=" + clientConfirmPaymentStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id && offerId == contract.offerId &&
                clientId == contract.clientId &&
                insurerConfirmContractStatus == contract.insurerConfirmContractStatus &&
                insurerConfirmPaymentStatus == contract.insurerConfirmPaymentStatus &&
                clientIncidentStatus == contract.clientIncidentStatus &&
                insurerConfirmIncidentStatus == contract.insurerConfirmIncidentStatus &&
                clientConfirmPaymentStatus == contract.clientConfirmPaymentStatus &&
                Objects.equals(contractDate, contract.contractDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offerId, clientId, contractDate, insurerConfirmContractStatus, insurerConfirmPaymentStatus, clientIncidentStatus, insurerConfirmIncidentStatus, clientConfirmPaymentStatus);
    }
}
