
import java.sql.*;

public class LocalDB {
	
	private static Connection myDB ;
	
	public static Connection getConnection(String username, String password) {
		if (myDB != null) {
			return(myDB);
		}
		
		else {
			try {	
				String url = "jdbc:mysql://localhost/java_project";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				myDB = DriverManager.getConnection(url, username, password);
			} catch (Exception exc) {
				System.out.println(exc);
				
				return(null);
			}
			
			System.out.println("Connected!");
			
			return(myDB);
		}
	}
	
	public static void closeConnection() {
		if (myDB != null) {
			try {
				myDB.close();
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
	}
	
	
}