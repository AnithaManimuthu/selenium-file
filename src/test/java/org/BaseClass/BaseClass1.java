package org.BaseClass;



	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass1 {
		public static WebDriver driver;
		public static JavascriptExecutor js;
		
		

		// 1.launch browser
		public void getDriver(String name) {
			switch (name) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("invalid browser name");
				break;
			}
			// 2.maximaze the browser
			driver.manage().window().maximize();
		}

		// 3.launch url
		public void launchUrl(String url) {
			driver.get(url);

		}

		// 4.locators
		public WebElement findElementByLocator(String locator, String value) {
			WebElement element = null;
			switch (locator) {
			case "id":
				element=driver.findElement(By.id(value));
				break;
			case "name":
				element=driver.findElement(By.name(value));
				break;
			case "xpath":
				element=driver.findElement(By.xpath(value));
				break;

			}
			return element;

		}

		// 5.sendKeys
		public void sendkey(WebElement element, String passvalue) {
			element.sendKeys(passvalue);
		}

		
			
		// 7.close
		public void close(WebDriver driver) {
			driver.close();
	        
		}
		// 8.quite
		public void quit(WebDriver driver) {
			driver.quit();

		}
		
		// click all option
		public void clickAllOption(String value,WebElement element) {
			
			Actions a = new Actions(driver);
			if(value == "singleClick") {
			a.click(element).perform();
			}else if(value == "rightClick") {
				a.contextClick(element).perform();
			}else if (value == "doubleClick") {
				a.doubleClick(element).perform();
			}else if(value == "mousehover") {
				a.moveToElement(element).perform();
			}
		
			
		}
		
		// Select by index
		public void selectOptionByIndex(WebElement element,int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
			 
			
		}
		
		// Select by value
		public void selectOptionByValue(WebElement element,String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}
		
		// Select by visible text
		public void selectOptionByVisibleText(WebElement element,String text) {
			
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}

		// javascriptExecutor = (setAttribute) supose sendkeys is not work we use javascriptexecutor
		public void sendkeyJs(String data, WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

		}

		// javascriptExecutor = (getAttribute)
		public String getAttributeByJs(WebElement element) {
			String string = (String) js.executeScript("return argumrnts[0].getAttribute('value')", element);
			return string;
		}

		// getting data from excel sheet
		public String getdataFromExcel(String sheetName, int rownum, int cellnum) throws IOException {
			FileInputStream stream = null;
			Workbook book = null;

			// path of the excel
			File file = new File("D:\\Selenium_\\FrameWork\\Excel\\ExcelData.xlsx");
			// get object from file
			try {
				stream = new FileInputStream(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// create workbook
			try {

				book = new XSSFWorkbook(stream);

			} catch (IOException e) {
				e.printStackTrace();
			}
			// create sheet
			Sheet sheet = book.getSheet(sheetName);
			// create row
			Row row = sheet.getRow(rownum);
			// create cell
			Cell cell = row.getCell(cellnum);
			// create celltype
			CellType cellType = cell.getCellType();
			// USE AS STORE
			String data = " ";

			switch (cellType) {
			case STRING:
				data = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date ss = cell.getDateCellValue();
					SimpleDateFormat format = new SimpleDateFormat("DD-MMM-YYYY");
					data = format.format(ss);

				} else {
					double numericCellValue = cell.getNumericCellValue();// example decimal
					long round = Math.round(numericCellValue); // example mobile
					if (round == numericCellValue) {
						data = String.valueOf(round);
					} else {
						data = String.valueOf(numericCellValue);
					}
				}
				break;

			default:
				System.out.println("invalid data from excel ");
				break;
			}
			return data;

		}

		// create sheet in excel
		public void createSheetInExcel(String sheetName, int rownum, int cellnum, String data) {
			FileInputStream stream = null;
			Workbook book = null;
			// path of excel
			File file = new File("D:\\Selenium_\\FrameWork\\Excel\\ExcelData.xlsx");
			// get object from file
			try {
				stream = new FileInputStream(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// create workbook
			try {
				book = new XSSFWorkbook(stream);

			} catch (IOException e) {
				e.printStackTrace();
			}
			// create sheet
			Sheet sheet = book.getSheet(sheetName);
			// create row
			Row row = sheet.getRow(rownum);
			// create cell
			Cell cell = row.getCell(cellnum);
			cell.setCellValue(data);
			// fileoutputstream
			FileOutputStream stream1 = null;
			try {
				stream1 = new FileOutputStream(file);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book.write(stream1);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}


