package com.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewSample2 {
	WebDriver driver;
	
 @Parameters ("browser")
 @Test
 private void tc01(String s) {
	// if(s.equals("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 
	// }
	// else if(s.equals("edge")) {
		//// WebDriverManager.edgedriver().setup();
		// driver=new EdgeDriver();
		 
	// }
	 driver.manage().window().maximize();
	 driver.get("https://www.facebook.com");
	 
 }
 @Test
 private void tc02() {
	 driver.findElement(By.id("email")).sendKeys("welcome");
	 driver.findElement(By.id("pass")).sendKeys("java@1234");
	 driver.findElement(By.id("login")).click();
	 
 }
 
	
	
	

}
