package ru.vironit.app.dao.implementation;

import ru.vironit.app.dao.interfaces.ReviewInterface;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Review;

import java.sql.*;

public class ReviewImplementation implements ReviewInterface {

    @Override
    public void addReview(Review review) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into reviews (review, grade, client_id, insurer_id) values (?, ?, ?, ?)");
        preparedStatement.setString(1, review.getReview());
        preparedStatement.setDouble(2, review.getGrade());
        preparedStatement.setInt(3, review.getClientId());
        preparedStatement.setInt(4, review.getInsurerId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }


    @Override
    public Review extractReview(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from reviews where id = " + id);
        resultSet.next();
        Review type = new Review(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getDouble(3),
                resultSet.getInt(4),
                resultSet.getInt(5));
        statement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
        return type;
    }

    @Override
    public void updateReview(Review review, int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update reviews set reviews = ?, grade = ?, client_id = ?, insurer_id = ? where id = ?");
        preparedStatement.setString(1, review.getReview());
        preparedStatement.setDouble(2, review.getGrade());
        preparedStatement.setInt(3, review.getClientId());
        preparedStatement.setInt(4, review.getInsurerId());
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }

    @Override
    public void deleteReview(int id) throws SQLException {
        Connection connection = DatabasePool.getConnectionPool().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from reviews where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        DatabasePool.getConnectionPool().releaseConnection(connection);
    }
}
