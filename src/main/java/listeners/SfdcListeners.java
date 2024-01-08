package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SfdcListeners implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		BaseTest.test=BaseTest.extent.createTest(result.getName()); //test and extent objects are defined in the BaseTest class
		BaseTest.threadLocalExtentTest.set(BaseTest.test);
	}
	
	
	public void onTestSuccess(ITestResult result) {
		//BaseTest.test.pass("Passed" +result.getName());
		//BaseTest.test.pass(MarkupHelper.createLabel("Passed" +result.getName(),ExtentColor.GREEN));
		BaseTest.threadLocalExtentTest.get().pass(MarkupHelper.createLabel(result.getName()+" -Passed",ExtentColor.GREEN));
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		BaseTest.threadLocalExtentTest.get().addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		//BaseTest.test.fail("Failed" +result.getName());
		//BaseTest.test.fail(MarkupHelper.createLabel("Failed" +result.getName(),ExtentColor.RED));
		BaseTest.threadLocalExtentTest.get().fail(MarkupHelper.createLabel(result.getName()+" -Failed",ExtentColor.RED));
		

	}

}
