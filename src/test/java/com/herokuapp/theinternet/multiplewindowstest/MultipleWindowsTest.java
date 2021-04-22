package com.herokuapp.theinternet.multiplewindowstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class MultipleWindowsTest extends TestUtilities {

	@Test(priority = 1)
	public void MultipleWdwTest() {
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		// open main page
		welcomePage.openPage();

		// click on MultipleWindows link
		final MultipleWindowsPage multipleWdw = welcomePage.clickMultipleWindowsPage();
		Assert.assertTrue(multipleWdw.getPageTitleText().contains("Opening a new window"));
		
		//click on 'Click Here' link
		final NewWindowPage newWidw = multipleWdw.clickNewWindowsPage();
		
		//checking it is correctly opened
		log.info("Checking the title and the URL");
		Assert.assertTrue(newWidw.getNewWindowTitle().contains("New Window"));
		
	}
}
