package ru.vironit.app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "insurance_type", schema = "public", catalog = "insurance_service")
public class InsuranceType {

    private int id;
    private String insuranceType;

    public InsuranceType() {

    }

    public InsuranceType(int id, String insuranceType) {
        this.id = id;
        this.insuranceType = insuranceType;
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
    @Column(name = "insurance_type")
    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public String toString() {
        return "InsuranceType{" +
                "id=" + id +
                ", insuranceType='" + insuranceType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceType that = (InsuranceType) o;
        return id == that.id && Objects.equals(insuranceType, that.insuranceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insuranceType);
    }
}
