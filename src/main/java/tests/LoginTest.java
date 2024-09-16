package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.SfdcListeners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;

@Listeners(SfdcListeners.class)
public class LoginTest extends BaseTest{
	

	@Test
	public void checkErrorMessage_TC01(Method name) throws IOException
	{
		BaseTest.setDriver("edge");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		threadLocalExtentTest.get().info("Login page is displayed");
		Assert.assertTrue(lp.verifyErrorMessageOngivingInvalidPassword(FileUtils.readTestData("test.username"), 
				FileUtils.readTestData("test.invalidpassword"), FileUtils.readTestData("expected.errormessage")));
	}
	
	
	@Test
	public void checkLoginToSfdc_TC02(Method name) throws IOException {
		
		BaseTest.setDriver("edge");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		threadLocalExtentTest.get().info("Login page is displayed");
		Assert.assertTrue(lp.verifyLoginSuccessful(FileUtils.readTestData("test.username"), FileUtils.readTestData("test.password")));
	}

	@Test
	public void checkRemembermeCheckBox_TC03(Method name) throws IOException
	{
		BaseTest.setDriver("edge");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		threadLocalExtentTest.get().info("Login page is displayed");
		Assert.assertTrue(lp.verifyLoginSuccessfulWithRemembermeChecked(FileUtils.readTestData("test.username"), FileUtils.readTestData("test.password")));
		threadLocalExtentTest.get().info("Remember me check box is checked on Login");
		Assert.assertTrue(lp.verifyRemembermeCheckedOnLogout(FileUtils.readTestData("test.username")));
		threadLocalExtentTest.get().info("Remember me check box is already selected on Log out");
		Assert.assertFalse(lp.verifySavedUsernameMessageDisplayed(FileUtils.readTestData("username.message")));
		
	}
	
	@Test(enabled=false)
	public void checkForgotPassword_TC4A(Method name) throws IOException
	{
		BaseTest.setDriver("edge");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		threadLocalExtentTest.get().info("Login page is displayed");
		Assert.assertTrue(lp.verifyForgotPasswordPageDisplayed());
		threadLocalExtentTest.get().info("forgot password page is displayed");
		Assert.assertTrue(lp.verifyCheckYourEmailPageDisplayed(FileUtils.readTestData("test.username")));
		
	}
	
	
	@Test(enabled=false)
	public void checkErrorMessageWithBothInvalidUsernamePassword_TC4B(Method name) throws IOException {
		BaseTest.setDriver("edge");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		threadLocalExtentTest.get().info("Login page is displayed");
		Assert.assertTrue(lp.verifyErrorMessageForInvalidUsernamePasswordDisplayed(FileUtils.readTestData("test.invalidusername"),
				FileUtils.readTestData("test.invalidpassword"), FileUtils.readTestData("expected.errormessage2")));
		threadLocalExtentTest.get().info("Error message is displayed");
	}
	
	
	
}
