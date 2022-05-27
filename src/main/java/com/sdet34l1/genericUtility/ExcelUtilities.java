package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific common methods
 * @author Priya
 *
 */
public class ExcelUtilities {
static 	Workbook wb;
static FileOutputStream fos;
	public static void OpenExcel(String filepath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis);
		
			
	}
	public static String getDataFromExcel(String SheetName, int rownum, int cellnum)
	{
		String Data=wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return Data;
	}
	public static Object[][] getMultipleDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantPath.EXCELFILEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j] =sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return arr;
		
	}
	/**
	 * This method is used to set data into Excel
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws FileNotFoundException 
	 */
	
	public static void createCellInExcel(String SheetName, int rownum, int cellnum,String value)
	{
		wb.getSheet(SheetName).getRow(rownum).createCell(cellnum).setCellValue(value);
		
	}
	/**
	 * This method is used to save the data
	 * @throws IOException
	 */
	public static void flushDataExcelFileString(String filepath)
	{
		
		try {
			fos = new FileOutputStream(filepath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void closeExcel()

	{
		try {
			wb.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
