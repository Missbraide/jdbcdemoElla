package app;

import java.util.List;

public interface EmployeeDAO {
    enum SQL{
        GetAllEmployees("select * from employees");

        String query;

        public String getQuery() {
            return query;
        }

        SQL(String query) {
            this.query = query;
        }
    }

    List<Employees> GetAllEmployees();


}
