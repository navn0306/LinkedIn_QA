package com.linkedin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.JobsPage;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.pages.MessagingPage;
import com.linkedin.qa.pages.MyNetworkPage;
import com.linkedin.qa.pages.NotificationsPage;
import com.linkedin.qa.popups.ChatPopUp;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MyNetworkPage myNetworkPageTitle;
	JobsPage jobsPage;
	MessagingPage messagingPage;
	NotificationsPage notificationsPage;
	ChatPopUp chatPopUp;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		myNetworkPageTitle = new MyNetworkPage();
		jobsPage = new JobsPage();
		messagingPage = new MessagingPage();
		notificationsPage = new NotificationsPage();
		chatPopUp = new ChatPopUp();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Feed | LinkedIn", "Homepage title not matching");
	}

	@Test(priority = 2)
	public void verifyUserNameIsDisplayed() {
		Assert.assertTrue(homePage.validateUserName());
	}

	@Test(priority = 3)
	public void minimizeChatWindow() {
		chatPopUp = homePage.clickOnMinimizeChat();
	}

	@Test(priority = 4)
	public void verifyJobsPageLink() {
		jobsPage = homePage.clickOnJobs();
	}

	@Test(priority = 5)
	public void verifyMessagingPageLink() {
		messagingPage = homePage.clickOnMessaging();
	}

	@Test(priority = 6)
	public void verifyNotificationsPageLink() {
		notificationsPage = homePage.clickOnNotifications();
	}

	@Test(priority = 7)
	public void verifyMyNetworkPageLink() {
		myNetworkPageTitle = homePage.clickOnMyNetworks();
	}
	
	@Test
	public void uploadProfilePic() {
		//doubt  
	}
	
	@Test
	public void scrollPage() throws InterruptedException {
		homePage.scrollUsingJSE(); 
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
