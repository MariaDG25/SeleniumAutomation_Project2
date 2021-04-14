package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoverPage extends BasePageObject {
	private By userImg1 = By.xpath("//div[@class='figure'][1]");
	private By userImg2 = By.xpath("//div[@class='figure'][2]");
	private By userImg3 = By.xpath("//div[@class='figure'][3]");
	private By user1name = By.xpath("//div[@class='figure'][1]//h5");
	private By user2name = By.xpath("//div[@class='figure'][2]//h5");
	private By user3name = By.xpath("//div[@class='figure'][3]//h5");
	private int userNo = 0;

	public HoverPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// hover over element
	public void hoverOverElement(int num) {
		switch (num) {
		case 1:
			hoverOver(userImg1);
			break;
		case 2:
			hoverOver(userImg2);
			break;

		case 3:
			hoverOver(userImg3);
			break;

		default:
			break;
		}
		userNo = num;
	}

	// get user name
	public String getUserName() {
		String userName = "";
		switch (userNo) {
		case 1:
			userName = find(user1name).getText();
			break;
		case 2:
			userName = find(user2name).getText();
			break;

		case 3:
			userName = find(user3name).getText();
			break;

		default:
			break;
		}

		return userName;
	}

}
