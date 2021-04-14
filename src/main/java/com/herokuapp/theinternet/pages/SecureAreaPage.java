package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	private String secureAreaUrl = "http://the-internet.herokuapp.com/secure";
	private By logOutButtonLoc = By.xpath("//a[@class='button secondary radius']");
	String expectedSuccessMessage = "You logged into a secure area!";
	private By actualSuccessMessageLoc = By.id("flash");

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//open secure area URL
	public void Open() {
		log.info("Opening URL: " + secureAreaUrl);
		openURL(secureAreaUrl);
	}

	// return secure area URL
	public String getSecureAreaUrl() {
		return secureAreaUrl;
	}
	
	// change URL
	public void setSecureAreaUrl(String secureAreaUrl) {
		this.secureAreaUrl = secureAreaUrl;
	}

	// check if log out button is enabled
	public boolean logOutButtonDisplayed() {
		return elementDisplayed(logOutButtonLoc);
	}

	//return success message
	public String getExpectedSuccessMessage() {
		return expectedSuccessMessage;
	}

	//change success message
	public void setExpectedSuccessMessage(String expectedSuccessMessage) {
		this.expectedSuccessMessage = expectedSuccessMessage;
	}
	
	//return current message
	public String getActualMessage() {
		return find(actualSuccessMessageLoc).getText();
	}

}
