package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities{

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		
		log.info("Starting logIn test");

		// open main page
		welcomePage.openPage();

		// Click on Form Authentication link
		final LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// enter username and password and click on Login button
		loginPage.logInFail(username,password);

		// Verification
		loginPage.waitForErrorMessage();
		String actualErrorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
