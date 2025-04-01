import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseAccess {
    public  Connection connection;

    public  Connection connectSQL() throws SQLException, ClassNotFoundException {
        String jdbcUrl = "jdbc:sqlserver://10.195.105.247;encrypt=false;trustServerCertificate=true;";
        String userName = "AppDb";
        String password = "rKC61m20";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            connection.createStatement();
            System.out.println("successfully connected!");

            this.connection=connection;
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public Connection getInstance(){
        return this.connection;
    }

}


