package com.example;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "root", "yourpassword");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Attendance VALUES (?, ?, ?)");
            ps.setInt(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();

            out.println("<h3>Attendance Recorded Successfully!</h3>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
