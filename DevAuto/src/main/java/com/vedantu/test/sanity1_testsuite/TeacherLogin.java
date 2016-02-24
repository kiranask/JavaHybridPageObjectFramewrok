package com.vedantu.test.sanity1_testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vedantu.test.pom.Excel;
import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.LoginPage;
import com.vedantu.test.pom.Retry;
import com.vedantu.test.pom.TeacherHomePage;

public class TeacherLogin extends Login

{

	@Test(retryAnalyzer=Retry.class)
	public void TeacherLoginTest() throws InterruptedException {




		
			String email = "test.automation.teacher@gmail.com";
			String password = "vedantu123";
			LoginPage loginpage = new LoginPage(driver);
			loginpage.loginClick();
			loginpage.loginCredentials(email, password);
			loginpage.logClick();
			Assert.assertTrue(driver.findElement(By.xpath("//a[@analytics-category='CHAT']")).isEnabled());
			Reporter.log("Teacher Login is Succesful", true);
			driver.findElement(By.id("logo")).click();
			Thread.sleep(3000);
			TeacherHomePage teacherBasePage = new TeacherHomePage(driver);
			// driver.findElement(By.id("logo")).click();
			teacherBasePage.teacherProfileClick();
			teacherBasePage.logOutClick();
			Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(text(), 'LOGIN')])[2]")).isDisplayed());
			Reporter.log("Teacher Logout is Sucessful", true);
			Reporter.log("Test Passed: Teacher Login-Logout ",true);

			

	}

}