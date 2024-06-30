package com.TestProject.TestScipts;

import java.io.IOException;
import com.TestProject.PageObj.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.TestProject.Utilty.BrowserFact;
import com.TestProject.Utilty.Configurations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestCaseOne extends BrowserFact

{
	SignUpPage sgnPge;
	static ExtentReports extentRep;
	static ExtentTest log;
	static ExtentSparkReporter obj;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		String browser = Configurations.toGetProperty("Browser");
		String url = Configurations.toGetProperty("URL");

		BrowserFact.selectBrowser(browser, url);
		sgnPge = PageFactory.initElements(driver, SignUpPage.class);
		obj = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport.html");
		obj.config().setReportName("QAAutomtionTest");
		extentRep = new ExtentReports();
		extentRep.attachReporter(obj);
	}

	@Test
	public void testCompleteFlow() throws IOException {
		try {
			log = extentRep.createTest("Navigate to SauceLabs and Signup");
			String verificationValue = Configurations.toGetProperty("ButtonTest");
			// test whether given button name in property file exists in the home page
			sgnPge.listOfMenuItems(verificationValue);
			log.pass("One Scenario tested");
			// test sign up functionality
			String uName = Configurations.toGetProperty("username");
			String password = Configurations.toGetProperty("password");
			String ErrorMsg = Configurations.toGetProperty("ErrorMsg");
			sgnPge.signUpValidationCheck(uName, password, ErrorMsg);
			log.pass("Test Passed");
		} catch (Exception e) {
			log.fail("reason for failure" + e);
		}
	}

	@AfterMethod
	public void afterMethod() {
		BrowserFact.quitBrowser();
		extentRep.flush();
	}
}
