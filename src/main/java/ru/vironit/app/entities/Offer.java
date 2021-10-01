package ru.vironit.app.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Offer {

    private int Id;
    private int insuranceType;
    private String description;
    private Date term;
    private BigDecimal cost;
    private int insurerId;

    public Offer() {
    }

    public Offer(int id, int insuranceType, String description, Date term, BigDecimal cost, int insurerId) {
        Id = id;
        this.insuranceType = insuranceType;
        this.description = description;
        this.term = term;
        this.cost = cost;
        this.insurerId = insurerId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(int insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
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

    @Override
    public String toString() {
        return "Offers{" +
                "Id=" + Id +
                ", insuranceType=" + insuranceType +
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
        return Id == offers.Id && insuranceType == offers.insuranceType && insurerId == offers.insurerId && Objects.equals(description, offers.description) && Objects.equals(term, offers.term) && Objects.equals(cost, offers.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, insuranceType, description, term, cost, insurerId);
    }
}
