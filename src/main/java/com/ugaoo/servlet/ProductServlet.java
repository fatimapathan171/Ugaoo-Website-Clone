package com.ugaoo.servlet;

import com.ugaoo.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    // CREATE + UPDATE + DELETE
    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // UPDATE
        if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String description = request.getParameter("description");

            boolean success = productDAO.updateProduct(
                    id, name, category, price, quantity, description
            );

            if (success) {
                response.sendRedirect("products");
            } else {
                response.getWriter().println(
                        "Product could not be updated."
                );
            }

        // DELETE
        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            boolean success = productDAO.deleteProduct(id);

            if (success) {
                response.sendRedirect("products");
            } else {
                response.getWriter().println(
                        "Product could not be deleted."
                );
            }

        // CREATE
        } else {

            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String description = request.getParameter("description");

            boolean success = productDAO.addProduct(
                    name, category, price, quantity, description
            );

            if (success) {
                response.sendRedirect("Product.html");
            } else {
                response.getWriter().println(
                        "Product could not be added. Check Tomcat console."
                );
            }
        }
    }

    // READ
    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        var products = productDAO.getAllProducts();

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println(
                "<title>Ugaoo Products</title>"
        );
        response.getWriter().println("</head>");

        response.getWriter().println("<body>");

        response.getWriter().println("<h1>Ugaoo Products</h1>");

        response.getWriter().println(
                "<table border='1' cellpadding='10'>"
        );

        response.getWriter().println(
                "<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>Category</th>" +
                "<th>Price</th>" +
                "<th>Quantity</th>" +
                "<th>Description</th>" +
                "<th>Delete</th>" +
                "<th>Update</th>" +
                "</tr>"
        );

        for (String[] product : products) {

            response.getWriter().println(

                    "<tr>" +

                    "<td>" + product[0] + "</td>" +

                    "<td>" + product[1] + "</td>" +

                    "<td>" + product[2] + "</td>" +

                    "<td>" + product[3] + "</td>" +

                    "<td>" + product[4] + "</td>" +

                    "<td>" + product[5] + "</td>" +

                    // DELETE BUTTON
                    "<td>" +

                    "<form action='products' method='post'>" +

                    "<input type='hidden' " +
                    "name='action' value='delete'>" +

                    "<input type='hidden' " +
                    "name='id' value='" + product[0] + "'>" +

                    "<button type='submit'>Delete</button>" +

                    "</form>" +

                    "</td>" +

                    // UPDATE FORM
                    "<td>" +

                    "<form action='products' method='post'>" +

                    "<input type='hidden' " +
                    "name='action' value='update'>" +

                    "<input type='hidden' " +
                    "name='id' value='" + product[0] + "'>" +

                    "<input type='text' " +
                    "name='name' value='" + product[1] + "'>" +

                    "<br><br>" +

                    "<input type='text' " +
                    "name='category' value='" + product[2] + "'>" +

                    "<br><br>" +

                    "<input type='number' " +
                    "step='0.01' " +
                    "name='price' value='" + product[3] + "'>" +

                    "<br><br>" +

                    "<input type='number' " +
                    "name='quantity' value='" + product[4] + "'>" +

                    "<br><br>" +

                    "<input type='text' " +
                    "name='description' value='" + product[5] + "'>" +

                    "<br><br>" +

                    "<button type='submit'>Update</button>" +

                    "</form>" +

                    "</td>" +

                    "</tr>"
            );
        }

        response.getWriter().println("</table>");

        response.getWriter().println("</body>");

        response.getWriter().println("</html>");
    }
}