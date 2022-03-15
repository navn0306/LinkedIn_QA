package com.linkedin.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	String sheetName = "Login";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1, description = "Verifying Login Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verify Login Page Title on HomePage")
	@Story("Story Name : Verifying Login Page Title")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}
	
	@Test(priority = 2, description = "Verifying Login Page Title and getting the logs")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verifying Login Page Title and getting the logs")
	@Story("Story Name : Verifying Login Page Title and getting the logs")
	public void loginPageTitleTestWithLogs() {
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}

	@Test(priority = 3, description = "Verifying Login Functionalilty")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Login Functionalilty")
	@Story("Story Name : Verifying Login Functionalilty")
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Test Passes");
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider = "getLoginTestData", priority = 3, description = "Verifying Login Functionalilty with mutliple accounts")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Login Functionalilty with mutliple accounts")
	@Story("Story Name : Verifying Login Functionalilty with mutliple accounts")
	public void multipleLoginTest(String userName,String password) {
		loginPage.loginMultipleAccounts(userName,password);
	}
	
	@Test(priority = 3, description = "Taking screenshot for the page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verifying Login Functionalilty with mutliple accounts")
	@Story("Story Name : Verifying Login Functionalilty with mutliple accounts")
	public void test_AfterLogin_TakeScreenshot() throws InterruptedException, IOException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.takeScreenshotAtEndOfTest();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
