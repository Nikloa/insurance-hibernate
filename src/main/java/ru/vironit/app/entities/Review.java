package ru.vironit.app.entities;

import java.util.Objects;

public class Review {

    private int Id;
    private String review;
    private double grade;
    private int clientId;
    private int insurerId;

    public Review() {
    }

    public Review(int id, String review, double grade, int clientId, int insurerId) {
        Id = id;
        this.review = review;
        this.grade = grade;
        this.clientId = clientId;
        this.insurerId = insurerId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(int insurerId) {
        this.insurerId = insurerId;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "Id=" + Id +
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
        return Id == reviews.Id && Double.compare(reviews.grade, grade) == 0 && clientId == reviews.clientId && insurerId == reviews.insurerId && Objects.equals(review, reviews.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, review, grade, clientId, insurerId);
    }
}
