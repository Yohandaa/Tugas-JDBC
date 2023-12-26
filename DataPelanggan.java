package com.PBO11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataPelanggan implements Struk {
    String faktur;
    String nama;
    String noHP;
    String namaBarang;
    String alamat;
    Integer hargaBarang;
    Integer jmlBarang;
    Integer totalBayar;

    @Override
    public void cetakStruk() {
    }

    //method untuk mengisi data pelanggan
    public void isiDataPelanggan() {
    }

    public void insertDataPelanggan() {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO nama_tabel VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, faktur);
                preparedStatement.setString(2, nama);
                preparedStatement.setString(3, noHP);
                preparedStatement.setString(4, alamat);
                preparedStatement.setString(5, namaBarang);
                preparedStatement.setInt(6, hargaBarang);
                preparedStatement.setInt(7, jmlBarang);
                preparedStatement.setInt(8, totalBayar);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDataPelanggan() {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE nama_tabel SET nama = ?, noHP = ?, alamat = ? WHERE faktur = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nama);
                preparedStatement.setString(2, noHP);
                preparedStatement.setString(3, alamat);
                preparedStatement.setString(4, faktur);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDataPelanggan() {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "DELETE FROM nama_tabel WHERE faktur = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, faktur);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchDataPelanggan() {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT * FROM nama_tabel WHERE faktur = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, faktur);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Ambil data dari ResultSet dan set ke properti
                        faktur = resultSet.getString("faktur");
                        nama = resultSet.getString("nama");
                        noHP = resultSet.getString("noHP");
                        alamat = resultSet.getString("alamat");
                        namaBarang = resultSet.getString("namaBarang");
                        hargaBarang = resultSet.getInt("hargaBarang");
                        jmlBarang = resultSet.getInt("jmlBarang");
                        totalBayar = resultSet.getInt("totalBayar");
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
