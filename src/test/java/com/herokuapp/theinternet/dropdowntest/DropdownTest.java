package com.herokuapp.theinternet.dropdowntest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DropdownTest extends TestUtilities {

	@Test
	public void selectOptionDropdown() {
		log.info("Starting selectOptionDropdown test");

		// open main page
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//open Dropdown page
		final DropdownPage dropdownPage = welcomePage.clickDropdownPage();
		
		//select option 2
		dropdownPage.selectOption(2);
		
		//verify option 2 is selected
		assertEquals(dropdownPage.getOptionSelected(),"Option 2", "the option is not the expected one.");
	}

}
