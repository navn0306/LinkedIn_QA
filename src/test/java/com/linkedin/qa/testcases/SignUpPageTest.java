package com.linkedin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.SignUpPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
	}
	
	@Test(priority = 1, description = "Verifying SignUp functionality of application")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying SignUp functionality of application")
	@Story("Story Name : Verifying SignUp functionality of application")
	public void test_SignUp() {
		signUpPage.signUp(prop.getProperty("newemail"), prop.getProperty("newpass"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
