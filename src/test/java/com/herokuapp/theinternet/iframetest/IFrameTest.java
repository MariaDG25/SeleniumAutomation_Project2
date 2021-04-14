package com.herokuapp.theinternet.iframetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.IFramePage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class IFrameTest extends TestUtilities {

	@Test
	public void IFrameEditorTest() {
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		// open main page
		welcomePage.openPage();

		// scroll down to WYSIWYG link
		welcomePage.scrollDown();

		// click on WYSIWYG Editor link
		final IFramePage iframe = welcomePage.clickIFramePage();
		Assert.assertTrue(iframe.getContentiFrame().contains("Your content goes here."));

		// switch focus to the page again
		iframe.switchFocus();

	}

}
