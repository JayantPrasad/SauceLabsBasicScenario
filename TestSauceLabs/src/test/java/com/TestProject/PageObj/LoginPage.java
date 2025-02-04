package com.TestProject.PageObj;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.TestProject.Utilty.BrowserFact;

public class LoginPage extends BrowserFact {

	@FindBy(xpath = "//button")
	static List<WebElement> Buttons;

	public void listOfMenuItems() throws IOException {

		for (WebElement w : Buttons) {
			if (w.getText().equalsIgnoreCase("Sign in")) {
				SoftAssert sf = new SoftAssert();
				sf.assertAll("Test is working as expected");
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File screenshotLocation = new File("C:\\Test\\TestSauceLabs\\ScreenShots\\HomePagescreenshot.png");
				FileUtils.copyFile(screenshot, screenshotLocation);
				break;
			}
		}

	}
}
