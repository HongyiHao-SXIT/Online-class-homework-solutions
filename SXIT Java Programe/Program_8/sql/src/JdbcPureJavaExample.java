package Program_8.sql.src;
import java.sql.*;

import java.sql.*;

public class JdbcPureJavaExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";  // 使用你的数据库信息
        String username = "root";  // 数据库用户名
        String password = "password";  // 数据库密码
        String query = "SELECT * FROM student";

        try {
            // 加载 JDBC 驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建 Statement 对象
            Statement stmt = conn.createStatement();

            // 执行查询
            ResultSet rs = stmt.executeQuery(query);

            // 处理查询结果并打印
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
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
