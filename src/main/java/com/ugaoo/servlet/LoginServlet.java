package com.ugaoo.servlet;

import com.ugaoo.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        UserDAO userDAO = new UserDAO();

        boolean valid = userDAO.loginUser(email, password);

        if (valid) {

            // Create login session
            request.getSession().setAttribute("userEmail", email);

            // Redirect to home page
            response.sendRedirect("Home.html");

        } else {

            response.getWriter().println("Invalid email or password.");
        }
    }
}