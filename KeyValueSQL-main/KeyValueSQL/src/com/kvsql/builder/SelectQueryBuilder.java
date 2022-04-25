package com.kvsql.builder;

import java.util.HashMap;
import java.util.Map;

public class SelectQueryBuilder {

	private HashMap<String, String> tableObject=null;
	private static String sql = "SELECT * FROM ";
	private static int filterCount=0;
	private String newFilter="";
	
	public SelectQueryBuilder(String tableName,HashMap<String, String> tableObject) {
		sql+=tableName;
		this.tableObject=tableObject;
	}
	public
	String makeQuery() {
		/**Loop through each key column(HashMap) to make the query
		 * if there is '?' that means the column is not needed in 
		 * the where clause
		 */
		for(Map.Entry<String, String> mapObj: tableObject.entrySet()) {
			if (filterCount==0)
				newFilter = " where "+mapObj.getKey()+"='";
			else if (filterCount>0) 
				newFilter = " and "+mapObj.getKey()+"='";
			
			sql+=newFilter;
			
			if(mapObj.getValue().equals("?"))
				sql=sql.replaceAll(newFilter, "");
			else {
				filterCount++;
				
				//Don't use hashCode .Use MD5 checksum (SHA1) instead
				sql+=mapObj.getKey().hashCode()+"'";
				sql=sql.replace(mapObj.getKey().hashCode()+"", mapObj.getValue());
			}
				
			
		}
		
		return sql;
	}
}
