package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;
	
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

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		signInBtn.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		submitSignIn.click();

		return new HomePage();
	}
	
	public void loginMultipleAccounts(String un, String pwd) {
		signInBtn.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		submitSignIn.click();
	}

}
