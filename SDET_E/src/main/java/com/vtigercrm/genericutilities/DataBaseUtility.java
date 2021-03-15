package com.vtigercrm.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	ResultSet result=null;
	public void connectToDB()
	{
		Driver driverRef;
		try {
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/victor", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeDB() 
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet executeQuery(String Query) throws Throwable
	{

		try {
			con.createStatement().executeQuery(Query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally
		{
		}
		return result;
	}
	public String executeQureyAndGetData(String query, int columnIndex, String expectedData) throws Throwable
	{
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnIndex).contains(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData + "===> data verified in data base table");
			return expectedData;
		}else {
			System.out.println(columnIndex + "===> data not verified in data base table");
			return expectedData;
		}
		
	}

}