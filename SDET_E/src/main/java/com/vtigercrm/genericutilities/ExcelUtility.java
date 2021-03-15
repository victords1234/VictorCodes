package com.vtigercrm.genericutilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility  {
	public String ReadDataFromExcel(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.excelDataFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public String getDataFromExcel(String sheet, String Test_Case_ID, String expHeader) throws Throwable
	{
		int expectedRowNum = 0;
		int expectedCellNum = 0;
		FileInputStream fis=new FileInputStream(IConstants.excelDataFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);

		//Traverse to row
		int rowcount = sh.getLastRowNum();
		for(int i=0;i<rowcount+1;i++)
		{
			String Actual_TC_ID = sh.getRow(i).getCell(0).getStringCellValue();
			if(Actual_TC_ID.equals(Test_Case_ID))
			{
				expectedRowNum=i;
				break;
			}
		}

		//traverse in column
		int lastCellNum=sh.getRow(expectedRowNum).getLastCellNum();
		for(int j=0;j<lastCellNum;j++)
		{
			String actualheader = sh.getRow(expectedRowNum-1).getCell(j).getStringCellValue();
			if(actualheader.equals(expHeader))
			{
				expectedCellNum=j;
				break;
			}
		}
		return sh.getRow(expectedRowNum).getCell(expectedCellNum).getStringCellValue();
	}
	public static void main(String[] args) throws Throwable
	{
		String org = new ExcelUtility().getDataFromExcel("Sheet1","TC_02","Org_Name");
		String con = new ExcelUtility().getDataFromExcel("Sheet1","TC_02","Con_Name");
		System.out.println(org);
		System.out.println(con);
		String readdate = new ExcelUtility().ReadDataFromExcel("Sheet1", 1, 2);
		System.out.println(readdate);
	}
}
