import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String category = request.getParameter("category");
        String amount = request.getParameter("amount");

        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO expenses(user, category, amount) VALUES (?, ?, ?)");
            stmt.setString(1, user);
            stmt.setString(2, category);
            stmt.setString(3, amount);
            stmt.executeUpdate();

            response.sendRedirect("dashboard.html?message=Expense Added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
