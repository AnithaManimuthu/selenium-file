package com.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriverTask5Adactin {
	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		
		WebElement txtUserNmae = driver.findElement(By.id("username"));
		txtUserNmae.sendKeys("AnithaManimuthu");
		WebElement txtPassWord = driver.findElement(By.id("password"));
		txtPassWord.sendKeys("1QBIWD");
		 WebElement btnLogin = driver.findElement(By.id("login"));
		 btnLogin.click();
		 
		 File file=new File("C:\\Users\\mathan ranjith\\eclipse-workspace\\FrameWork1\\Excel\\Adactinpage.xlsx");
			
			
			FileInputStream stream=new FileInputStream(file);
			
			Workbook book=new XSSFWorkbook(stream);
			
			Sheet sheet=book.getSheet("Adactin");
			
			
	}}
