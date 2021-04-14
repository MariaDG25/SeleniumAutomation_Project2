package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {
	private By title = By.xpath("//div[@class='example']//child::h3[text()='Opening a new window']");
	private By linkNewWindw = By.linkText("Click Here");

	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public String getPageTitleText() {
		return find(title).getText();
	}

	// open a new window
	public NewWindowPage clickNewWindowsPage() {
		log.info("Clicking on Click Here >>>> Opening a new Window");
		click(linkNewWindw);
		log.info("switching to new window");
		switchWindow("New Window");
		return new NewWindowPage(driver, log);
	}
}
