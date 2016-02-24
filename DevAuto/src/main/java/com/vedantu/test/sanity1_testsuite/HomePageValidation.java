package com.vedantu.test.sanity1_testsuite;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vedantu.test.pom.HomePage;
import com.vedantu.test.pom.Login;
import com.vedantu.test.pom.Retry;

public class HomePageValidation extends Login

{
	@Test(retryAnalyzer=Retry.class)
	public void HomePageValidations() throws InterruptedException {

			
			HomePage homepage = new HomePage(driver);
	
			String actual;
			
			actual = driver.getTitle();
			Assert.assertEquals(actual, "Online Tuition Teacher | Online Live Tutor | One to One eTutor - Vedantu");			
			Reporter.log("Homepage validated ",true);
						
			homepage.LoginClick();
			String actual1 = driver.getTitle();
			Assert.assertEquals(actual1, "Login to Vedantu");			
			Reporter.log("Login navigates to Login page  ",true);
			
								
			homepage.SignupClick();
			String actual2 = driver.getTitle();
			Assert.assertEquals(actual2, "Register to Vedantu");			
			Reporter.log("Sign up navigates to Signup page  ",true);
			Reporter.log("Test Passed: Home Page Validation",true);
			
			
			
	}

}