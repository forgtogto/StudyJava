package fx_lightSystem.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_house {
	


	public static void dbcheck_in() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("ok");
		}catch(ClassNotFoundException ee) {
			System.err.println("¿¡·¯=:"+ee.getMessage());
			System.exit(0); }
	}
	static void dbcon() {
		String url = "jdbc:mysql://localhost:3306/mytest";
		String sqlid = "root";
		String sqlpass= "qwer";
		String query;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		Connection conn = null;
		
		query = "select * from  login"; 
		  
		  try {
		   conn = DriverManager.getConnection(url, sqlid, sqlpass);
		   stmt = conn.createStatement();
		   rs = stmt.executeQuery(query);
		   
		   while (rs.next())
		   {
			   System.out.println(rs.getString("id")); }
		   	rs.close();
		   	stmt.close();
		   	conn.close();
	  } catch (SQLException ee) {
	   System.err.println("error = " + ee.toString());
	  }
	}
}

	
