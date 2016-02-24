package com.vedantu.test.pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Login {

	public WebDriver driver;

	@BeforeMethod
	public void preCondition() {
		// System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");
		// driver=new HtmlUnitDriver();

		driver = new FirefoxDriver();

		// driver = new ChromeDriver();
		String xlPath = "./excel/PRODMasterLibrary.xlsx";
		String Sheet = "Sheet1";
		String url = Excel.getCellValue(xlPath, Sheet, 1, 1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterMethod
	public void postCondition() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
}
