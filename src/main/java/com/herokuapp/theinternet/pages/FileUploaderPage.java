package com.herokuapp.theinternet.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {
	private By uploadInput = By.xpath("//input[@id='file-upload']");
	private By submitInput = By.xpath("//input[@id='file-submit']");
	private String fileSource = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\stellae.jpg";
	private By fileName = By.xpath("//div[@id='uploaded-files']");
	private Robot robot;

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void sendFileSource() throws AWTException {
		click(uploadInput);
		type(fileSource, uploadInput);
		switchFocusFrame();
		click(submitInput);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public String currentFileName() {
		return find(fileName).getText();
	}

	public String getfileName() {
		return "stellae.jpg";
	}

}
