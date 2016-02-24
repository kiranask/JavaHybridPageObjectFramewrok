package com.vedantu.test.sanity1_testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.LoginPage;
import com.vedantu.test.pom.Retry;

public class AdminLogin extends Login

{
	@Test(retryAnalyzer=Retry.class)
	public void AdministartorLogin() throws InterruptedException {

		String email = "kiransk@vedantu.in";
		String password = "vedantu123";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginClick();
		// Load Mail and password
		loginpage.loginCredentials(email, password);

		// click on the Login Button
		loginpage.logClick();
		loginpage.getscreenshot();

		// click on the Logout Button
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Register User')]")).isDisplayed());
		Reporter.log("Administrator Login is Successful", true);
		Thread.sleep(1000);
		loginpage.logOutClick();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(text(), 'LOGIN')])[2]")).isDisplayed());
		Reporter.log("Administrator Logout is Successful", true);
		Reporter.log("Test Passed: Administrator Login-Logout ", true);

	}

}
