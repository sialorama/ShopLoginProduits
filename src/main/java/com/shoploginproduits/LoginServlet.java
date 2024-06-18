package com.shoploginproduits;

import com.shoploginproduits.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null) {
            response.sendRedirect("err.jsp");
            return;
        }

        // Authenticate user using Hibernate
        User user = authenticateUser(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Store user object in session
            response.sendRedirect("home.jsp"); // Redirect to products page after successful login

        } else {
            response.sendRedirect("err.jsp");
            System.out.println("JE N'ai PAS PU récupérer les id de la DB !");
        }
    }

    private User authenticateUser(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE email = :email AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            System.out.println("J'ai récupéré les id de la DB !");
            return query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
