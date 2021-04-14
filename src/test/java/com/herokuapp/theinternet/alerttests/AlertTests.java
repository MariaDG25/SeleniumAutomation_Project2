package com.herokuapp.theinternet.alerttests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.AlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertTests extends TestUtilities{
	
	@Test(priority = 1)
	private void AlertTestsJS() {
		String message = "any message";
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		//open main page
		welcomePage.openPage();
		
		//click on Alerts link
		final AlertsPage alerts = welcomePage.clickJsAlert();
		
		//click on JSAlert
		alerts.openJsAlert("jsAlert");
		
		//verify text in Alert is the expected 
		assertTrue(alerts.getalertText().contains("I am a JS Alert"), "Text does not match with the expected one");
		
		//close alert clicking on Accept
		alerts.acceptAlert();
		
		//click on JSConfirm
		alerts.openJsAlert("jsConfirm");
		
		//verify text in Alert is the expected 
		assertTrue(alerts.getalertText().contains("I am a JS Confirm"), "Text does not match with the expected one");
		
		//close alert clicking on Accept
		alerts.acceptAlert();
		
		//click on jsPrompt
		alerts.openJsAlert("jsPrompt");
		
		//type in text field when alert is open
		alerts.sendKeysPromptAlert(message);
		
		//accept alert
		alerts.acceptAlert();
				
		//verify result text is the expected 
		assertTrue(alerts.getResultText().contains(message), "Text does not match with the expected one");
	}

}
