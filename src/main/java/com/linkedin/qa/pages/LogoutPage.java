package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;

import io.qameta.allure.Step;

public class LogoutPage extends TestBase {
	@FindBy(xpath = "//button[@id='ember25']")
	WebElement meButton;

	@FindBy(xpath = " //a[@class='global-nav__secondary-link mv1']")
	WebElement signOutButton;

	// Constructor
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Verifying Logout Functionality")
	public void logout() {
		meButton.click();
		signOutButton.click();
	}
}
