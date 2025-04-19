package com.example.shopsmart.service;

import com.example.shopsmart.dao.ProductDAO;
import com.example.shopsmart.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    // Method to get the total number of products
    public static int getTotalProducts() throws SQLException {
        return ProductDAO.getTotalProducts();
    }

    // Method to get products by category (this is useful for recommendations)
    public static List<Product> getRecommendedProducts(String category) throws SQLException {
        return ProductDAO.getProductsByCategory(category);
    }
}
