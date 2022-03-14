package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;

public class SignUpPage extends TestBase{

	@FindBy(xpath = "//a[contains(text(),'Join now')]")
	WebElement joinNowBtn;
	
	@FindBy(xpath = "//input[@id='email-or-phone']")
	WebElement emailOrPhone;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='join-form-submit']")
	WebElement joinFormSubmit;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void signUp(String property, String property2) {
		// TODO Auto-generated method stub
		joinNowBtn.click();
		emailOrPhone.sendKeys(property);
		password.sendKeys(property2);
		joinFormSubmit.click();
	}
}
