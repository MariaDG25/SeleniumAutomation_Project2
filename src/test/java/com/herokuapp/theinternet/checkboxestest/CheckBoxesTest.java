package com.herokuapp.theinternet.checkboxestest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckBoxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckBoxesTest extends TestUtilities{
	
	@Test
	public void selectingTwoCheckboxesTest() {
		log.info("Starting selectionTwoCheckboxes test");
		
		//open main page
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		
		//opening checkBoxes page
		CheckBoxesPage checkBoxesPage = welcomePage.clickCheckBoxesPage();
		
		//select All Check Boxes
		log.info("Selecting checkboxes");
		checkBoxesPage.selectAllCheckbokex();
		
		//verify all check boxes are checked
		assertTrue(checkBoxesPage.verifyCheckBoxesChecked(), "Checkboxes are NOT checked");
	}

}
