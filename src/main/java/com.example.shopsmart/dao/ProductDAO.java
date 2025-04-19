package com.example.shopsmart.dao;

import com.example.shopsmart.model.Product;
import com.example.shopsmart.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Products (name, description, price, unit, stock_quantity, expiry_date, category, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getUnit());
            stmt.setInt(5, product.getStockQuantity());
            stmt.setDate(6, new java.sql.Date(product.getExpiryDate().getTime()));
            stmt.setString(7, product.getCategory());
            stmt.setString(8, product.getImageUrl());
            stmt.executeUpdate();
        }
    }

    public static Product getProductById(int productId) throws SQLException {
        String sql = "SELECT * FROM Products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("unit"),
                        rs.getInt("stock_quantity"),
                        rs.getDate("expiry_date"),
                        rs.getString("category"),
                        rs.getString("image_url")
                );
            }
        }
        return null;
    }

    public static List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("unit"),
                        rs.getInt("stock_quantity"),
                        rs.getDate("expiry_date"),
                        rs.getString("category"),
                        rs.getString("image_url")
                );
                list.add(p);
            }
        }
        return list;
    }

    public static void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE Products SET name=?, description=?, price=?, unit=?, stock_quantity=?, expiry_date=?, category=?, image_url=? WHERE product_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getUnit());
            stmt.setInt(5, product.getStockQuantity());
            stmt.setDate(6, new java.sql.Date(product.getExpiryDate().getTime()));
            stmt.setString(7, product.getCategory());
            stmt.setString(8, product.getImageUrl());
            stmt.setInt(9, product.getProductId());
            stmt.executeUpdate();
        }
    }

    public static void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM Products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }

    public static int getTotalProducts() throws SQLException {
        String sql = "SELECT COUNT(*) FROM Products";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);  // The first column is the count
            }
        }
        return 0;  // Return 0 if there are no products
    }

    // Method to get products by category
    public static List<Product> getProductsByCategory(String category) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE category = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category);  // Set the category parameter
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("unit"),
                        rs.getInt("stock_quantity"),
                        rs.getDate("expiry_date"),
                        rs.getString("category"),
                        rs.getString("image_url")
                );
                products.add(p);
            }
        }
        return products;
    }
}

