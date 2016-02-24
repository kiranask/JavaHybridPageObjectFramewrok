package com.vedantu.test.sanity1_testsuite;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.vedantu.test.pom.*;

public class StudentLogin extends Login

{
	@Test(retryAnalyzer=Retry.class)
	public void StudentLoginTest() throws InterruptedException {

			String email = "qa-student@gmx.com";
			String password = "vedantu123";
			LoginPage loginpage = new LoginPage(driver);
			loginpage.loginClick();
			loginpage.loginCredentials(email, password);
			// click on the Login Button
			loginpage.logClick();
			boolean Displayed = driver.findElement(By.xpath("//a[@title='My Profile']")).isDisplayed();
			Verify.verify(Displayed);
			Reporter.log("Student Login is Successful",  true);

			driver.findElement(By.id("logo")).click();
			Thread.sleep(3000);
			StudentHomePage studentBasePage = new StudentHomePage(driver);

			studentBasePage.studentProfileClick();
			studentBasePage.logOutClick();
			boolean logincondition = driver.findElement(By.xpath("(//a[contains(text(), 'LOGIN')])[2]")).isDisplayed();

			// Assert.assertTrue(logincondition );
			Verify.verify(logincondition);
			Reporter.log("Student Logout is Sucessful", true);
			Reporter.log("Test Passed: Student Login-Logout", true);

		
	}

}