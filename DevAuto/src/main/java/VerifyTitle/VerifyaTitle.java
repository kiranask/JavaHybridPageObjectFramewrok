
package VerifyTitle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyaTitle 
{

ExtentReports report;
ExtentTest logger;



@Test
public void VedantuTitle()
{	
report = new ExtentReports("D:\\Testing\\Learn.html");
logger =report.startTest("TestVerifyTitle");
WebDriver driver =new FirefoxDriver();
logger.log(LogStatus.INFO, "Browser Started");
driver.get("http://fos-qa.vedantu.com");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String title1 = driver.getTitle();


Assert.assertTrue(title1.contains("Online"));
logger.log(LogStatus.PASS, "Application has Started and Running");

}
}