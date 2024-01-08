package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RanScenariosPage;
import utils.FileUtils;

public class RanScenariosTest extends BaseTest{
	private WebDriver driver;

	@BeforeMethod
	public void preRequisite() throws IOException
	{
		driver=BaseTest.getBrowserType("edge");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
	@Test(enabled=false)
	public void checkMyProfilePageSameasFirstnameLastnameLinkpage_TC33() {
		RanScenariosPage sp=new RanScenariosPage(driver);
		Assert.assertTrue(sp.verifyHomePageDisplayed(),"failed to verify Home page");
		Assert.assertTrue(sp.verifyFirstnameLastnameLinkPageDisplayed(),"Failed to verify firstname lastname link page");
	}

	
	@Test(enabled=false)
	public void checkEditedLastnameUpdated_TC34() throws IOException {
		RanScenariosPage sp=new RanScenariosPage(driver);
		Assert.assertTrue(sp.verifyHomePageDisplayed(),"failed to verify Home page");
		Assert.assertTrue(sp.verifyEditProfilePopupdisplayed(driver),"failed to verify edit profile popup");
		Assert.assertTrue(sp.verifyUpdatedLastnameDisplayed(driver, FileUtils.readRanScenariosData("newLastname")));
	}
	
	
	@Test
	public void chechTabCustomization_TC35() throws IOException {
		RanScenariosPage sp=new RanScenariosPage(driver);
		Assert.assertTrue(sp.verifyCustomizeMyTabPageDispalyed(),"Failed to verify customize my tabs page");
		Assert.assertTrue(sp.verifyRemovedTabOptionNotDisplayed(driver, FileUtils.readRanScenariosData("selecteddropdownoption")));
	}
	
	
	@Test(enabled=false)
	public void checkEventBlockingInCalendar_TC36() throws IOException {
		RanScenariosPage sp=new RanScenariosPage(driver);
		Assert.assertTrue(sp.verfiyCurrentDateDispalyed(driver));
		Assert.assertTrue(sp.verifyCalendarNewEventPageDisplayed());
		Assert.assertTrue(sp.verifyComboboxPopupClosed(driver,FileUtils.readRanScenariosData("expectedText.SubjectDropdown")));
		Assert.assertTrue(sp.verifyEndTimeDropdownOptionsdisplayed());
		Assert.assertTrue(sp.verifyCorrespondingEventBlockedInTimeSlot());
	}
	
	
	@Test(enabled=false)
	public void checkEventBlockingInCalendarWeeklyRecurrence_TC37() throws IOException {
		RanScenariosPage sp=new RanScenariosPage(driver);
		Assert.assertTrue(sp.verfiyCurrentDateDispalyed(driver));
		Assert.assertTrue(sp.verifyCalendarNewEventPageDisplayedwithStarttimeFourPM());
		Assert.assertTrue(sp.verifyComboboxPopupClosed(driver,FileUtils.readRanScenariosData("expectedText.SubjectDropdown")));
		Assert.assertTrue(sp.verifyEndTimeDropdownOptionsdisplayed());
		Assert.assertTrue(sp.verifyCorrespondingEventBlockedInTimeSlotForFourToSixPM(driver, FileUtils.readRanScenariosData("month.option"), 
				FileUtils.readRanScenariosData("year.option"),FileUtils.readRanScenariosData("date.option")));
		
	}
	
	
	
	
	
	
	
	
	
	
}
