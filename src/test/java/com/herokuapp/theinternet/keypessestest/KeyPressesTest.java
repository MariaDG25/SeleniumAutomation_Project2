package com.herokuapp.theinternet.keypessestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesTest extends TestUtilities {

	@Test(priority = 1)
	public void KeyPressTest() {

		final WelcomePage welcomePage = new WelcomePage(driver, log);
		// open main page
		welcomePage.openPage();
		
		//open Key Presses page 
		KeyPressesPage keyPresses = welcomePage.clickKeyPressesPage();
		
		//click ENTER
		keyPresses.pressEnterKey(Keys.ENTER);
		
		//Verify result text contains "ENTER"
		Assert.assertTrue(keyPresses.getResultText().contains(Keys.ENTER.name()));
	}

}
