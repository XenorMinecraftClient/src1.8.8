package xenor.http;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	
	public static String host = "185.117.3.163";
	public static String port = "3306";
	public static String database = "xenor";
	public static String username = "xenor";
	public static String password = "LOZ])mbVpb8KA*[[";
	public static Connection con;
	
	public static void connect() {
		if(!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("Server Connection sucessful");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect() {
		if(isConnected()) {
			try {
				con.close();
				System.out.println("Server Connection disconnected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	}

	public static Connection getConnection() {
		return con;
	}
	
	public static ResultSet getResult(String qry) {
		if(isConnected()) {
			try {
				return con.createStatement().executeQuery(qry);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
