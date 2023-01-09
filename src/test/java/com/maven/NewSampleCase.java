package com.maven;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewSampleCase {
	WebDriver driver;
	@Test
	private void tc01 () {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.Amazon.com");
	}
	@Test
	private void tc02() {
		WebElement txtSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		txtSearchBox.sendKeys("iphone",Keys.ENTER);
		
	}
	@Test
	private void tc03 () {
		WebElement btnClick=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
		btnClick.click();
		
	}
	@Test
	private void tc04() {
		String prtWin=driver.getWindowHandle();
		Set<String> allWin=driver.getWindowHandles();
		
		for(String win:allWin) {
			if(!(prtWin.equals(win))) {
				
				driver.switchTo().window(win);
				
				
				
			}
		}
		driver.findElement(By.id("add-to-cart-button")).click();
	
	}

}
