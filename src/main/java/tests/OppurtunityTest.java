package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.OppurtunityPage;
import utils.CommonUtils;
import utils.FileUtils;

public class OppurtunityTest extends BaseTest{
private WebDriver driver;

@BeforeMethod
public void preRequisite() throws IOException
{
	driver=BaseTest.getBrowserType("edge");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(driver);
}

@Test(enabled=true)
public void selectOppurtunity_TC15() throws IOException {
	OppurtunityPage op=new OppurtunityPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,op.oppurtunitiesTab)) {
		op.oppurtunitiesTab.click();
	}
	Assert.assertFalse(op.verifyOpportunityHomePage(),"Failed to verify Oppurtunity Home Page");
	Assert.assertTrue(op.verifyViewOppurtunityDropDown(), "Failed to verify view drop down");
}

@Test(enabled=true)
public void createNewOppurtunity_TC16() throws IOException {
	OppurtunityPage op=new OppurtunityPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,op.oppurtunitiesTab)) {
		op.oppurtunitiesTab.click();
	}
	Assert.assertTrue(op.verifyOpportunityHomePage(),"Failed to verify Oppurtunity Home Page");
	Assert.assertTrue(op.verifyNewOppurtunityPageDisplayed(driver, FileUtils.readOppurtunityData("oppurtunity.name"), 
			FileUtils.readOppurtunityData("close.date"), FileUtils.readOppurtunityData("stagedropdown.option"),
			FileUtils.readOppurtunityData("probability"),FileUtils.readOppurtunityData("leadsourcedropdown.option")));
	}

@Test(enabled=true)
public void testOpportunityPipeline_TC17() {
	OppurtunityPage op=new OppurtunityPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,op.oppurtunitiesTab)) {
		op.oppurtunitiesTab.click();
	}
	Assert.assertTrue(op.verifyOpportunityPipelineReportPage(driver),"Failed to verify pipeline report page");
}


@Test(enabled=false)
public void testStuckOpportunity_TC18() {
	OppurtunityPage op=new OppurtunityPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,op.oppurtunitiesTab)) {
		op.oppurtunitiesTab.click();
	}
	Assert.assertTrue(op.verifystuckOpportunityReportPage(driver),"Failed to verify pipeline report page");
}

@Test(enabled=false)
public void testQuarterlySummaryReport_TC19() throws IOException {
	OppurtunityPage op=new OppurtunityPage(driver);
	if(CommonUtils.waitForElementToBeClickable(driver,op.oppurtunitiesTab)) {
		op.oppurtunitiesTab.click();
		}
	Assert.assertTrue(op.verifyQuarterlySummaryReportPageDisplayed(driver, FileUtils.readOppurtunityData("intervaldropdown.option"), 
			FileUtils.readOppurtunityData("includedropdown.option")),"Failed to create Quarterly summary Report");
}










}
