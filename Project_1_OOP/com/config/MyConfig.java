package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConfig {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_product";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection connect;
    private Statement statement;
    private ResultSet resultSet;

    public MyConfig() {
        connection();
    }

    // CONNECTION
    private void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection: Failed");
        }
    }

    // CREATE
    public void insertData(String nama, int harga, int stock) {
        try {
            String query = "INSERT INTO `tb_product` (NAMA, HARGA, STOCK) VALUES ('" +
                    nama + "', " +
                    harga + ", " +
                    stock +
                    ")";
            statement = connect.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public void getDatabase() {
        try {
            String query = "SELECT NAMA, HARGA, STOCK FROM `tb_product` ORDER BY ID DESC";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAMA") + ": Rp " +
                                resultSet.getInt("HARGA") + " (" +
                                resultSet.getInt("STOCK") + ")"
                );
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateData(int id, String nama, int harga, int stock) {
        try {
            String query = "UPDATE `tb_product` SET NAMA='" +
                    nama + "', HARGA=" +
                    harga + ", STOCK=" +
                    stock + " WHERE ID=" +
                    id;
            statement = connect.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Failed to update data.");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteData(int id) {
        try {
            String query = "DELETE FROM `tb_product` WHERE ID =" + id;
            statement = connect.createStatement();
            int rowsDeleted = statement.executeUpdate(query);
            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("Failed to delete data.");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}