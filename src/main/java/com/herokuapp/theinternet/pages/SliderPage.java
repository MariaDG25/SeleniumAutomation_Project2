package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SliderPage extends BasePageObject{
	private By slider = By.xpath("//input[@type='range']");
	private By sliderValuetxt = By.xpath("//span[@id='range']");

	public SliderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//move slider to a value
	public void selectSliderValue(int to) {
		dragAndDropSlider(slider, to);
	}
	
	//return slider current value
	public String getSliderValuetxt() {
		return find(sliderValuetxt).getText();
	}

}
