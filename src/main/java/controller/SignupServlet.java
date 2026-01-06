package controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

       
        if (username == null || password == null ||
            username.trim().length() < 3 ||
            password.trim().length() < 6) {

            response.getWriter().println(
                "<h3 style='color:red;'>Invalid input</h3>" +
                "<a href='signup.html'>Go back</a>"
            );
            return;
        }

      
        String hashedPassword = hashPassword(password);

      
        User user = new User(username, hashedPassword, "user");

    
        UserDAO userDAO = new UserDAO();

        if (userDAO.usernameExists(username)) {
            response.getWriter().println(
                "<h3 style='color:red;'>Username already taken</h3>" +
                "<a href='signup.html'>Go back</a>"
            );
            return;
        }

        
        userDAO.saveUser(user);

        
        response.sendRedirect("login.html");
    }


    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
