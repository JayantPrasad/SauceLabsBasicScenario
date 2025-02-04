package com.TestProject.PageObj;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.TestProject.Utilty.BrowserFact;

public class SignUpPage extends BrowserFact {

	@FindBy(xpath = "//button")
	static List<WebElement> Buttons;

	@FindBy(xpath = "//button[contains(text(),'Try it free')]")
	static WebElement SignUpBtn;
	@FindBy(xpath = "//*[contains(text(),'Sign up with GitHub')]")
	static WebElement GitHubBtn;
	@FindBy(xpath = "//input[@type='submit']")
	static WebElement LoginBtn;
	@FindBy(xpath = "//*[contains(text(),'Incorrect username or password.']")
	static WebElement errorMsg;
	@FindBy(id = "login_field")
	static WebElement uNameTxtField;
	@FindBy(id = "password")
	static WebElement pssWordTxtField;

	public void listOfMenuItems(String verificationValue) throws IOException {

		for (WebElement w : Buttons) {
			if (w.getText().equalsIgnoreCase(verificationValue)) {
				SoftAssert sf = new SoftAssert();
				sf.assertAll("Test is working as expected");
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File screenshotLocation = new File("C:\\Test\\TestSauceLabs\\ScreenShots\\HomePagescreenshot.png");
				FileUtils.copyFile(screenshot, screenshotLocation);
				break;
			}
		}

	}

	public void signUpValidationCheck(String uName, String password, String ErrorMsg) throws IOException {
		SoftAssert sf = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		SignUpBtn.isDisplayed();
		SignUpBtn.click();
		GitHubBtn.click();
		Set<String> windows=driver.getWindowHandles();
		java.util.Iterator<String> i=windows.iterator();
		i.next();
		uNameTxtField.sendKeys(uName);
		pssWordTxtField.sendKeys(password);
		LoginBtn.click();
		errorMsg.isDisplayed();
		String msg = errorMsg.getText();
		if (msg.equalsIgnoreCase(ErrorMsg)) {
			sf.assertAll("Test is working as expected");
		} else {
			sf.assertAll("Test is not working as expected");
		}
	}
}
