package com.herokuapp.theinternet.pages;

import java.util.List;
import java.util.Set;
import java.util.Iterator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author María Dolz Explanation: the main object of this class is to gather
 *         all methods that use driver variable
 *
 */
public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	// open given URL
	protected void openURL(String url) {
		driver.get(url);
		log.info("Page opened successfully");
	}

	// find any element using its locator
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	// clicking on web element when it is visible
	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}

	// type given text when web element is visible
	protected void type(String txt, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(txt);
	}

	// wait for specific expected condition during a defined number of secods
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30; // It uses timeOutInSeconds value unless it
																				// is null, in this case it will assign
																				// 30 secs
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	// wait for given number of seconds for an element to be visible
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	// returns true if the element is displayed
	protected boolean elementDisplayed(By locator) {
		return find(locator).isDisplayed();
	}

	// get current URL from browser
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// get all the elements with the same locator
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	// waits for an alert to appear
	private void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// get text in Alert
	protected String getAlertText() {
		waitForAlert();
		return driver.switchTo().alert().getText();
	}

	// click on accept button in Alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// decline Alert
	protected void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	// type in PrompAlert
	protected void sendKeysAlert(String message) {
		waitForAlert();
		driver.switchTo().alert().sendKeys(message);
	}

	// get Window title in MultipleWindow & NewWindow
	public String getPageTitle() {
		return driver.getTitle();
	}

	// switch to iframe with an specific ID
	protected void switchIframe(String id) {
		driver.switchTo().frame(id);
	}

	// switch to default focus
	protected void switchFocusFrame() {
		driver.switchTo().defaultContent();
	}

	// switch to window with expected title
	protected void switchWindow(String expectedTitle) {
		// It will return the parent window name as a String
		String parentWdw = driver.getWindowHandle();
		Set<String> allWidw = driver.getWindowHandles();

		// Creating an iterator
		Iterator<String> windowIterator = allWidw.iterator();
		while (windowIterator.hasNext()) {
			String nextWidw = windowIterator.next().toString();
			if (!nextWidw.equals(parentWdw)) {
				driver.switchTo().window(nextWidw);
				if (getPageTitle().equals(expectedTitle))
					break;
			}
		}
	}

	// drag and drop operation
	protected void dragAndDrop(By from, By to) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				find(from), find(to));
	}

	// hover over elements
	protected void hoverOver(By element) {
		// instantiate Action Class
		Actions actions = new Actions(driver);
		// mouse hover element
		actions.moveToElement(find(element)).perform();
	}
}
