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

		// hover over user 1 and check if user name is shown
		hovers.hoverOverElement(1);
		Assert.assertTrue(hovers.getUserName().contains("user1"));

		// hover over user 1 and check if user name is shown
		hovers.hoverOverElement(2);
		Assert.assertTrue(hovers.getUserName().contains("user2"));

		// hover over user 1 and check if user name is shown
		hovers.hoverOverElement(3);
		Assert.assertTrue(hovers.getUserName().contains("user3"));
	}

}
