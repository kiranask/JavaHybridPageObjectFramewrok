// Not Updated In the Master

package com.vedantu.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage
{
/*data members (Private)
represents the web elements present on the Web Page, always declared as private 
*/
/**
* All WebElements are identified by @FindBy annotation

*/
@FindBy(xpath="//a[@title='My Profile']")
private WebElement myProf;

@FindBy(xpath="//button[contains(text(),'Logout')]")
private WebElement logoutButton;

@FindBy(xpath = "//a[contains (text(),'Schedule Session' )]")
private WebElement scheduleSession;






private WebDriver driver;

public AdminHomePage(WebDriver driver)
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


public void teacherProfileClick()
{
	myProf.click();
}

// Click on Logout Button 


public void logOutClick()
{
	logoutButton.click();
}

public void scheduleSessionClick()
{
	scheduleSession.click();
}
}
