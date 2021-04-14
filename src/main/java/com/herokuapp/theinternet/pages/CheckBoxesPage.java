package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage extends BasePageObject {

	private By checkboxLoc = By.xpath("input[@type='checkbox']");

	public CheckBoxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectAllCheckbokex() {
		List<WebElement> checkBoxes = findAll(checkboxLoc);
		for (WebElement checkBox : checkBoxes) {
			if(!checkBox.isSelected())
				checkBox.click();
		}
	}
	
	public boolean verifyCheckBoxesChecked() {
		boolean checked = true;
		List<WebElement> checkBoxes = findAll(checkboxLoc);
		for (WebElement checkBox : checkBoxes) {
			if(!checkBox.isSelected()) {
				checked = false;
			}
		}
		return checked;
	}

}
