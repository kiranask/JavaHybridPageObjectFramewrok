package com.vedantu.test.pom;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage


{
private WebDriver driver;

/*data members (Private)
represents the web elements	 present on the Web Page, always declared as private 

*/

/**

* All WebElements are identified by @FindBy annotation

*/
@FindBy(xpath = "(//a[contains(text(),'LOGIN')])[2]")
private WebElement loginTab;

@FindBy(id="login-email")
private WebElement emailId;

@FindBy(id="login-password")
private WebElement password;

@FindBy(xpath ="//input[@value = 'Log in']")
private WebElement loginButton;


@FindBy(xpath = "//button[contains(text(), 'Logout')]")

private WebElement logoutButton;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	
	//This initElements method from the Page Factory Class  will create all WebElements
	// Which takes 2 arguments, Instance of the Driver and Instance of the Present Class 
	
	PageFactory.initElements(driver, this);
}

/*	 Methods are Public which are used to Perform the Action on the  elements.
 * Setters = Method which will change the status of the Elements 
 * Getters = Methods which returns any status of the Elements 
 * 
 * 
*/	
// Give User name and Password	
public void loginClick()
{
	loginTab.click();
}

public void loginCredentials(String un,String pw)
{
	emailId.sendKeys(un);
	password.sendKeys(pw);

	
}


// Click on Login Button


public void logClick()
{
	loginButton.click();
}

// Click on Logout Button 


public void logOutClick()
{
	logoutButton.click();
}

public void getscreenshot() 
{
	
	EventFiringWebDriver  edriver = new EventFiringWebDriver(driver);
	 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 Date now = new Date();
	 String Timestamp = sdfDate.format(now);
	try 
	{
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(srcFile, new File("./ScreenShot/Screensheet"+Timestamp+".png"));
	} catch (IOException e) 
	
	{
	}
}



}
