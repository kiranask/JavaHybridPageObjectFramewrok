package com.vedantu.test.sanity1_testsuite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.vedantu.test.pom.Excel;
import com.vedantu.test.pom.LoginPage;
import com.vedantu.test.pom.Retry;


public class TakeSession

{
	WebDriver driver1;
	WebDriver driver2;

	@Test(retryAnalyzer=Retry.class)
	public void TakingSession() throws Exception {
		{ 
			String xlPath = "./excel/PRODMasterLibrary.xlsx";
			String Sheet = "Sheet8";
		/*	String studentName = Excel.getCellValue(xlPath, Sheet, 1, 1);
		
			String studentPassword = Excel.getCellValue(xlPath, Sheet, 2, 1);
			String teacherName = Excel.getCellValue(xlPath, Sheet, 3, 1);
			
			String teacherPassword = Excel.getCellValue(xlPath, Sheet, 4, 1);*/
			String studentName ="test.automation.student@gmail.com";
			
			String studentPassword = "vedantu123";
			String teacherName = "test.automation.teacher@gmail.com";
			
			String teacherPassword ="vedantu123";

			// Node Studen
/*			settings1.setBrowserName("firefox");
			settings1.setPlatform(Platform.WIN8_1);
			// Node Teacher
			settings2.setBrowserName("firefox");
			settings2.setPlatform(Platform.LINUX);*/

			// Lounching The grid

			// Student
			driver1 = new FirefoxDriver();

			// Teacher
			
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");

			driver2 = new ChromeDriver();

			driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver2.manage().window().maximize();

			//

			Thread.sleep(3000);

			driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver1.manage().window().maximize();

			// Sequential Launch
			driver1.get("https://vedantu.com/v/");
			driver2.get("https://vedantu.com/v/");
			// Login Student 

			driver1.findElement(By.xpath("(//a[contains(text(),'LOGIN')])[2]")).click();
		
			// WebDriverWait wait =new WebDriverWait(driver, 60);
			driver1.findElement(By.id("login-email")).sendKeys(studentName);
			driver1.findElement(By.id("login-password")).sendKeys(studentPassword);
			driver1.findElement(By.xpath("//input[@value = 'Log in']")).click();
			
			// Screen shot 
			LoginPage loginpage1 = new LoginPage(driver1);
			loginpage1.getscreenshot();
			
			
			// Teacher Login 
			driver2.findElement(By.xpath("(//a[contains(text(),'LOGIN')])[2]")).click();
			driver2.findElement(By.id("login-email")).sendKeys(teacherName);
			driver2.findElement(By.id("login-password")).sendKeys(teacherPassword);
			driver2.findElement(By.xpath("//input[@value = 'Log in']")).click();
			// Screen Shot 
			
			LoginPage loginpage2 = new LoginPage(driver2);
			loginpage1.getscreenshot();
			// Assert To Verify the Login - Student 
			
			
			boolean Displayed1 = driver1.findElement(By.xpath("//a[@title='My Profile']")).isDisplayed();
			Verify.verify(Displayed1);
			Reporter.log("Student Login is Succesful", true);
			loginpage2.getscreenshot();
			
			// Assert Login Teacher 
			boolean Displayed2 = driver2.findElement(By.xpath("//a[@title='My Profile']")).isDisplayed();
			Verify.verify(Displayed2);
			Reporter.log("Teacher  Login is Succesful ", true);

			loginpage2.getscreenshot();
			// Student Clicks on the Start Session 
			
			Thread.sleep(30000);
			driver1.findElement(By.xpath("//span[@class='v-regular-orange-btn clickable']")).click();
		
			Reporter.log("Student Joined The Session", true);
			// Teacher Clicks On the Start Session 
				driver2.findElement(By.xpath("//span[@class='v-regular-orange-btn clickable']")).click();
				Reporter.log("Teacher Joined The Session", true);
			//Writing on the Canvas :
			
			
			
			Thread.sleep(18000);
			// Take Screen Shot
			loginpage1.getscreenshot();
			loginpage2.getscreenshot();
			
			// Teacher Closes the Session 
			
			 Reporter.log("Teacher Ended The Session ", true);
			 driver2.findElement(By.xpath("//span[@data-type='END']")).click();
			 driver2.findElement(By.xpath("//button[contains(text(), 'Yes')]")).click();
			 Thread.sleep(10000);
			 
			//Student Assertion 
			/* boolean displayed = driver1.findElement(By.xpath("//span[conatins(text(), 'Thats that')]")).isDisplayed();
			 Assert.assertTrue(displayed);
			 
			 Reporter.log("Student Noticed That Teacher Ended The Session ", true);
		
			// Student Confirms The Closing the Session 
			
			driver1.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();*/
			
			/*driver1.findElement(By.xpath("//td[@data-session-rating='4']")).click();
			 driver1.findElement(By.xpath("//td[@data-session-rating='3']")). click();*/
			
			// Teacher Rating Student 
			
			/*driver2.findElement(By.xpath("//td[@data-session-rating='4']")).click();
			driver2.findElement(By.xpath("//td[@data-session-rating='3']")).click();*/
			driver2.findElement(By.xpath("//td[@data-session-rating='5']")).click();
		/*	driver2.findElement(By.xpath("//td[@data-session-rating='2']")).click();
			driver2.findElement(By.xpath("//td[@data-session-rating='1']")).click();*/
			
			//driver2.findElement(By.xpath("//button[@type='button']")).sendKeys(Keys.PAGE_DOWN);
		
			driver2.findElement(By.xpath("//textarea[@ng-model='sessionReview.text']")).sendKeys("No issue");
			Thread.sleep(3000);
			driver2.findElement(By.id("js-session-coverage")).sendKeys("Covered Session Details");
			JavascriptExecutor jse2 = (JavascriptExecutor)driver2;
			jse2.executeScript("window.scrollBy(0,1250)", "");
			Thread.sleep(3000);
			driver2.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div/div[1]/div/div[2]/div[4]/div[1]/form/fieldset/div[2]/div/div/isteven-multi-select/span/button")).click();
			
			driver2.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div/div[1]/div/div[2]/div[4]/div[1]/form/fieldset/div[2]/div/div/isteven-multi-select/span/div/div/div[1]/div/label/span")).click();
			driver2.findElement(By.id("js-homework")).sendKeys("No Home Work ");
			driver2.findElement(By.xpath("//input[@value='Continue']")).click();
			
			Reporter.log("Teacher Reviewed The Student", true);
			
			// Student Rating Teacher 
			
		/*	boolean displayed = driver1.findElement(By.xpath("//span[conatins(text(), 'Thats that')]")).isDisplayed();
			 Assert.assertTrue(displayed);
			 
			 Reporter.log("Student Noticed That Teacher Ended The Session ", true);*/
			loginpage1.getscreenshot();
			// Student Confirms The Closing the Session 
			
			driver1.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();
			
			Reporter.log("Student Also Confirmed the Ending", true);
			
			
			Thread.sleep(3000);
			driver1.findElement(By.xpath("//td[@data-session-rating='5']")).click();
			
			/* driver1.findElement(By.xpath("//td[@data-session-rating='2']")). click();
			 driver1.findElement(By.xpath("//td[@data-session-rating='1']")). click();
			 driver1.findElement(By.xpath("//button[@type='button']")).sendKeys(Keys.PAGE_DOWN);*/
			// Student Suggestion 
			driver1.findElement(By.xpath("//textarea[@ng-model='sessionReview.text']")).sendKeys("Session was the Best ");
			Thread.sleep(3000);

			JavascriptExecutor jse = (JavascriptExecutor) driver1;
			jse.executeScript("window.scrollBy(0,1250)", "");
			
			// Teacher Rating 
		/*	driver1.findElement(By
			.xpath("html/body/div[3]/div[2]/div/div/div/div[1]/div/div[2]/div[4]/div[2]/div[2]/div[1]/div[2]/span[5]"))
					.click();

			Thread.sleep(3000);

		
			// Any Review For The Teacher 
			driver1.findElement(By.xpath("//textarea[@placeholder='Any review for the teacher?']"))
					.sendKeys("Good Teacher");
			*/
			// Click On the Continue from Student 
			
			driver1.findElement(By.xpath("//input[@value='Continue']")).click();
			loginpage1.getscreenshot();
			
			Reporter.log("Teacher Reviewed The Student", true);
			
			Reporter.log("Test Passed : Take Session", true);
			
			driver1.close();
			driver2.close();
		

		}

	}

}