package app.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Contract {

    private int id;
    private  int offerId;
    private int clientId;
    private LocalDate date;
    private boolean insurerConfirmContractStatus;
    private boolean insurerConfirmPaymentStatus;
    private boolean clientIncidentStatus;
    private boolean insurerConfirmIncidentStatus;
    private boolean clientConfirmPaymentStatus;

    public Contract() {
    }

    public Contract(int id, int offerId, int clientId, LocalDate date, boolean insurerConfirmContractStatus, boolean insurerConfirmPaymentStatus, boolean clientIncidentStatus, boolean insurerConfirmIncidentStatus, boolean clientConfirmPaymentStatus) {
        this.id = id;
        this.offerId = offerId;
        this.clientId = clientId;
        this.date = date;
        this.insurerConfirmContractStatus = insurerConfirmContractStatus;
        this.insurerConfirmPaymentStatus = insurerConfirmPaymentStatus;
        this.clientIncidentStatus = clientIncidentStatus;
        this.insurerConfirmIncidentStatus = insurerConfirmIncidentStatus;
        this.clientConfirmPaymentStatus = clientConfirmPaymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isInsurerConfirmContractStatus() {
        return insurerConfirmContractStatus;
    }

    public void setInsurerConfirmContractStatus(boolean insurerConfirmContractStatus) {
        this.insurerConfirmContractStatus = insurerConfirmContractStatus;
    }

    public boolean isInsurerConfirmPaymentStatus() {
        return insurerConfirmPaymentStatus;
    }

    public void setInsurerConfirmPaymentStatus(boolean insurerConfirmPaymentStatus) {
        this.insurerConfirmPaymentStatus = insurerConfirmPaymentStatus;
    }

    public boolean isClientIncidentStatus() {
        return clientIncidentStatus;
    }

    public void setClientIncidentStatus(boolean clientIncidentStatus) {
        this.clientIncidentStatus = clientIncidentStatus;
    }

    public boolean isInsurerConfirmIncidentStatus() {
        return insurerConfirmIncidentStatus;
    }

    public void setInsurerConfirmIncidentStatus(boolean insurerConfirmIncidentStatus) {
        this.insurerConfirmIncidentStatus = insurerConfirmIncidentStatus;
    }

    public boolean isClientConfirmPaymentStatus() {
        return clientConfirmPaymentStatus;
    }

    public void setClientConfirmPaymentStatus(boolean clientConfirmPaymentStatus) {
        this.clientConfirmPaymentStatus = clientConfirmPaymentStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", offerId=" + offerId +
                ", clientId=" + clientId +
                ", date=" + date +
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
        return id == contract.id && offerId == contract.offerId && clientId == contract.clientId && insurerConfirmContractStatus == contract.insurerConfirmContractStatus && insurerConfirmPaymentStatus == contract.insurerConfirmPaymentStatus && clientIncidentStatus == contract.clientIncidentStatus && insurerConfirmIncidentStatus == contract.insurerConfirmIncidentStatus && clientConfirmPaymentStatus == contract.clientConfirmPaymentStatus && Objects.equals(date, contract.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offerId, clientId, date, insurerConfirmContractStatus, insurerConfirmPaymentStatus, clientIncidentStatus, insurerConfirmIncidentStatus, clientConfirmPaymentStatus);
    }
}
