package cse.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBControlModule {
	/*Class which handles connection to database and interact with the database with database*/
	
	//variables relating to database setup
	private static String dbName = "courseManagement";
	private static String jdbcURL = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "root";
    
    private static final String SELECT_USER_BY_ID = "select id,username,password,type from users where id =?";
    private static final String SELECT_USER_BY_USERNAME_PASSWORD = "select id,username,password,type from users where username =? and password = ?";
	
	public static Connection getDbConnection() {
		//create an new instance of connection
		Connection dbConnection=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return dbConnection;
	}
	
	public static User getUser(String username, String password) {
        User user = null;
        //Establishing a Connection
        try (Connection connection = getDbConnection();
            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            //Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                user = new User(id, username, password, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
