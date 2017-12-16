package com.selenium.tests;

import org.testng.annotations.Test;

import com.selenium.setup.ExcelUtils;

public class xSetData extends ExcelUtils{
  @Test
  public void f() throws Exception {
	  ExcelUtils.setExcelFile();
	  System.out.println(ExcelUtils.getCellData(0, 0));
	  ExcelUtils.setCellData("Passed", 1, 7);
	  System.out.println(ExcelUtils.getCellData(1, 7));
	  
  }
}
