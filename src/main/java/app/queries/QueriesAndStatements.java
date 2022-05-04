package app.queries;

public enum QueriesAndStatements {

    GetAllEmployees("select * from employees"),GetAllAddress("select * from address"), DeleteEmployeeById("delete from employees where id = ?");

    String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    QueriesAndStatements(String query) {
        this.query = query;
    }
}
