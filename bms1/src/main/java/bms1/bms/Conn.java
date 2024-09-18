package bms1.bms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
  
	
	Statement s;
	public Conn() {
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms1","root","root");
			 s=c.createStatement();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
