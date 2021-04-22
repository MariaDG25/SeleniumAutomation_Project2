package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverPage extends BasePageObject {
	private By avatar = By.className("figure");
	private By linkOpenProfile = By.xpath(".//a[contains(text(),'View profile')]");
	private By newPagetext = By.xpath("//h1");
	
	private String urlUser = "http://the-internet.herokuapp.com/users/";
	private int userSelected = 0;
	public HoverPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//hover over specific avatar and click on View Profile
	public void openUserProfile(int i) {
		userSelected = i;
		List<WebElement> avatars = findAll(avatar);
		WebElement specificAvatar = avatars.get(i-1);
		hoverOver(specificAvatar);
		click(linkOpenProfile);
	}
	
	//return current URL
	public String getCUrl() {
		return getCurrentUrl();
	}
	
	//return expected URL
	public String getExpectedURL() {
		return urlUser + userSelected;
	}
	
	//return h1 text
	public String getNewPagetext() {
		return find(newPagetext).getText();
	}

}
