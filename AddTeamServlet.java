package ipl;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addteam")
public class AddTeamServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String teamName = request.getParameter("teamName");
        String shortName = request.getParameter("shortName");
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO teams (team_name, short_name) VALUES (?, ?)");
            
            pstmt.setString(1, teamName);
            pstmt.setString(2, shortName);
            pstmt.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        response.sendRedirect("teams");
    }
}

