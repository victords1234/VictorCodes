package com.vtigercrm.genericutilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int generateRandomNum()
	{
		Random ran=new Random();
		int r = ran.nextInt(1000);
		return r;
	}
	public String getDateandTime()
	{
		Date d=new Date();
		return d.toString().replace(" ","_");
	}
	public static void main(String[] args) {
		System.out.println(new JavaUtility().generateRandomNum());
		System.out.println(new JavaUtility().getDateandTime());
	}

}
