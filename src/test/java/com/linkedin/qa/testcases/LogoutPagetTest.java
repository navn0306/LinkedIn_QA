package com.linkedin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.pages.LogoutPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LogoutPagetTest extends TestBase{
	
	LoginPage loginPage;
	LogoutPage logoutPage;
	
	public LogoutPagetTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logoutPage = new LogoutPage();

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1, description = "Verifying Logout functionality of application")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Logout functionality of application")
	@Story("Story Name : Verifying Logout functionality of application")
	public void verifyLogout() throws InterruptedException {
		logoutPage.logout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
