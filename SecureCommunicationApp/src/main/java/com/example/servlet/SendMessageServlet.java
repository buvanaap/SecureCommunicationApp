package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendMessage")
public class SendMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userMessage = request.getParameter("message");
        
        try {
            String dbURL = "jdbc:mysql://localhost:3306/secure_app";
            String username = "root"; 
            String password = "buvanaapavithran"; 
            
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            String sql = "INSERT INTO messages (message) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userMessage);
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                response.getWriter().println("Message saved successfully.");
            }
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
    }
}
