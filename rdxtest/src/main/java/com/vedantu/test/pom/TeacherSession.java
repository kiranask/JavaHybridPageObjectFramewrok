// Not In Master 

package com.vedantu.test.pom;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
public class TeacherSession
{
@FindBy(name = "student")
private WebElement studentnameData;
@FindBy(name = "teacher")
private WebElement teachernameData;
@FindBy(name = "topic")
private WebElement topicData;
@FindBy(name = "title")
private WebElement titleData;
@FindBy(xpath ="(//textarea)[1]")
private WebElement descriptionData;
@FindBy(xpath = "//input[@type ='submit']")
private WebElement submit;
@FindBy(xpath ="//a[contains(text(),'My Sessions')]")
private WebElement mySessions;
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

@FindBy(id="submit-register")
private WebElement signupStudent;

@FindBy(name="startTime")
private WebElement startTime;
@FindBy(name ="endTime")
private WebElement endTime;	
private WebDriver driver;
public TeacherSession(WebDriver driver)
{
	this.driver=driver;
	
	//This initElements method from the Page Factory Class  will create all WebElements
	// Which takes 2 arguments, Instance of the Driver and Instance of the Present Class 
	
	PageFactory.initElements(driver, this);
}
public void studentNameEnter(String nm)
{
	studentnameData.sendKeys(nm);
}

// Click on Logout Button 
public void teacherNameDataEnter(String em)
{
	teachernameData.sendKeys(em);
}
public void topicDataEnter(String ph)
{
	topicData.sendKeys(ph);
}
public void titleDataEnter(String pg)
{
	titleData.sendKeys(pg);
}

public void descriptionDataEnter(String des)
{
	descriptionData.sendKeys(des);
}

public void submitClick()
{
	submit.click();
}

public void startTimeData(String stm)
{
	startTime.sendKeys(stm);
}
public void endTimeData(String etm)
{
	endTime.sendKeys(etm);
}
public void mySessionClick()
{
	mySessions.click();
}

public void getscreenshot() throws Exception 
{
	EventFiringWebDriver  edriver = new EventFiringWebDriver(driver);
	
	File srcFile = edriver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("/home/kiran-pc/ScreenShot/Screensheet1.png"));
}
}

