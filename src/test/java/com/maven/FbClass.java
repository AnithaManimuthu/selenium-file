package com.maven;

import org.openqa.selenium.WebElement;

public class FbClass extends FunctionLib {

	public static void main(String[] args) {
		// creating obj for parent class:
		FunctionLib lib=new FunctionLib();
		lib.getDriver("Chrome");
		
		lib.launchUrl("https://www.facebook.com");
		WebElement txtUserName=lib.findElementByLocator("id","email");
		lib.enterTextByJs("welcome", txtUserName);
		String userName=lib.getAttributeByJs(txtUserName);
		System.out.println(userName);
		

	}

}
