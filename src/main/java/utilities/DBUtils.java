package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class DBUtils {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public static void connectToDB() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=yourDatabaseName";
			String username = "yourUsername";
			String password = "yourPassword";

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to Database Successfully!");
		} catch (Exception e) {
			System.out.println("Database connection failed: " + e.getMessage());
		}
	}

	public static ResultSet executeQuery(String query) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			System.out.println("Query execution failed: " + e.getMessage());
		}
		return resultSet;
	}

	public static void closeConnection() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
			System.out.println("Database Connection Closed.");
		} catch (Exception e) {
			System.out.println("Failed to close database connection: " + e.getMessage());
		}
	}
}
/*
 * static Connection conn; static Statement stmt; static ResultSet rs;
 * 
 * @Test public static void connectToDB() throws SQLException { conn =
 * DriverManager.getConnection(
 * "jdbc:sqlserver://<server-ip>:1433;databaseName=yourDB;encrypt=true;trustServerCertificate=true\r\n",
 * "UserName", "Password"); stmt = conn.createStatement(); rs =
 * stmt.executeQuery("Select * from Inquiry where InquiryID = 21"); String
 * enqfrom = rs.getString("InquiryFrom"); String email = rs.getString("Email");
 * System.out.println(enqfrom); System.out.println(email); }
 */
