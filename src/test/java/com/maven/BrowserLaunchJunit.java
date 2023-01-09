package com.maven;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BrowserLaunchJunit {

	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com/");
		
	}
	@Test

	public void sample() {

		
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("Ani@1234");
		Assert.assertEquals(txtUserName.getAttribute("value"), "Ani@1234");
		System.out.println(txtUserName);
		
		WebElement txtPassWord = driver.findElement(By.id("pass"));
		txtPassWord.sendKeys("sample@123");
		System.out.println(txtPassWord);
		
		Assert.assertEquals(txtPassWord.getAttribute("value"), "sample@123");
	}
}

