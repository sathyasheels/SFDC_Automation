package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import listeners.SfdcListeners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

@Listeners(SfdcListeners.class)
public class UserMenuTest extends BaseTest {
	
	WebDriver driver;
	@Test(enabled=false)
	public void userMenuDropdownValidate_tc05() throws IOException {
		
		WebDriver driver=BaseTest.getBrowserType("edge");
		LoginPage lp=new LoginPage(driver);
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		lp.username.sendKeys(FileUtils.readTestData("test.username"));
		lp.password.sendKeys(FileUtils.readTestData("test.password"));
		lp.loginButton.click();
		//lp.savedUsername.click();
		UserMenuPage uMenu=new UserMenuPage(driver);
		if(uMenu.userMenu.isDisplayed()){
			System.out.println("User menu drop down is displayed");
		}else
			System.out.println("User menu drop down is not displayed");
		uMenu.userMenu.click();
		ArrayList<WebElement> li=new ArrayList<WebElement>();
		li.add(uMenu.myProfile);li.add(uMenu.mySettings);li.add(uMenu.developerConsole);li.add(uMenu.lightningExperience);li.add(uMenu.logout);
		int count=0;
		for(WebElement web:li) {
		if(web.isDisplayed())
		{count++;
		}
		}
		if(count==5)
			System.out.println("All user menu drop downs are displayed correctly");
		    System.out.println("Test case 5 ran sucessfully");
		//uMenu.myProfile.click();
		}
	
	@BeforeMethod
	public void preRequisite() throws IOException
	{
		driver=BaseTest.getBrowserType("edge");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
	
	
	
	@Test(enabled=false)
	public void selectUserMenu_TC05() throws IOException {
		UserMenuPage ump=new UserMenuPage(driver);
		Assert.assertTrue(ump.verifyHomePage(),"Failed to verify Home page");
		if(CommonUtils.waitForElementToBeClickable(driver,ump.userMenu)) {
			ump.userMenu.click();
		}
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify UserMenu options");
	}
	
	
	@Test(enabled=false)
	public void selectMyProfile_TC06() throws IOException{
		UserMenuPage ump=new UserMenuPage(driver);
		if(CommonUtils.waitForElementToBeClickable(driver,ump.userMenu)) {
			ump.userMenu.click();
		}
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify UserMenu options");
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option1"));
		Assert.assertTrue(ump.isMyProfilePagedisplayed(),"Failed to load My profile page");
		ump.selectEditContactIcon(driver);
		Assert.assertTrue(ump.verifyEditProfileframe(driver),"Failed to verify edit profile iframe");
		Assert.assertTrue(ump.verifyLastNameChangeInMyProfilePage(driver, FileUtils.readUserMenuData("new.lastname")),"Failed to change lastname");
		Assert.assertTrue(ump.verifyPostCreated(driver,FileUtils.readUserMenuData("message.topost")),"Failed to createpost");
		Assert.assertTrue(ump.verifyFileUploaded(driver, FileConstants.PATH_OF_FILE_TO_POST),"Failed to upload file");
		Assert.assertTrue(ump.verifyPhotoUploaded(driver, FileConstants.PATH_OF_PHOTO_TO_ADD), "Failed to add photo");
	}
	
	
	@Test(enabled=false)
	public void selectMySettings_TC07() throws IOException {
		UserMenuPage ump=new UserMenuPage(driver);
		if(CommonUtils.waitForElementToBeClickable(driver,ump.userMenu)) {
			ump.userMenu.click();
		}
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify UserMenu options");
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option2"));
		Assert.assertTrue(ump.isMySettingsPagedisplayed(),"Failed to load MySettings page");
		Assert.assertTrue(ump.verifyLoginHistoryDisplayed(driver),"Failed to load login history page");
		Assert.assertTrue(ump.verifyReportsFieldAdded(driver, FileUtils.readUserMenuData("content.option"),FileUtils.readUserMenuData("available.option")));
		ump.userMenu.click();
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option2"));
		Assert.assertTrue(ump.verifyEmailSettingsMessage(driver,FileUtils.readUserMenuData("email.name"),
				FileUtils.readUserMenuData("email.address"), FileUtils.readUserMenuData("email.message")));
		ump.userMenu.click();
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option2"));
		Assert.assertTrue(ump.verifyRemainderPopupWindow(driver),"Failed to switch to pop up window");
		
	}
	@Test
	public void selectDeveloperConsole_TC08(Method name) throws IOException {
		//test=extent.createTest(name.getName()); this can be removed after creating onTestStart method in SfdcListeners class
		UserMenuPage ump=new UserMenuPage(driver);
		if(CommonUtils.waitForElementToBeClickable(driver,ump.userMenu)) {
			ump.userMenu.click();
		}
		logger.info("Test case-8 usermenu option is clicked");
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify UserMenu options");
		threadLocalExtentTest.get().info("UserMenu items verified");
		logger.info("Test case-8 Usermenu items verified");
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option3"));
		//test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
		threadLocalExtentTest.get().info("Developer console option selected");
		logger.info("Test case-8 Developer console option is selected");
		Assert.assertTrue(ump.verifyDeveloperConsoleWindow(driver),"Failed to verify Developer console window");
		threadLocalExtentTest.get().info("Developer console window opened");
		logger.info("Test case-8 is working as expected");
		//test.pass(name.getName()+" passed"); this can be removed after creating onTestSuccess method in SfdcListeners class
	}
	
	@Test
	public void selectLogout_TC09(Method name) throws IOException {
		UserMenuPage ump=new UserMenuPage(driver);
		if(CommonUtils.waitForElementToBeClickable(driver,ump.userMenu)) {
			ump.userMenu.click();
		}
		logger.info("Test case 9-Usermenu is clicked");
		threadLocalExtentTest.get().info("Usermenu option is clicked");
		ump.selectUserMenuOption(driver,FileUtils.readUserMenuData("userMenu.items.option5"));
		threadLocalExtentTest.get().info("Logout option selected");
		logger.info("Test case 9-Logout option is selected");
		Assert.assertTrue(ump.verifyLoginPageDisplayed(driver,FileUtils.readUserMenuData("expected.title")),"Failed to verify logout");
		threadLocalExtentTest.get().info("Login Page is displayed");
		logger.info("Test case 9 is successfully executed");
		//Assert.assertTrue(false);
	}
	
}
