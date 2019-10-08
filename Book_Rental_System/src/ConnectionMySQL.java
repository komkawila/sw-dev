import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 

public class ConnectionMySQL {
	public static void main( String[] arsg ) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "123456789");
			System.out.println("Connection success..!!!");
			String query = "SELECT * FROM login_table"; // ตารางฐานข้อมูล
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while( rs.next() ){
				
				//System.out.println("Student ID : "+(rs.getString("ID"))+ " Name : "+(rs.getString("Name"))+ " Phone : "+(rs.getString("Phone")));
				System.out.println("Uername: "+rs.getString("username")+ " password: "+rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
