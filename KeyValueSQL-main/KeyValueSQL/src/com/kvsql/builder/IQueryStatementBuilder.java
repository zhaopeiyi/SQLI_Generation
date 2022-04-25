package com.kvsql.builder;

public interface IQueryStatementBuilder {

	//For nested queries
	StringBuilder addSub(String column,String val);
	//For where clause
	StringBuilder addFilter(String column,String val);
	//add column
	StringBuilder addColumnFilter(String column,String val);
	
}
