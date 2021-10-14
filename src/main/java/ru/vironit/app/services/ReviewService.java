package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.ReviewImplementation;
import ru.vironit.app.dao.interfaces.ReviewInterface;
import ru.vironit.app.entities.Review;

import java.sql.SQLException;

public class ReviewService implements ReviewInterface {

    private ReviewImplementation implementation;

    public ReviewService() {
        implementation = new ReviewImplementation();
    }

    @Override
    public void addReview(Review review) throws SQLException {
        implementation.addReview(review);

    }

    @Override
    public Review extractReview(int id) throws SQLException {
        Review review = implementation.extractReview(id);
        return review;
    }

    @Override
    public void updateReview(Review review, int id) throws SQLException {
        implementation.updateReview(review, id);
    }

    @Override
    public void deleteReview(int id) throws  SQLException {
        implementation.deleteReview(id);
    }
}
