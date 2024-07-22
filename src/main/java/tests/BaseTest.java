package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class BaseTest {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static WebDriver driver;
	private static ThreadLocal<WebDriver> threadLocaldriver=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadLocalExtentTest=new ThreadLocal<ExtentTest>();
	public static Logger logger=LogManager.getLogger();
	
	@BeforeSuite	
	public void configuration() {
		extent=new ExtentReports();
		ExtentSparkReporter report=new ExtentSparkReporter(FileConstants.REPORTS_FOLDER_PATH);
		extent.attachReporter(report);
	}
	
	@AfterSuite
	public void flushmethodForCreatingReports() {
		extent.flush();
	}
	
	
	public static WebDriver getBrowserType(String browserName) {
		
		WebDriver driver;
		String browser=browserName.toLowerCase();
		switch(browser)
		{
		case "chrome":
			driver=new ChromeDriver();
			ChromeOptions co=new ChromeOptions();
			Cookie cookie=new Cookie(browser, browser);
		
			logger.info("Chrome browser is configured");
			break;
		case "firefox":
			driver=new FirefoxDriver();
			logger.info("firefox browser is configured");
			break;
		case "edge":
			driver=new EdgeDriver();
			logger.info("Edge browser is configured");
			break;
		default:
			driver=null;
			logger.info("Invalid browser input is provided");
			break;
		}
		
		return driver;
		
	}
	public static void setDriver(String bname) {
		WebDriver driver=BaseTest.getBrowserType(bname);
		threadLocaldriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return threadLocaldriver.get();
	}
	
	
	@AfterMethod(enabled=false)
	public static void removedriver() {
		BaseTest.getDriver().close();
		threadLocaldriver.remove();
		threadLocalExtentTest.remove();
	}
	
	
	
	
	
	
	
	

}
