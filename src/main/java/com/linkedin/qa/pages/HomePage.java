package com.linkedin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.popups.ChatPopUp;
import com.linkedin.qa.popups.UploadProfilePicPopUp;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='t-16 t-black t-bold']")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@id='ember18']")
	WebElement homePageLink;

	@FindBy(xpath = "//a[@id='ember19']")
	WebElement myNetWorkPageLink;

	@FindBy(xpath = "//a[@id='ember20']")
	WebElement jobsPageLink;

	@FindBy(xpath = "//a[@id='ember21']")
	WebElement messagingPageLink;

	@FindBy(xpath = "//a[@id='ember22']")
	WebElement notificationsPageLink;

	@FindBy(xpath = "//header/div[3]/button[2]/li-icon[1]/*[1]")
	WebElement minimizeChat;

	@FindBy(linkText = "Add a photo")
	WebElement uploadProfilePic;
	

	// Constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}

	public MyNetworkPage clickOnMyNetworks() {
		myNetWorkPageLink.click();
		return new MyNetworkPage();
	}

	public JobsPage clickOnJobs() {
		jobsPageLink.click();
		return new JobsPage();
	}

	public MessagingPage clickOnMessaging() {
		messagingPageLink.click();
		return new MessagingPage();
	}

	public NotificationsPage clickOnNotifications() {
		notificationsPageLink.click();
		return new NotificationsPage();
	}

	public ChatPopUp clickOnMinimizeChat() {
		minimizeChat.click();
		return new ChatPopUp();
	}
	
	public UploadProfilePicPopUp uploadprofilePicture() {
		uploadProfilePic.click();
		driver.switchTo().activeElement();
		return new UploadProfilePicPopUp();
	}

	public void scrollUsingJSE() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='ember18']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		for (int i = 0; i < 5; i++) {
			jse.executeScript("window.scrollBy(0, 1500)");
			Thread.sleep(3000);
		}
		for (int i = 0; i < 5; i++) {
			jse.executeScript("window.scrollBy(0, -1500)");
			Thread.sleep(3000);
		}
	}
}
