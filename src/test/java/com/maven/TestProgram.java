package com.maven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProgram {

	
	WebDriver driver;
	
	@BeforeClass
	private void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
		
	}
	@Parameters ({"user", "pass"})
	
	@Test()
	private void tc01(String s1,String s2) {
	driver.findElement(By.id("username")).sendKeys(s1);
	driver.findElement(By.id("password")).sendKeys(s2);
	driver.findElement(By.id("login")).click();
	
	}
	@Parameters({"Location","hotels","room_type","room_nos","datepick_in","datepick_out", "adult_room","child_room"})
	
	@Test
	private void tc02(String loc,int htl,String type,int no,String in,String out,int ad,int ch) {
		WebElement location=driver.findElement(By.id("location"));
		Select s=new Select(location);
		s.selectByVisibleText(loc);
		WebElement hotel=driver.findElement(By.id("hotels"));
		Select s1=new Select(hotel);
		s1.selectByIndex(htl);
		WebElement roomType=driver.findElement(By.id("room_type"));
		Select s2=new Select(roomType);
		s2.selectByVisibleText(type);
		WebElement roomNo=driver.findElement(By.id("room_nos"));
		Select s3=new Select(roomNo);
		s3.selectByIndex(no);
		driver.findElement(By.id("datepick_in")).clear();
		WebElement dateIn=driver.findElement(By.id("datepick_in"));
		dateIn.sendKeys(in);
		driver.findElement(By.id("datepick_out")).clear();
		WebElement Checkout=driver.findElement(By.id("datepick_out"));
		Checkout.sendKeys(out);
		WebElement adult=driver.findElement(By.id("adult_room"));
		Select s4=new Select(adult);
		s4.selectByIndex(ad);
		WebElement child=driver.findElement(By.id("child_room"));
		Select s5=new Select(child);
		s5.selectByIndex(ch);
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
	}
	
	@Parameters({"first_name","last_name","address","cc_num","cc_type","cc_exp_mon","cc_exp_year","cc_cvv"})
	@Test
	private void tc03(String firstname,String last,String address,String card,int type,int mon,int yea,String cvv) {
		
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("last_name")).sendKeys(last);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("cc_num")).sendKeys(card);
		WebElement cardtype=driver.findElement(By.id("cc_type"));
		Select s=new Select(cardtype);
		s.selectByIndex(type);
		WebElement month=driver.findElement(By.id("cc_exp_month"));
		Select s1=new Select(month);
		s1.selectByIndex(mon);
		WebElement year=driver.findElement(By.id("cc_exp_year"));
		Select s2=new Select(year);
		s2.selectByIndex(yea);
		driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
		driver.findElement(By.id("book_now")).click();
	}
	@Test
	private void tc04() throws InterruptedException {
		Thread.sleep(3000);
		WebElement order=driver.findElement(By.id("order_no"));
		String orderNo=order.getAttribute("value");
		System.out.println(orderNo);
		driver.quit();
		
	}
	
}
