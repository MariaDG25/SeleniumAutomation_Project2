package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePageObject {

	private By frameContent = By.xpath("//body[@id='tinymce']//child::p");
	
	public IFramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	//focus on IFrame Editor
	public String getContentiFrame() {
		switchIframe("mce_0_ifr");
		return find(frameContent).getText();
	}
	//switching focus to parent node
	public void switchFocus() {
		log.info("Switching to parent node");
		switchFocusFrame();
	}
}
