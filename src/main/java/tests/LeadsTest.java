package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LeadsPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;

public class LeadsTest extends BaseTest{
private WebDriver driver;

@BeforeMethod
public void preRequisite() throws IOException
{
	driver=BaseTest.getBrowserType("edge");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(driver);
}

@Test(enabled=false)
public void selectLeadsTab_TC20() {
	LeadsPage lp=new LeadsPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to verify Leads Page");
}


@Test(enabled=false)
public void validateViewDropdown_TC21() throws IOException {
	LeadsPage lp=new LeadsPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to verify Leads Page");
	Assert.assertTrue(lp.verifyLeadsDropdown(),"Failed to validate leads dropdown list");
}

@Test
public void validateDefaultView_TC22() throws IOException {
	LeadsPage lp=new LeadsPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to verify Leads Page");
	Assert.assertTrue(lp.verifyTodaysLeads(driver, FileUtils.readLeadsData("expected.title")),"Failed to load home page");
	LoginPage l=new LoginPage(driver);
	l.loginToApp(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to display leads home page");
	Assert.assertTrue(lp.verifyDefaultView1(),"Failed to verify default view");
}



@Test(enabled=false)
public void validateTodayLeadsPage_TC23() throws IOException {
	LeadsPage lp=new LeadsPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to verify Leads Page");
	Assert.assertTrue(lp.verifyTodayLeadsPage(),"Failed to verify Today Leads page");
	
}


@Test(enabled=false)
public void validateNewLeadCreated_TC24() throws IOException {
	LeadsPage lp=new LeadsPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,lp.leadsTab)) {
		lp.leadsTab.click();
	}
	Assert.assertTrue(lp.verifyLeadsHomePageDisplayed(),"Failed to verify Leads Page");
	Assert.assertTrue(lp.verifyNewLeadPageDisplayed(),"Failed to verify new lead page");
	Assert.assertTrue(lp.verifyNewLeadCreated(driver,FileUtils.readLeadsData("newlead.lastname"), 
			FileUtils.readLeadsData("newlead.companyname")),"Failed to verify newly created lead");
}







}
