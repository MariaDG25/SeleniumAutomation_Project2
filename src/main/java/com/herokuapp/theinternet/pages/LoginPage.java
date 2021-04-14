package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author María Dolz Explanation: this pages includes the relevant functions
 *         for the second page in the application (login page)
 *
 */

public class LoginPage extends BasePageObject {

	private By usernameLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By logInButtonLoc = By.className("radius");
	private By errorMessageLoc = By.id("flash");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// opening secure area through login form
	public SecureAreaPage logIn(String username, String password) {
		log.info("Executing LogIn with username[" + username + "] and password [" + password + "]");
		type(username, usernameLoc);
		type(password, passwordLoc);
		click(logInButtonLoc);
		return new SecureAreaPage(driver, log);
	}

	//type incorrect credentials 
	public void logInFail(String username, String password) {
		log.info("Executing LogIn with username[" + username + "] and password [" + password + "]");
		type(username, usernameLoc);
		type(password, passwordLoc);
		click(logInButtonLoc);
	}

	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLoc, 5);
	}
	public String getErrorMessage() {
		return find(errorMessageLoc).getText();
	}

}
