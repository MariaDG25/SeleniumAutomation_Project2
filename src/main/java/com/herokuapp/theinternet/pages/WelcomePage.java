package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author María Dolz Explanation: this pages includes the relevant functions
 *         for the first page in the application (welcome page)
 *
 */
public class WelcomePage extends BasePageObject {

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkBoxesLink = By.linkText("Checkboxes");
	private By dropDownLink = By.linkText("Dropdown");
	private By jsAlertLink = By.linkText("JavaScript Alerts");
	private By multipleWdw = By.linkText("Multiple Windows");
	private By iFrameLink = By.linkText("WYSIWYG Editor");
	private By keyPressesLink = By.linkText("Key Presses");
	private By fileUplink = By.linkText("File Upload");
	private By dropAndDraglink = By.linkText("Drag and Drop");
	private By hoversLink = By.linkText("Hovers");

	private String url = "http://the-internet.herokuapp.com/";

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// opening Welcome page with URL
	public void openPage() {
		log.info("Opening Welcome Page");
		openURL(url);
		log.info("Page opened successfully");
	}

	// opening Login Page by clicking on Form Authentication link
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking on Form link >>>> Opening Log in page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}

	// open Checkboxes page by clicking on checkboxes Link
	public CheckBoxesPage clickCheckBoxesPage() {
		log.info("Clicking on CheckBoxes link >>>> Opening CheckBoxes page");
		click(checkBoxesLink);
		return new CheckBoxesPage(driver, log);
	}

	// open Dropdown page by clicking on Dropdown Link
	public DropdownPage clickDropdownPage() {
		log.info("Clicking on Dropdown link >>>> Opening Dropdown page");
		click(dropDownLink);
		return new DropdownPage(driver, log);
	}

	// open Alerts page by clicking on JavaScript Alerts Link
	public AlertsPage clickJsAlert() {
		log.info("Clicking on JavaScript Alerts link >>>> Opening JavaScript Alerts page");
		click(jsAlertLink);
		return new AlertsPage(driver, log);
	}

	// open Multiple Windows page by clicking on Alerts Link
	public MultipleWindowsPage clickMultipleWindowsPage() {
		log.info("Clicking on Multiple Windows link >>>> Opening Multiple Windows page");
		click(multipleWdw);
		return new MultipleWindowsPage(driver, log);
	}

	// open WYSIWYG page by clicking on WYSIWYG Editor link
	public IFramePage clickIFramePage() {
		log.info("Clicking on WYSIWYG Editor link >>>> Opening WYSIWYG Editor page");
		click(iFrameLink);
		return new IFramePage(driver, log);
	}

	// open Key Presses page by clicking on Key Presses Link
	public KeyPressesPage clickKeyPressesPage() {
		log.info("Clicking on Key Presses link >>>> Opening Key Presses page");
		click(keyPressesLink);
		return new KeyPressesPage(driver, log);
	}

	// open File Upload page by clicking on File Upload Link
	public FileUploaderPage FileUploaderPage() {
		log.info("Clicking on File Upload link >>>> Opening File Upload page");
		click(fileUplink);
		return new FileUploaderPage(driver, log);
	}

	// scroll down to the bottom
	public void scrollDown() {
		log.info("Scrolling to the bottom of the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// open Drag and Drop page by clicking on Drag and Drop Link
	public DragandDropPage DragandDropPage() {
		log.info("Clicking on Drag and Drop link >>>> Opening Drag and Drop page");
		click(dropAndDraglink);
		return new DragandDropPage(driver, log);
	}
	
	// open Hovers page
	public HoverPage HoverPage() {
		log.info("Clicking on Hovers link >>>> Opening Hovers page");
		click(hoversLink);
		return new HoverPage(driver, log);
	}
}
