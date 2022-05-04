package app;


import java.sql.*;
import java.util.Locale;

public class MainRunner {
    static final String DB_URL = "jdbc:mariadb://localhost:3306/jdbcdemo";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "select * from employees";

    public static void main(String[] args) {


        DatabaseConnection db = new DatabaseConnection();

        db.connect();

        try {
            db.ps = db.conn.prepareStatement(EmployeeDAO.SQL.GetAllEmployees.getQuery());
            db.rs = db.ps.executeQuery();

            System.out.printf("%-4s %-20s %-10s%n",
                    "ID",
                    "Name",
                    "Salary"

            );
            System.out.println("----------------------------------");
            while (db.rs.next()) {
                System.out.printf("%-4d %-20s %-10.2f",
                        db.rs.getInt(1),
                        db.rs.getString(2).trim().toUpperCase(Locale.US),
                        db.rs.getDouble(3)

                );
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.dispose();

        EmployeeService es = new EmployeeService();
        System.out.println(es.GetAllEmployees());

    }
}
