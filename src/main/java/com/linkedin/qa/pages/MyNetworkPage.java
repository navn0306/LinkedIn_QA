package com.linkedin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;

public class MyNetworkPage extends TestBase{

	@FindBy(xpath = "//div[@class='nt-application__left-rail-title-card p4 text-align-center']")
	WebElement notificationLabel;
	
	//Constructor
	public MyNetworkPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectNotification() {
		driver.findElement(By.xpath(null));
	}
}
