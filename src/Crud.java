import java.sql.*;

public class Crud {
	public static void savePassword(String account_name,String account_pass) {
		
		String insertQuery = "INSERT INTO passwords (account_name,account_pass) VALUES (?, ?);";
		
		try {
			Connection myDB = LocalDB.getConnection("root",null);
			PreparedStatement ps = myDB.prepareStatement(insertQuery);
			
			ps.setString(1, account_name);
			ps.setString(2, account_pass);
			
			
			ps.executeUpdate();
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}
	
	public static Object getPassword(String account_name) {
		
		String getQuery = "SELECT account_pass FROM passwords WHERE account_name = '" + account_name + "'";
		String x="";
		
		try {
			Connection myDB = LocalDB.getConnection("root", null);
			PreparedStatement ps = myDB.prepareStatement(getQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			   x = rs.getString("account_pass");
			}
		
		} catch (Exception exc) {
			System.out.println(exc);
			x=null;
		}
		
		return x;
	}
	
	public static void clearPassword(String account_name) {
		
		String clearQuery = "DELETE FROM passwords WHERE account_name = '" + account_name + "'";

		try {
			Connection myDB = LocalDB.getConnection("root", null);
			PreparedStatement ps = myDB.prepareStatement(clearQuery);
			
			ps.executeUpdate();
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}
}
