package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// 3 thingss
	// 1 Constructor
	// 2.pageactions
	// 3.ByLocator

	private WebDriver driver;

	// 1.By Locator or object repository
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By submit = By.id("SubmitLogin");
	private By forgotPwdLik = By.linkText("Forgot your password?");

	// 2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions : features
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLik).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailID).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(submit).click();
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println("Login with:" +  un + "and" + pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submit).click();
		return new AccountsPage(driver);
	}
}
