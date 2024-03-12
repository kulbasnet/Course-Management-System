package backend;

import java.sql.*;

public class Db {
public static Connection getDBConnection() throws SQLException {
String connectionString = "jdbc:mysql://"+Config.hostName+":"+ Config.dbPort +"/"+ Config.dbName;
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
return DriverManager.getConnection(connectionString, Config.dbUser, Config.dbPass);
}
}