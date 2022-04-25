package com.kvsql.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ReadTableConfig {
	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs =null;
	private HashMap<String, String> tableObject=null;
	public 
	ReadTableConfig(Connection conn) {
		this.conn = conn;
		
	}
	
	public 
	HashMap<String, String> read() {
		try {
		stmt=conn.createStatement();
		tableObject=new HashMap<>();
			rs=stmt.executeQuery("SELECT column_name,is_nullable,data_type,character_maximum_length,column_default\n" + 
					"FROM `INFORMATION_SCHEMA`.`COLUMNS` \n" + 
					"WHERE `TABLE_SCHEMA`='test' \n" + 
					"    AND `TABLE_NAME`='students'");
			 while(rs.next()){
		         //Retrieve by column name
		         String column_name  = rs.getString(1);
		         String is_nullable = rs.getString(2);
		         String data_type = rs.getString(3);
		         String character_maximum_length = rs.getString(4);
		         String column_default = rs.getString(5);
		         //populate HashMap
		         
		         tableObject.put(column_name, "?");
		         //Display values
		         System.out.print("column_name: " + column_name);
		         System.out.print(", is_nullable: " + is_nullable);
		         System.out.print(", data_type: " + data_type);
		         System.out.print(", character_maximum_length: " + character_maximum_length);
		         System.out.print(", column_default: " + column_default);
		         System.out.println();
		         
			 }
			 //Cleanup 
	         
	         rs.close();
		     stmt.close();
		     conn.close();
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableObject; 
	}
}
