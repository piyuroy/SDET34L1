package com.vtiger.practiceTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_DD_HH_MM_SSS");
		String date1 =  sdf.format(date);
		System.out.println(date1);
	

	}

}
