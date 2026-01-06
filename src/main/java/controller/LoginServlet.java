package controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 1️⃣ Backend validation
        if (username == null || password == null ||
            username.trim().isEmpty() || password.trim().isEmpty()) {

            response.getWriter().println(
                "<h3 style='color:red;'>Invalid input</h3>" +
                "<a href='login.html'>Go back</a>"
            );
            return;
        }

        // 2️⃣ Get user from DAO
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByUsername(username);

        if (user == null) {
            response.getWriter().println(
                "<h3 style='color:red;'>User not found</h3>" +
                "<a href='login.html'>Go back</a>"
            );
            return;
        }

        // 3️⃣ Hash entered password
        String enteredHash = hashPassword(password);

        // 4️⃣ Compare hashes
        if (!enteredHash.equals(user.getPasswordHash())) {
            response.getWriter().println(
                "<h3 style='color:red;'>Incorrect password</h3>" +
                "<a href='login.html'>Try again</a>"
            );
            return;
        }

        // 5️⃣ Create session
        HttpSession session = request.getSession();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role", user.getRole());

        // 6️⃣ Redirect to dashboard
        response.sendRedirect("dashboard.jsp?login=success");
    }

    // 🔐 Password hashing
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
