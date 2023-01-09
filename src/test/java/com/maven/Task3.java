package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Task3 {
	
	
	// Create excelsheet with details of 10student name & course
	
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\mathan ranjith\\eclipse-workspace\\FrameWork1\\Excel\\newbook.xlsx");
		FileInputStream stream=new FileInputStream(file);
		//create workbook
		
		Workbook book=new XSSFWorkbook(stream);
		
		//get sheet
		
		Sheet sheet = book.createSheet("Students");
		Row createRow = sheet.createRow(1);
		Cell Cell = createRow.createCell(1);
		Cell.setCellValue("name");
		
//	
//		Row createRow1 = sheet.createRow(2);
//		Cell Cell1 = createRow.createCell(1);
//		Cell1.setCellValue("mala");
//		
		
		
		
		FileOutputStream str = new FileOutputStream(file);
		book.write(str);
			
		
	}

}
