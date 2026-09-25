package ipl;
import java.sql.*;

public class DBConnection {
    static Connection conn;
    
    public static Connection getConnection() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connection details
            String url = "jdbc:mysql://localhost:3306/ipl";
            String user = "root";
            String password = "gousia283@";  // Change to your password
            
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✓ Connected to database!");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e);
        }
        return conn;
    }
}


