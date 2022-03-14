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

	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}
	
	@Test
	public void loginPageTitleTestWithLogs() {
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		log.info("****************************** starting test case *****************************************");
		log.info("********************************* LinkedInTest *****************************************");
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
		log.info("****************************** ending test case *****************************************");
		log.info("******************************** LinkedInTest *****************************************");
	}

	@Test
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getLoginTestData")
	public void multipleLoginTest(String userName,String password) throws InterruptedException {
		loginPage.loginMultipleAccounts(userName,password);
		Thread.sleep(3000);
	}
	
	@Test
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
