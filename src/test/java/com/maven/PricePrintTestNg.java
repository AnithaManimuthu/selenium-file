package com.maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PricePrintTestNg {

	
	@Test
	
	public void setup() throws AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		WebElement txtSearch=driver.findElement(By.id("twotabsearchtextbo"));
		txtSearch.sendKeys("iphone");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
		WebElement element=driver.findElement(By.className("a-price-whole"));
		String text=element.getText();
		System.out.println(text);
		
	}
}
