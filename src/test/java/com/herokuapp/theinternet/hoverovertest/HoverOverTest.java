package com.herokuapp.theinternet.hoverovertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HoverOverTest extends TestUtilities {

	@Test(priority = 1)
	public void HoversTest() {
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		// open main page
		welcomePage.openPage();

		// click on Hovers link
		final HoverPage hovers = welcomePage.HoverPage();

		//open user profile
		hovers.openUserProfile(1);
		
		//check URL of user 3 profile is correct
		Assert.assertEquals(hovers.getCUrl(), hovers.getExpectedURL());
		
		//check h1 text is the expected
		Assert.assertTrue(hovers.getNewPagetext().contains("Not Found"), "The expected text is not shown");
	}

}
