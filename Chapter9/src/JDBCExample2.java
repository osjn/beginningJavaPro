// import sqlj.runtime.*;
// import sqlj.runtime.ref.*;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JDBCExample2 {
    public static void main(String[] args) {
        int DeptNr = 0;
        try {
            System.out.println("Loading JDBC driver...");
            Class.forName("com.mysql.jdbc.Driver");
//            DefaultContext.setDefaultContext(new DefaultContext(
//                    "jdbc:mysql://localhsot:3306/employeeschema", "root", ""));
            System.out.println("JDBC driver successfully loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.println("Please enter the department number: ");
            DeptNr = keyboard.nextInt();
        } catch (InputMismatchException err) {
            System.out.println("Incorrect input");
        }
        String url = "jdbc:mysql://localhost:3306/employeeschema";
        String username = "root";
        String password = "";
        String query = "select Name, Gender, DNR from employee where DNR = ?";
        Connection connection = null;
        try {
            System.out.println("Connecting to the MySQL database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("MySQL Database connected!");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, DeptNr);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(" ");
                System.out.print(rs.getString(2));
                System.out.print(" ");
                System.out.println(rs.getInt(3));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Closing the connection");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {}
            }
        }
    }
}
