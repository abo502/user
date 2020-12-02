package DBUtil;

import java.sql.*;

public class Db {
    private static String DBDriver = "com.mysql.cj.jdbc.Driver";
    private static String User = "root";
    private static String Password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    static Connection connection = null;
    static Statement statement=null;


    public static Connection getConnection(){
        try {
            Class.forName(DBDriver);
            connection=DriverManager.getConnection(URL,User,Password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Statement createStatement(){
        try {
            statement=getConnection().createStatement();
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
