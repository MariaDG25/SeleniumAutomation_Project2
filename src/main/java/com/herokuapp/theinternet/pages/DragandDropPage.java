package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragandDropPage extends BasePageObject {
	private By boxA = By.xpath("//div[@id='column-a']");
	private By boxB = By.xpath("//div[@id='column-b']");
	private By boxAheader = By.xpath("//div[@id='column-a']//header");

	public DragandDropPage(WebDriver driver, Logger log) {
		super(driver, log);

	}

	// From A to B
	public void dragAndDropAtoB() {
		dragAndDrop(boxA, boxB);
	}

	// From B to A
	public void dragAndDropBtoA() {
		dragAndDrop(boxB, boxA);
	}

	// get box A header text
	public String getAheader() {
		return find(boxAheader).getText();
	}

}
