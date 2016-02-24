package com.vedantu.test.pom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Login  
{
	public WebDriver driver;

		@BeforeMethod
		public void preCondition()
		{
			//System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		//driver=new HtmlUnitDriver();
		driver = new FirefoxDriver();

		//driver = new ChromeDriver();
	
		//String url = Excel.getCellValue(xlPath, Sheet, 1, 1);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://fos-qa.vedantu.com");
		
		
		}
		@AfterMethod
		public void postCondition()
		{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.quit();
		}
}



/*package com.vedantu.test.base_url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.vedantu.test.zlib.Excel;

public class Login  
{
		public WebDriver driver;
		
		@BeforeMethod
		public void preCondition() throws MalformedURLException
		{
			
		//driver=new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "./exe/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		String xlPath = "./excel/BaseURL.xlsx";
		String Sheet = "Sheet1";
		String url = Excel.getCellValue(xlPath, Sheet, 1, 1);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);             
			
			URL hubURL = new URL("http://192.168.0.243:4444/wd/hub");
			DesiredCapabilities settings = new DesiredCapabilities();
			settings.setBrowserName("firefox");
			settings.setPlatform(Platform.LINUX);
			
			
			 RemoteWebDriver driver=new RemoteWebDriver(hubURL, settings);
			 
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			// driver.navigate().to("http://gmail.com");
		}
		@AfterMethod
		public void postCondition()
		{
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		//driver.quit();
		}
}*/