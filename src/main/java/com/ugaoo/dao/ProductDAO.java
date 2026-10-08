package com.ugaoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // CREATE
    public boolean addProduct(String name, String category,
                              double price, int quantity,
                              String description) {

        String sql = "INSERT INTO products " +
                     "(name, category, price, quantity, description) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, description);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<String[]> getAllProducts() {

        List<String[]> products = new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                String[] product = {
                    String.valueOf(rs.getInt("id")),
                    rs.getString("name"),
                    rs.getString("category"),
                    String.valueOf(rs.getDouble("price")),
                    String.valueOf(rs.getInt("quantity")),
                    rs.getString("description")
                };

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    // UPDATE
    public boolean updateProduct(int id, String name,
                                 String category, double price,
                                 int quantity, String description) {

        String sql = "UPDATE products SET name=?, category=?, " +
                     "price=?, quantity=?, description=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, description);
            ps.setInt(6, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteProduct(int id) {

        String sql = "DELETE FROM products WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}