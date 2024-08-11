package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nsf.ui.base.BrowserSetUp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class Listeners extends BrowserSetUp implements ITestListener {

//	Logger log = LogManager.getLogger(Listeners.class);
//	ExtentReports extent; // activate ;
//
//	@Override
//	public void onTestStart(ITestResult result) {
//
//		if (extent == null) {
//			extent = ExtentReportsConfiguration.getReportsConfiguration();
//		}
//		extent.createTest(result.getMethod().getMethodName());
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		extent.flush();
//
//	}

}
