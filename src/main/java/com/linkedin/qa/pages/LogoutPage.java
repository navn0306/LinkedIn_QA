package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.linkedin.qa.base.TestBase;

public class LogoutPage extends TestBase {

	@FindBy(xpath = "//button[@id='ember25']")
	WebElement meBtn;
	
	public void validateLogout() {
		meBtn.click();
		
	}
}
