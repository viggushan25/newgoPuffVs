package com.goPuff.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFramExcelSheetTest {

	public static void main(String[] args) throws IOException {
//step1: read the file using File input stream
		FileInputStream fis = new FileInputStream("./src/test/resources/Data/TestData.xlsx");
		// step2:create workbook
		Workbook workbookwb = WorkbookFactory.create(fis);
		// step3:load the sheet
		Sheet sh = workbookwb.getSheet("sheet1");
		// step4:navigate to the row
		Row r = sh.getRow(1);
		// step5:navigate to the cell
		Cell c = r.getCell(1);
		// step6:read the value inside the cell
		System.out.println(c.getStringCellValue());

	}

}
