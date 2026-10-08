package com.ugaoo.servlet;

import com.ugaoo.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/plants")
public class PlantServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get products from MySQL database
        var products = productDAO.getAllProducts();

        // Send products to Plant.jsp
        request.setAttribute("products", products);

        // Open the Ugaoo Plant page
        request.getRequestDispatcher("Plant.jsp")
               .forward(request, response);
    }
}