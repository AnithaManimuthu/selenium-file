 package com.maven;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;

import java.util.Date;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test4 {
	
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		
	}
	@Before
	public void Before() {
	Date date =new Date();
	System.out.println(date);
		}
	
	@Test 
	
	public void tc01() {
		WebElement  txtUserName=driver.findElement(By.id("email"));
		
		txtUserName.sendKeys("Welcome Java");
		
		Assert.assertEquals(txtUserName.getAttribute("value"), "Welcome Java");
		
		WebElement txtPass=driver.findElement(By.id("pass"));
		
		txtPass.sendKeys("ANITHA");
		
		Assert.assertEquals(txtPass.getAttribute("value"), "ANITHA");
		
	}
	
	
	
	@After
	public void After() {
		Date date=new Date();
		System.out.println(date);
	}
	
	

}
