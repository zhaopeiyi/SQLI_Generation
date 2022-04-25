package com.kvsql.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;

public class ReadProperties {
	private PropertyResourceBundle propertyResourceBundle = null;
	private FileInputStream fileInputStream = null;
	
	public 
	PropertyResourceBundle getPropertyResourceBundle(FileInputStream fis) {
		
		try {
			propertyResourceBundle = new PropertyResourceBundle(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyResourceBundle;
	}
	
	public 
	FileInputStream getFileInputStream(File file) {
		try {
			fileInputStream= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileInputStream;
	}
	
}
