// Not In The Master 

package com.vedantu.test.sanity1_testsuite;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vedantu.test.pom.AdminHomePage;
import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.LoginPage;
import com.vedantu.test.pom.Retry;
import com.vedantu.test.pom.ScheduleSessionPage;

public class AdminScheduleASession 	extends Login

{
@Test(retryAnalyzer=Retry.class)
public void AdminSessionSchedule	() throws InterruptedException 
	
	{
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginClick();
		loginpage.loginCredentials("kiransk@vedantu.in","vedantu123");
		loginpage.logClick();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Register User')]")).isDisplayed());
		Reporter.log("Admin Login is Succesful as ");
		AdminHomePage adminBasePage = new AdminHomePage(driver);
		adminBasePage.scheduleSessionClick();
		
		
			
		try
		{
			
		
		Thread.sleep(3000);
		ScheduleSessionPage scheduleSessionPage = new ScheduleSessionPage(driver);
		scheduleSessionPage.studentNameEnter("qa-student@gmx.com");
		Thread.sleep(1000);
		
		driver.findElement(By.name("student")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		driver.findElement(By.name("student")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.name("student")).click();
		driver.findElement(By.name("student")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);	
		scheduleSessionPage.teacherNameDataEnter("qa-teacher@gmx.com");
		Thread.sleep(1000);
		

		driver.findElement(By.name("teacher")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		
		driver.findElement(By.name("teacher")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		
		driver.findElement(By.name("teacher")).click();
		driver.findElement(By.name("teacher")).sendKeys(Keys.ENTER);
		
		scheduleSessionPage.descriptionDataEnter("Data ");
		scheduleSessionPage.titleDataEnter("Title");
		scheduleSessionPage.topicDataEnter("data Entered");
		
		WebElement selectHandler = driver.findElement(By.name("subject"));
		// Select The Subject 
		// 1--> Physics
		// 2--> Chemistry ;;
		Select select1 = new Select(selectHandler);
		select1.selectByIndex(1);
		WebElement selectHandler1 = driver.findElement(By.name("type"));
		Select select2 = new Select(selectHandler1);
		
		select2.selectByVisibleText("FREE");
		// Select the Type 
		Thread.sleep(1000);
		driver.findElement(By.name("startTime")).clear();
		Thread.sleep(1000);
		
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		 Date now = new Date(System.currentTimeMillis()+2*60*1000);
		 String Timestamp = sdfDate.format(now);
		 System.out.println(Timestamp);
		 scheduleSessionPage.startTimeData(Timestamp);
		
		Thread.sleep(1000);
		driver.findElement(By.name("startTime")).sendKeys(Keys.ENTER);
		//scheduleSessionPage.endTimeData("2015-09-15T18:52:00.000");
	
		//driver.findElement(By.name("endTime")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		
		driver.findElement(By.name("endTime")).click();
		driver.findElement(By.name("endTime")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		scheduleSessionPage.submitClick();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Schedule')]")).click();
		
		loginpage.getscreenshot();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Okay')]")).click();
		
		Thread.sleep(2000);
		adminBasePage.logOutClick();
		
		Thread.sleep(3000);}
		
	
		
		catch (Exception e)
		{
			LoginPage login = new LoginPage(driver);
			login.getscreenshot();
		}
		
		
}
}