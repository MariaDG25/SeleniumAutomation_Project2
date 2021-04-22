package com.herokuapp.theinternet.slidertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.SliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class SliderTest extends TestUtilities {

	@Test
	public void horizontalSliderTest() {

		final WelcomePage welcomePage = new WelcomePage(driver, log);
		int value = 5;

		// open main page
		welcomePage.openPage();
		
		//open Horizontal Slide page
		final SliderPage slider = welcomePage.SliderPage();
		
		//move slider pointer
		value = 5;
		slider.selectSliderValue(value); 
		Assert.assertTrue(slider.getSliderValuetxt().contains("" + (value*0.5)), "Slider value is not as expected - " + " EXPECTED VALUE: " + (value*0.5) + " CURRENT VALUE: " + slider.getSliderValuetxt());
		
	}

}
