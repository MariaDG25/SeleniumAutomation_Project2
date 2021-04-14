package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePageObject {
	private By result = By.id("result");

	public AlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// open JS alert
	public void openJsAlert(String alert) {
		By loc = By.id("");
		switch (alert) {
		case "jsAlert":
			loc = By.xpath("//button[contains(.,'Click for JS Alert')]");
			break;
		case "jsConfirm":
			loc = By.xpath("//button[contains(.,'Click for JS Confirm')]");
			break;
		case "jsPrompt":
			loc = By.xpath("//button[contains(.,'Click for JS Prompt')]");
			break;

		default:
			log.info("IMPORTANT: No alert found");
		}
		click(loc);
	}

	// read the text in the Alert
	public String getalertText() {
		return getAlertText();
	}

	// type a message in PromptAlert
	public void sendKeysPromptAlert(String message) {
		sendKeysAlert(message);
	}

	//return the result message at the bottom of the page
	public String getResultText() {
		return find(result).getText();
	}
}
