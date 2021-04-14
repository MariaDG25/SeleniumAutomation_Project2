package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest{

	//static sleep (not recommended)
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
