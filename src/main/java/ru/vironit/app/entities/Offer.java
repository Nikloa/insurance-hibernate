package ru.vironit.app.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Offer {

    private int Id;
    private int insuranceTypeId;
    private String description;
    private BigDecimal cost;
    private int insurerId;
    private boolean visible;
    private int term;

    public Offer() {

    }

    public Offer(int id, int insuranceTypeId, String description, BigDecimal cost, int insurerId, boolean visible, int term) {
        Id = id;
        this.insuranceTypeId = insuranceTypeId;
        this.description = description;
        this.term = term;
        this.cost = cost;
        this.insurerId = insurerId;
        this.visible = visible;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceType) {
        this.insuranceTypeId = insuranceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(int insurerId) {
        this.insurerId = insurerId;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "Id=" + Id +
                ", insuranceType=" + insuranceTypeId +
                ", description='" + description + '\'' +
                ", term=" + term +
                ", cost=" + cost +
                ", insurerId=" + insurerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offers = (Offer) o;
        return Id == offers.Id && insuranceTypeId == offers.insuranceTypeId && insurerId == offers.insurerId && Objects.equals(description, offers.description) && Objects.equals(term, offers.term) && Objects.equals(cost, offers.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, insuranceTypeId, description, term, cost, insurerId);
    }
}
