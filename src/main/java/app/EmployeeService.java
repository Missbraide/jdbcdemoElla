package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDAO{
    @Override
    public List<Employees> GetAllEmployees() {
        DatabaseConnection db = new DatabaseConnection();
        db.connect();
        List<Employees> eList = new ArrayList<>();
        try {
            db.ps = db.conn.prepareStatement(SQL.GetAllEmployees.getQuery());
            db.rs = db.ps.executeQuery();

            while(db.rs.next()){
                Employees e = new Employees(db.rs.getInt(1),db.rs.getString(2),db.rs.getDouble(3));
                eList.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        db.dispose();
        return eList;
    }
}
