package ru.vironit.app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "public", catalog = "insurance_service")
public class Review {

    private int id;
    private String review;
    private double grade;
    private int clientId;
    private int insurerId;

    public Review() {

    }

    public Review(int id, String review, double grade, int clientId, int insurerId) {
        this.id = id;
        this.review = review;
        this.grade = grade;
        this.clientId = clientId;
        this.insurerId = insurerId;
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
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "grade")
    public double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "insurer_id")
    public int getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(int insurerId) {
        this.insurerId = insurerId;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "Id=" + id +
                ", review='" + review + '\'' +
                ", grade=" + grade +
                ", clientId=" + clientId +
                ", insurerId=" + insurerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review reviews = (Review) o;
        return id == reviews.id && Double.compare(reviews.grade, grade) == 0 && clientId == reviews.clientId && insurerId == reviews.insurerId && Objects.equals(review, reviews.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, grade, clientId, insurerId);
    }
}
