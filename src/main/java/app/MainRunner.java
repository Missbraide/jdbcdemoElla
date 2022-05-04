package app;

import app.queries.QueriesAndStatements;

import java.sql.*;
import java.util.Locale;

public class MainRunner {
    static final String DB_URL = "jdbc:mariadb://localhost:3306/jdbcdemo";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "select * from employees";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement s = conn.createStatement();
             PreparedStatement ps = conn.prepareStatement(QueriesAndStatements.DeleteEmployeeById.getQuery());
             ResultSet rs = s.executeQuery(QueriesAndStatements.GetAllEmployees.getQuery());
        ) {
            //s.executeUpdate("insert into employees (name,salary) values('test',123.0)");

            ps.setInt(1,5);
            int rows = ps.executeUpdate();

            System.out.printf("%-4s %-20s %-10s%n",
                    "ID",
                    "Name",
                    "Salary"

            );
            System.out.println("----------------------------------");
            while (rs.next()) {
                System.out.printf("%-4d %-20s %-10.2f",
                        rs.getInt(1),
                        rs.getString(2).trim().toUpperCase(Locale.US),
                        rs.getDouble(3)

                );
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
