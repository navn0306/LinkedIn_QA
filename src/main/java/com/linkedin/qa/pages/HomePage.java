package com.linkedin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.popups.ChatPopUp;
import com.linkedin.qa.popups.UploadProfilePicPopUp;

import io.qameta.allure.Step;

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

	@Step("Getting HomePage Title")
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	@Step("Checking if User Name is present after login")
	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}

	@Step("Checking Network Page Button")
	public void clickOnMyNetworks() {
		myNetWorkPageLink.click();
	}

	@Step("Checking Jobs Page Button")
	public void clickOnJobs() {
		jobsPageLink.click();
	}

	@Step("Checking Messaging Page Button")
	public void clickOnMessaging() {
		messagingPageLink.click();
	}

	@Step("Checking Notifications Page Button")
	public void clickOnNotifications() {
		notificationsPageLink.click();
	}

	@Step("Checking Minimize Chat Button")
	public ChatPopUp clickOnMinimizeChat() {
		minimizeChat.click();
		return new ChatPopUp();
	}
	
	@Step("Verifying Upload profile Picture Funtionality")
	public UploadProfilePicPopUp uploadprofilePicture() {
		uploadProfilePic.click();
		driver.switchTo().activeElement();
		return new UploadProfilePicPopUp();
	}

	@Step("Checking Scroll feature on HomePage")
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
