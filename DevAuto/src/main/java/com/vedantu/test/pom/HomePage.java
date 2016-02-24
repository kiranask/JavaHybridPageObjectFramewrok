// Not Updated In the Master

package com.vedantu.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	@FindBy(xpath = "html/body/div[3]/div[1]/nav/div/div[1]/a")
	private WebElement logo;
	
	@FindBy(xpath = "(//a[contains(text(),'LOGIN')])[2]")
	private WebElement loginTab;

	@FindBy(xpath = "//a[contains(text(),'SIGNUP')]")
	private WebElement signupTab;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void LogoClick() {
		logo.click();
	}

	public void LoginClick() {
		loginTab.click();
	}

	public void SignupClick() {
		signupTab.click();
	}
}
