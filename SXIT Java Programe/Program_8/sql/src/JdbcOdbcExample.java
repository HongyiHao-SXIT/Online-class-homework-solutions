package Program_8.sql.src;
import java.sql.*;

public class JdbcOdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:odbc:mybook";  
        String username = "root";
        String password = "123456";
        String query = "SELECT * FROM student";

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String major = rs.getString("major");
                System.out.println("ID: " + id + ", Name: " + name + ", Major: " + major);
            }

            // 关闭资源
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC-ODBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
