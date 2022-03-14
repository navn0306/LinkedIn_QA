package com.linkedin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.SignUpPage;

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
	
	@Test
	public void test_SignUp() {
		signUpPage.signUp(prop.getProperty("newemail"), prop.getProperty("newpass"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
