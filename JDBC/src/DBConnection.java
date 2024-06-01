import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "mysql");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }

        return dbConnection;
    }

    public Connection getConnetion(){
        return connection;
    }

}
