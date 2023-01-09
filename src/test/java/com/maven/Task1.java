package com.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	WebElement userName = driver.findElement(By.id("username"));
	userName.sendKeys("Anitha");
      WebElement passWord = driver.findElement(By.id("password"));
    passWord.sendKeys("theja@123");
    Thread.sleep(3000);
			
			WebElement btnLogin = driver.findElement(By.id("login"));
			btnLogin.click();
}
}
