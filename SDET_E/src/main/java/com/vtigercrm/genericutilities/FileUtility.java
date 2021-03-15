package com.vtigercrm.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.commonDataFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	public static void main(String[] args) throws Throwable{
		System.out.println(new FileUtility().getPropertyKeyValue("browser"));
		System.out.println(new FileUtility().getPropertyKeyValue("url"));
		System.out.println(new FileUtility().getPropertyKeyValue("username"));
		System.out.println(new FileUtility().getPropertyKeyValue("password"));
	}

}
