package com.shoploginproduits;

import com.shoploginproduits.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "login-local", value = "/login-local")
public class LoginServletLocal extends HttpServlet {

    // Simulated user database
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("user@example.com", "password123");
        USERS.put("admin@example.com", "adminpass");
        // Add more users as needed
    }

    User userAdmin = new User("admin@example.com", "password123","admin") ;
    User userclient = new User("client@example.com", "password123","client") ;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password==null) {
            response.sendRedirect("err.jsp"); // Redirect to error page if login fails
            return;
        }
        // Authenticate user
        if (authenticate(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userclient); // Store email as user identifier in session
            response.sendRedirect("produits.jsp"); // Redirect to the main page after successful login
        } else {
            response.sendRedirect("err.jsp"); // Redirect to error page if login fails
        }
    }
    private boolean authenticate(String email, String password) {
        return userclient.getEmail().equals(email) && userclient.getPassword().equals(password);
    }
}