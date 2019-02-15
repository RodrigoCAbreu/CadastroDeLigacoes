package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private Connection con;
	private static ConnectionSingleton instancy;
	private static final String JDBC_URL = "jdbc:postgresql://192.168.0.143:5432/registlig";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASS = "";
	
	
	private ConnectionSingleton() throws GenericDAOException {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDAOException( e );
		}
	} 
	
	public static ConnectionSingleton getInstancy() {
		if (instancy == null) {
			try {
				instancy = new ConnectionSingleton();
			} catch (GenericDAOException e) {
				e.printStackTrace();
			}
		}
		return instancy;	
	}
	 
	public Connection getcon() {
		return this.con;
		
	}
}
