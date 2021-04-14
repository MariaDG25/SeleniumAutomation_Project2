package com.herokuapp.theinternet.draganddroptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragandDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragandDropTest extends TestUtilities {

	@Test
	public void selectOptionDropdown() {
		log.info("Starting DragandDropTest test");

		// open main page
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// open Drag and Drop page
		final DragandDropPage dragDrop = welcomePage.DragandDropPage();

		// drag and drop A to B
		dragDrop.dragAndDropAtoB();
		log.info("AHI VA" + dragDrop.getAheader());
		// check now column-a has header text 'B'
		Assert.assertTrue(dragDrop.getAheader().contains("B"), "The header text is not the expected");

		// drag and drop B to A
		dragDrop.dragAndDropBtoA();

		// check now column-a has header text 'B'
		Assert.assertTrue(dragDrop.getAheader().contains("A"), "The header text is not the expected");
	}
}
