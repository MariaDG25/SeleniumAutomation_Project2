package com.herokuapp.theinternet.fileuploadtest;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class FileUploadTest extends TestUtilities {

	@Test
	public void FileUploadingTest() throws AWTException {
		final WelcomePage welcomePage = new WelcomePage(driver, log);
		
		// open main page
		welcomePage.openPage();

		// open File Upload page
		FileUploaderPage fileUpload = welcomePage.FileUploaderPage();
		// upload file
		fileUpload.sendFileSource();

		// verify document is uploaded
		Assert.assertTrue(fileUpload.currentFileName().contains(fileUpload.getfileName()),
				"the document is not as expected");
	}

}
