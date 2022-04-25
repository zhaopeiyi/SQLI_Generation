package com.kvsql.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

public class ConnectionHelper {

	private Connection conn = null;
	private String DB_URL,DB_USER,DB_PASS="";	
	private PropertyResourceBundle propertyResourceBundle = null;
	
	public 
	ConnectionHelper(PropertyResourceBundle propertyResourceBundle) {
		this.propertyResourceBundle=propertyResourceBundle;
		
	}
	public
	Connection getConnection() throws SQLException, ClassNotFoundException {
		//Register the driver
		Class.forName(propertyResourceBundle.getString("DB_DRIVER"));
		
		for(String key:propertyResourceBundle.keySet()) {
	    	  if(key.equals("DB_URL"))
	    		  DB_URL =propertyResourceBundle.getString("DB_URL");
	    	  else if(key.equals("DB_USER"))
	    		  DB_USER =propertyResourceBundle.getString("DB_USER");
	    	  else if(key.equals("DB_PASS"))
	    		  DB_PASS =propertyResourceBundle.getString("DB_PASS");
	    	  
	      }
	    	  
	      conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
	      
		return conn;
	}
}
