package ru.netology.web.data;

import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class SQLdata {
    private static final String url = System.getProperty("url");
    private static final String user = System.getProperty("user");
    private static final String password = System.getProperty("password");

    private SQLdata() {
    }

    public static String getPayStatusByDebitCard() {
        val statusBD = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection(url, user, password);
                val payStatus = connection.createStatement();
        ) {
            try (val rs = payStatus.executeQuery(statusBD)) {
                if (rs.next()) {
                    val status = rs.getString(1);
                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getPayStatusByCreditCard() {
        val statusBD = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";

        try (
                val connection = getConnection(url, user, password);
                val payStatus = connection.createStatement();
        ) {
            try (val rs = payStatus.executeQuery(statusBD)) {
                if (rs.next()) {
                    val status = rs.getString(1);
                    return status;
                }
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void cleanDataBase() {

        val credit = "DELETE FROM credit_request_entity";
        val order = "DELETE FROM order_entity";
        val payment = "DELETE FROM payment_entity";

        try (
                val conn = getConnection(url, user, password);
                val prepareStatCredit = conn.createStatement();
                val prepareStatOrder = conn.createStatement();
                val prepareStatPayment = conn.createStatement();
        ) {
            prepareStatCredit.executeUpdate(credit);
            prepareStatOrder.executeUpdate(order);
            prepareStatPayment.executeUpdate(payment);

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
