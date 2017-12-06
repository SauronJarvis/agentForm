package com.selenium.setup;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static FileInputStream excelFile;
	private static String filepath;
	
	public static void setExcelFile() throws Exception {
	try{
	String workingDir = System.getProperty("user.dir");
	System.out.println("working Dir" + workingDir);
	filepath =workingDir+"/src/test/resources/agent_registration.xlsx";
	//filepath="D:\\368833\\Spectrum Automation\\Project_Ref\\agentForm\\src\\test\\resources\\agent_registration.xlsx";
	excelFile = new FileInputStream(filepath);
	ExcelWBook = new XSSFWorkbook(excelFile);
	ExcelWSheet = ExcelWBook.getSheet("agent");
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
	Row= ExcelWSheet.getRow(RowNum);
	String out = null;
	DataFormatter format=new DataFormatter();
	out=format.formatCellValue(Row.getCell(ColNum));
	return out;
	}
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception
	{
	Row = ExcelWSheet.getRow(RowNum);
	Cell = Row.createCell(ColNum);
	Cell.setCellValue(Result);
	excelFile.close();
	FileOutputStream outputFile=new FileOutputStream(filepath);
	ExcelWBook.write(outputFile);
	outputFile.close();
	}

	
}
