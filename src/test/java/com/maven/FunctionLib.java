package com.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionLib {
	
	//getDriver()---->Used to launch browser
	
	
	public static WebDriver driver;
	public JavascriptExecutor js;
	
	
	
	public void getDriver(String name)  {
		
		switch(name) {
		
		
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
			
		case "edge": 
			
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
			default:
				
				System.out.println("INVALID BROWSER NAME");
		break;			
	
		
		}
		
		 //maximize
	
	driver.manage().window().maximize();
	
	}
	
	//URL LAUNCH
	public void  launchUrl(String url) {
		driver.get(url);
		
	}
	
	
	//LOCATORS
	
	public WebElement findElementByLocator(String locator, String value) {
		
		
		WebElement ele=null;
		
		switch(locator) {
		
		case "id":
		
		ele=driver.findElement(By.id(value));
		
		break;
		
		case "name":
			ele=driver.findElement(By.xpath(value));
			break;
			
		case "xpath":
			ele=driver.findElement(By.xpath(value));
			break;
			
			
			default:
				System.out.println("Invalid Locator");
				
				break;
		
	
		}
		return ele;
	}
//typeText()  method for sendkeys:
	
	public void typeText(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	
	public void enterTextByJs(String data,WebElement element) {
		
		js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('value','"+data+"')",element);
				
	}
	public String getAttributeByJs(WebElement element) {
		
		String string = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
		
		return string;
				
		
		
		
		
	}
}
