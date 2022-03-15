package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;

import io.qameta.allure.Step;
	
public class LoginPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement submitSignIn;

	@FindBy(xpath = "//i[contains(@class,'profile__pic--ghost')]")
	WebElement profilePic;

	//Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Getting Login Page Title")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("Verifying Login Feature with userName : {0} and password : {1}")
	public HomePage login(String un, String pwd) {
		signInBtn.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		submitSignIn.click();

		return new HomePage();
	}
	
	@Step("Verifying Login Feature using Data Driven Concept userName : {0} and password : {1}")
	public void loginMultipleAccounts(String un, String pwd) {
		signInBtn.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		submitSignIn.click();
	}

}
