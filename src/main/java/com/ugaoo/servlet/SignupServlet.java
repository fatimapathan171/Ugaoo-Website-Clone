package com.ugaoo.servlet;

import com.ugaoo.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        UserDAO userDAO = new UserDAO();

        boolean registered = userDAO.registerUser(
                firstName,
                lastName,
                email,
                password
        );

        if (registered) {
            response.sendRedirect("Login.html");
        } else {
            response.getWriter().println("Registration failed.");
        }
    }
}