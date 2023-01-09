package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowsAndCellExcelSheet {
	
	public static void main(String[] args) throws IOException {
		
		
		File file=new File("C:\\Users\\mathan ranjith\\eclipse-workspace\\FrameWork1\\Excel\\data.xlsx");
		
		
		FileInputStream stream=new FileInputStream(file);
		
		Workbook book=new XSSFWorkbook(stream);
		
		Sheet sheet=book.getSheet("Sheet1");
		//Find the Total number of Rows
		
	
		
		//int Numofrows=sheet.getPhysicalNumberOfRows();
		//System.out.println(Numofrows);
		
		//Row row=sheet.getRow(1);
		
		//int PhysicalNumberOfCells=row.getPhysicalNumberOfCells();
		//System.out.println(PhysicalNumberOfCells);
		
		//print all the data present in excel 
		
		for (int i=0; i<sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row=sheet.getRow(i);
			
			
			
			for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell=row.getCell(j);
				System.out.println(cell);
			}
		}
		
		}
}