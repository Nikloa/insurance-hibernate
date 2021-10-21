package ru.vironit.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "offers", schema = "public", catalog = "insurance_service")
public class Offer {

    private int id;
    private int insuranceTypeId;
    private String description;
    private BigDecimal cost;
    private int insurerId;
    private boolean visible;
    private int term;

    public Offer() {

    }

    public Offer(int id, int insuranceTypeId, String description, BigDecimal cost, int insurerId, boolean visible, int term) {
        this.id = id;
        this.insuranceTypeId = insuranceTypeId;
        this.description = description;
        this.term = term;
        this.cost = cost;
        this.insurerId = insurerId;
        this.visible = visible;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "insurance_type_id")
    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceType) {
        this.insuranceTypeId = insuranceType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "term")
    public int getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
    @Column(name = "visible")
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "Id=" + id +
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
        return id == offers.id && insuranceTypeId == offers.insuranceTypeId && insurerId == offers.insurerId && Objects.equals(description, offers.description) && Objects.equals(term, offers.term) && Objects.equals(cost, offers.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insuranceTypeId, description, term, cost, insurerId);
    }
}
