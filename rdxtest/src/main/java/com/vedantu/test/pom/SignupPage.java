package com.vedantu.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage
{
	
private WebDriver driver;


@FindBy(xpath = "(//a[contains(text(),'SIGNUP')])[2]")
private WebElement signupTab;


/*data members (Private)
represents the web elements present on the Web Page, always declared as private 


*/

/**

* All WebElements are identified by @FindBy annotation

*/

@FindBy(name="firstName")
private WebElement fName;

@FindBy(name="lastName")
private WebElement lName;

@FindBy(xpath ="//button[contains(text(),'Male')]")
private WebElement male;

@FindBy(xpath ="//button[contains(text(),'Female')]")
private WebElement female;

@FindBy(xpath ="//button[contains(text(),'Other')]")
private WebElement other;

@FindBy(name = "email")
private WebElement  emailId;

@FindBy(name="password")
private WebElement password;

@FindBy(name="confirm-password")
private WebElement confirmPassword;

@FindBy(id="signup-mobile-field")
private WebElement mobileNumber;

@FindBy(xpath ="//button[@data-toggle='dropdown']")
private WebElement grade;

@FindBy(xpath = "//a[contains(text(),'Other')]")
private WebElement otherGrade;

@FindBy(xpath = "//a[contains(text(),'6')]")

private WebElement grade6;

@FindBy(xpath = "//a[contains(text(),'7')]")
private WebElement grade7;

@FindBy(xpath = "//a[contains(text(),'8')]")
private WebElement grade8;

@FindBy(xpath = "//a[contains(text(),'9')]")
private WebElement grade9;

@FindBy(xpath = "//a[contains(text(),'10')]")
private WebElement grade10;

@FindBy(xpath ="//input[@value = 'sign up as student']")
private WebElement signupStudent;



/*Constructors (Page Decorate)
 * Used to Initialize the elements presents on the Web Page 
 * 
 * 
 * */

public SignupPage(WebDriver driver)
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

public void signupClick()
{
	signupTab.click();
}



public void firstName(String fn)
{
	fName.sendKeys(fn);
}


public void lastName(String ln)
{
	lName.sendKeys(ln);
}

public void maleClick()
{
	male.click();
}

public void femaleClick()
{
	female.click();
}

public void otherClick()
{
	other.click();
}

public void email(String mail)
{
	emailId.sendKeys(mail);
}


public void password(String pw)
{
	password.sendKeys(pw);
}

public void confirmPassword(String cpw)
{
	confirmPassword.sendKeys(cpw);
	
}

public void mobile(String mob)
{
	mobileNumber.sendKeys(mob);
}



public void gradeSelect()
{
	grade.click();
}

public void select6()
{
	grade6.click();
}

public void select7()
{
	grade7.click();
}

public void select8()
{
	grade8.click();
}

public void select9()
{
	grade9.click();
}

public void select10()
{
	grade10.click();
}

public void signupAsStudent()
{
	signupStudent.click();
}

}
