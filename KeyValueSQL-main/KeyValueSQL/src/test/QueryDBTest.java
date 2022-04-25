package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PropertyResourceBundle;

import com.kvsql.builder.SelectQueryBuilder;
import com.kvsql.helper.ConnectionHelper;
import com.kvsql.helper.ReadProperties;
import com.kvsql.helper.ReadTableConfig;
import com.kvsql.query.QueryDB;


public class QueryDBTest {
	
	public static void main(String[] args) {
		File file = new File("config.properties");
		HashMap<String, String> tableObject=null;
		ReadProperties readProperties = new ReadProperties();
		FileInputStream fileInputStream= readProperties.getFileInputStream(file);
		PropertyResourceBundle propertyResourceBundle = readProperties.getPropertyResourceBundle(fileInputStream);
		
		ConnectionHelper connectionHelper = new ConnectionHelper(propertyResourceBundle);
		Connection conn = null;
		Connection queryConn = null;
		Statement stmt = null ;
		try {
			conn = connectionHelper.getConnection();
			queryConn =connectionHelper.getConnection();
			stmt = conn.createStatement();
		ReadTableConfig readTableConfig = new ReadTableConfig(conn);
		tableObject=readTableConfig.read();
		tableObject.put("PersonID", "123456;drop table emp;");//Test SQL Injection
		tableObject.put("City", "Boston");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SelectQueryBuilder selectQueryBuilder = new SelectQueryBuilder("Signon",tableObject);
		String sql = selectQueryBuilder.makeQuery();
		//System.out.println(sql);
		
		QueryDB queryDB = new QueryDB(stmt, queryConn, sql);
		ArrayList<ArrayList<String>> voResult= queryDB.executeQuery();
		
		for(ArrayList<String> aList: voResult)
			System.out.println(aList.toString());
		
	}

}
