package com.vedantu.test.sanity1_testsuite;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.vedantu.test.pom.Excel;
import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.Retry;
import com.vedantu.test.pom.SignupPage;
import com.vedantu.test.pom.StudentHomePage;

public class Signup extends Login

{
	@Test(retryAnalyzer=Retry.class)
	public void GeneralSignup() throws InterruptedException

	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String xlPath = "./excel/PRODMasterLibrary.xlsx";
		String Sheet = "Sheet5";
		int re = Excel.getRowCount(xlPath, Sheet);
		
		for (int i = 1; i <= re; i++) {
			String First = Excel.getCellValue(xlPath, Sheet, i, 1);
			String Last = Excel.getCellValue(xlPath, Sheet, i, 2);
			//String EmailAddress = Excel.getCellValue(xlPath, Sheet, i, 3);
			String passwordEnter = Excel.getCellValue(xlPath, Sheet, i, 4);
			String confirmPasswordEnter = Excel.getCellValue(xlPath, Sheet, i, 5);
			String PhoneDetails = Excel.getCellValue(xlPath, Sheet, i, 6);

			Random rn = new Random();
			int answer = 0;

			for (int k = 0; k < 100000; k++) {
				answer = rn.nextInt(1000) + 102;

			}

			String num = Integer.toString(answer);

			String EmailAddress = "automationqa" + num + "@vedalan.com";

			SignupPage signupPage = new SignupPage(driver);
			signupPage.signupClick();
			signupPage.firstName(First);
			signupPage.lastName(Last);
			signupPage.maleClick();

			signupPage.email(EmailAddress);
			signupPage.password(passwordEnter);
			signupPage.confirmPassword(confirmPasswordEnter);
			signupPage.mobile(PhoneDetails);

			// signupPage.mobile ("9686642940");

			driver.findElement(By.xpath("//button[contains(text(), 'Male')]")).sendKeys(Keys.PAGE_DOWN);

			signupPage.gradeSelect();
			signupPage.select10();

			Thread.sleep(1000);
			driver.findElement(By.id("location-info")).sendKeys("Manga");
			driver.findElement(By.id("location-info")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("location-info")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.id("location-info")).click();
			driver.findElement(By.id("location-info")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// driver.findElement(By.id("location-info")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			signupPage.signupAsStudent();
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='My Profile']")).isDisplayed());
			Reporter.log("General Signup is Succesful ", true);
			Thread.sleep(3000);
			driver.findElement(By.xpath(" //button[contains(text(),'Ok')]")).click();
			StudentHomePage studentBasePage = new StudentHomePage(driver);

			// studentBasePage.studentProfileClick();

			Thread.sleep(3000);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Profile']")));

			element.click();

			// studentBasePage.studentProfileClick();

			studentBasePage.logOutClick();

			boolean logincondition = driver.findElement(By.xpath("(//a[contains(text(), 'LOGIN')])[2]")).isDisplayed();

			// Assert.assertTrue(logincondition );

			Verify.verify(logincondition);

			Reporter.log("General Signout is Successful", true);
			Reporter.log("Test Passed : General Signin- Signout", true);
		}
	}

}
