package ru.vironit.database;

import app.entities.Client;
import app.dao.DBIO;

import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:postgresql://localhost/insurance_service?user=postgres&password=1234&ssl=false";
    public static final String DB_Driver = "org.postgresql.Driver";

    public static void main(String[] args) throws SQLException {
/*        try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection(DB_URL);//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
            Statement statement = connection.createStatement();
            connection.close();       // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }

        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into clients (Nickname, Email, Password, Phone) values ('Nick', '@mail', '1234', 8029)");

        DBCPDataSource.getStatement().executeUpdate("insert into clients (Nickname, Email, Password, Phone) values ('Nick', '@mail', '1234', 8029)");
*/
        Client client = new Client();
        client.setNickname("Bob");
        client.setPassword("4321");
        client.setEmail("@yandex");

        DBIO test = new DBIO();
        System.out.println(test.extractClient(1).toString());
        test.addClient(client);
        test.updateClient(client, 3);
    }

}
