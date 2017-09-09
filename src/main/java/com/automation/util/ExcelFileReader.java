package com.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;	
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileReader {

	String xlFilePath = "C:\\Training\\autoproject\\properties\\TestData.xlsx";
	String sheetName = "TestData";
	
	XSSFSheet sheet;
	@Test
	public void locateAndOpenExcelFile() throws IOException {
		
		File xlFile = new File(xlFilePath);
		FileInputStream fis = new FileInputStream(xlFile);	
		
		//get workbook
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//get sheet
		sheet = workbook.getSheet(sheetName);
	
	}
	
	@Test
	public Object[][] getTestData() {
		
		int lastRowNumber = sheet.getLastRowNum() + 1;
		
		//get row
		XSSFRow firstRow = sheet.getRow(0);
		int columnsCount = firstRow.getPhysicalNumberOfCells();
		
		Object[][] testDataObject = new Object[lastRowNumber][columnsCount];
		
		
		//get cell object
		//get cell value
		//store the cell value in array(testData)
		
		//row for loop
		for(int i = 0;i < lastRowNumber;i++) {
			XSSFRow row = sheet.getRow(i);
			
			//column for loop
			for(int j = 0;j < columnsCount;j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println("Value at row " + i + " and column " + j + ":" + value);
				testDataObject[i][j] = value;
			}
		}
		
		return testDataObject;
	}
	@Test
	public void ExecuteTest() throws IOException {
		locateAndOpenExcelFile();
		getTestData();
		
	}
}
