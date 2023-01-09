package com.maven;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demoqa {
	
	@Test
	public void tc01() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://demoqa.com/automation-practice-form");
		List<WebElement> frameCount= driver.findElements(By.tagName("iframe"));
		WebElement findElement = driver.findElement(By.xpath("//iframe[@id='google_esf']"));
		driver.switchTo().frame(findElement);
		
		
		WebElement btnForms = driver.findElement(By.id("//div[@class='header-wrapper'] [1]"));
		btnForms.click();
		
		WebElement btnPracticeForm = driver.findElement(By.id("//span[@class='text'][1]"));
		btnPracticeForm.click();
		
		WebElement txtUserName = driver.findElement(By.id("firstName"));
		txtUserName.sendKeys("Anitha");
		Assert.assertEquals(txtUserName.getAttribute("value"), "Anitha");
	}
}
