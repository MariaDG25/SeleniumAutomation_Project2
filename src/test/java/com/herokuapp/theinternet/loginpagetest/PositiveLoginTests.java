package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.BasePageObject;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
	
		final BasePageObject basePageObj = new BasePageObject(driver, log);
		final WelcomePage welcomePage = new WelcomePage(driver, log);

		// open main page
		welcomePage.openPage();

		// Click on Form Authentication link
		final LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// enter username and password and click on Login button
		final SecureAreaPage secureArea = loginPage.logIn("tomsmith", "SuperSecretPassword!");
		
		sleep(3000);

		// verifications
		Assert.assertEquals(basePageObj.getCurrentUrl(), secureArea.getSecureAreaUrl());

		// log out button is visible
		Assert.assertTrue(secureArea.logOutButtonDisplayed(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = secureArea.getExpectedSuccessMessage();
		String actualSuccessMessage = secureArea.getActualMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
