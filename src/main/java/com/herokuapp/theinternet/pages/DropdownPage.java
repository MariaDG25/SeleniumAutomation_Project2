package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject{
	
	private By dropdownLoc = By.id("dropdown");

	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//select option in dropdown
	public void selectOption(int op) {
		log.info("Selecting option " + op);
		Select dropDown = new Select(find(dropdownLoc));
		dropDown.selectByIndex(op);
	}
	
	//verify option selected
	public String getOptionSelected() {
		Select dropDown = new Select(find(dropdownLoc));
		return dropDown.getFirstSelectedOption().getText();	
	}

}
