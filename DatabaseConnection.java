import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/expensetracker";
        String dbUser = "root";
        String dbPassword = "password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }
}
