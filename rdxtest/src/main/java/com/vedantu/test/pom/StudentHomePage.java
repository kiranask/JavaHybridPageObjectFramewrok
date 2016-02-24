package com.vedantu.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage


{
private WebDriver driver;

/*data members (Private)
represents the web elements present on the Web Page, always declared as private 

*/

/**

* All WebElements are identified by @FindBy annotation

*/

@FindBy(xpath="//a[@title='My Profile']")
private WebElement myProf;

@FindBy(id="apply")
private WebElement logoutButton;

/*@FindBy(xpath ="//input[@value = 'Log in']")
private WebElement loginButton;


@FindBy(xpath = "//button[contains(text(), 'Logout')]")

private WebElement logoutButton;
*/
public StudentHomePage(WebDriver driver)
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
/*public void login(String un,String pw)
{
	EmailId.sendKeys(un);
	Password.sendKeys(pw);

	
}*/

// Click on Login Button


public void studentProfileClick()
{
	myProf.click();
}

// Click on Logout Button 


public void logOutClick()
{
	logoutButton.click();
}



}

