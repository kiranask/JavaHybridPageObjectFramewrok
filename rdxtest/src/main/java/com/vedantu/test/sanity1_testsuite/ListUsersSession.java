// Not In The Master 

package com.vedantu.test.sanity1_testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vedantu.test.pom.AdminHomePage;
import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.LoginPage;
import com.vedantu.test.pom.Retry;

public class ListUsersSession extends Login

{
@Test(retryAnalyzer=Retry.class)
public void ListUserSchedule() throws InterruptedException 
	
	{
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginClick();
		loginpage.loginCredentials("kiransk@vedantu.in","vedantu123");
		loginpage.logClick();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Register User')]")).isDisplayed());
		Reporter.log("Administrator Login is Successful", true);
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//a[contains(text(),'List Users')]")).click();
		driver.findElement(By.linkText("List Users")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-keyup='onQuerySubmit($event)']")).sendKeys("qa-student@gmx.com");
		Thread.sleep(2000);
		Reporter.log("Selcted The Student", true);
		
		driver.findElement(By.xpath("//input[@ng-keyup='onQuerySubmit($event)']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[1]")).sendKeys("qa-teacher@gmx.com");
		Thread.sleep(1000);
		Reporter.log("Selcted The Teacher", true);

		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[1]")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[1]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[1]")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[2]")).clear();
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/input[2]")).sendKeys("1");
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("( //button[contains(text(), 'Book Demo')])[1]")).click();
		Thread.sleep(3000);
		
	
		AdminHomePage adminBasePage = new AdminHomePage(driver);
	
		
	
		try 
		{
			driver.findElement(By.xpath("//button[contains(text(), 'Schedule')]")).click();
		} catch (Exception e)
		{
			System.out.println("Inside Catch");
			Thread.sleep(3000	);
			driver.navigate().refresh();
			adminBasePage.logOutClick();
			Thread.sleep(3000);
			
			ListUserSchedule();
			
	
		}
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(), 'Okay')]")).click();
		
		Reporter.log("Session Scheduled", true);
		Reporter.log("Test Pass : Session Schedule", true);
		Thread.sleep(1000);
		

}

}