package com.kvsql.query;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryDB {

	private Statement stmt=null;	
	private Connection conn = null;
	private String sql;
	
	
	public QueryDB(Statement stmt, Connection conn, String sql) {
		this.stmt=stmt;
		this.conn=conn;
		this.sql=sql;
	}
	
	public ArrayList<ArrayList<String>> executeQuery() {
		 
		ArrayList<ArrayList<String>> voResult= new ArrayList<>();
		   try{
		     
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		     
		      
		      ResultSet rs = stmt.executeQuery(sql);
		      System.out.println("Execute query "+sql);
		      
		      while(rs.next()){
		    	 ArrayList<String> row = new ArrayList<>();
		         //Retrieve by column name
		         String id  = rs.getString(1);
		         row.add(id);
		         String lastName = rs.getString(2);
		         row.add(lastName);
		         String firstName = rs.getString(3);
		         row.add(firstName);
		         String email = rs.getString(4);
		         row.add(email);
		         String city = rs.getString(5);
		         row.add(city);

		         
		         //Display values
		         /*System.out.print("ID: " + id);
		         System.out.print(", LastName: " + lastName);
		         System.out.print(", firstName: " + firstName);
		         System.out.print(", email: " + email);
		         System.out.print(", city: " + city);*/
		         
		         //return the value as ArrayList<HashMap<String,String>> (Must be costly)
		         //or simply ArrayList<ArrayList<String>> and retrieve by key
		         
		         voResult.add(row);
		         
		      }

		      rs.close();
		      stmt.close();
		      conn.close();
		      
		   }catch(SQLException se){
		      se.printStackTrace();
		      
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   
		   return voResult;
	}
}
