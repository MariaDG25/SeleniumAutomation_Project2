package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage extends BasePageObject {

	private By result = By.id("result");

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// press ENTER key
	public void pressEnterKey(Keys key) {
		Actions actionKey = new Actions(driver);
		actionKey.sendKeys(key);
		actionKey.build().perform();
	}

	// return result text
	public String getResultText() {
		waitForVisibilityOf(result, 10);
		return find(result).getText();
	}

}
