package com.linkedin.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.listeners.CustomListeners;
import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.popups.ChatPopUp;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(CustomListeners.class)
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ChatPopUp chatPopUp;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		chatPopUp = new ChatPopUp();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, description = "Verifying HomePage Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verify HomePage Title on HomePage")
	@Story("Story Name : Verifying HomePage Title")
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Wrong Title");
	}

	@Test(priority = 2, description = "Verifying User Name on HomePage after Login")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verifying User Name on HomePage after Login")
	@Story("Story Name : Verifying User Name on HomePage after Login")
	public void verifyUserNameIsDisplayed() {
		Assert.assertTrue(homePage.validateUserName());
	}

	@Test(priority = 3, description = "Verifying Minimize Chat Popup button on HomePage")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : Verifying Minimize Chat Popup button on HomePage")
	@Story("Story Name : Verifying Minimize Chat Popup button on HomePage")
	public void minimizeChatWindow() {
		chatPopUp = homePage.clickOnMinimizeChat();
	}

	@Test(priority = 4, description = "Verifying Jobs Page button on HomePage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Jobs Page button on HomePage")
	@Story("Story Name : Verifying Jobs Page button on HomePage")
	public void verifyJobsPageLink() {
		homePage.clickOnJobs();
	}

	@Test(priority = 5, description = "Verifying Messaging Page button on HomePage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Messaging Page button on HomePage")
	@Story("Story Name : Verifying Messaging Page button on HomePage")
	public void verifyMessagingPageLink() {
		homePage.clickOnMessaging();
	}

	@Test(priority = 6, description = "Verifying Notifications Page button on HomePage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Notifications Page button on HomePage")
	@Story("Story Name : Verifying Notifications Page button on HomePage")
	public void verifyNotificationsPageLink() {
		homePage.clickOnNotifications();
	}

	@Test(priority = 7, description = "Verifying MyNetworks Page button on HomePage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying MyNetworks Page button on HomePage")
	@Story("Story Name : Verifying MyNetworks Page button on HomePage")
	public void verifyMyNetworkPageLink() {
		homePage.clickOnMyNetworks();
	}

	@Test(priority = 8, description = "Verifying Upload Profile Picture Functionality on HomePage")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verifying Upload Profile Picture Functionality on HomePage")
	@Story("Story Name : Verifying Upload Profile Picture Functionality on HomePage")
	public void uploadProfilePic() {

	}

	@Test(priority = 9, description = "Verifying Scroll page Functionality on HomePage")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description : Verifying Scroll page Functionality on HomePage")
	@Story("Story Name : Verifying Scroll page Functionality on HomePage")
	public void scrollPage() throws InterruptedException {
		homePage.scrollUsingJSE();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
