package com.vtiger.practiceTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class FetchMultipleData {
	@Test
	
	public static void loginData() throws EncryptedDocumentException, IOException
	{
		int i;
		int j;
		FileInputStream fis = new FileInputStream("./src/test/resources/TestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("loginData");
		String[][] arr = new String[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for( i =0;i<sh.getLastRowNum();i++)
		{
			for( j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print( arr[i][j]);
			}
			System.out.println("");
		}
		
	}

}
