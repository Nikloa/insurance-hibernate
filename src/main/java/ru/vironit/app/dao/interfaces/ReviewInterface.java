package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Review;

import java.sql.SQLException;

public interface ReviewInterface {

    void addReview(Review review) throws SQLException;
    Review extractReview(int id) throws SQLException;
    void updateReview(Review review, int id) throws SQLException;
    void deleteReview(int id) throws SQLException;
}
