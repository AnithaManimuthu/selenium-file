package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("i phone",Keys.ENTER);
		
		
		List<WebElement> phone=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		
		File file=new File("C:\\Users\\mathan ranjith\\eclipse-workspace\\FrameWork1\\Excel\\Book1.xlsx");
		FileInputStream stream=new FileInputStream(file);
		
		
	Workbook book = new XSSFWorkbook(stream);
	Sheet sheet =  book.createSheet("amazon");
	
	
	for(int i=0;i<phone.size(); i++)  {
		
		WebElement ele=phone.get(i);
		String text = ele.getText();
		
		
		Row createRow = sheet.createRow(i);
		
		Cell createCell=createRow.createCell(0);
		createCell.setCellValue(text);
		
		FileOutputStream str=new FileOutputStream(file);
		book.write(str);
	}}
		
		
		
		
		
		
	
		
		
		


}
