package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.ContactsPage;
import pages.LoginPage;
import utils.FileUtils;

public class AccountTest extends BaseTest{
	private WebDriver driver;

	@BeforeMethod
	public void preRequisite() throws IOException
	{
		driver=BaseTest.getBrowserType("edge");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
	@Test(enabled=false)
	public void createAccount_TC10() throws IOException {
		AccountPage ap=new AccountPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(ap.verifyUserNameInHomePage(),"Failed to verify Home Page");
		Assert.assertTrue(ap.verifyAccountPageDisplayed(FileUtils.readAccountData("expected.accountname"),
				FileUtils.readAccountData("typedropdown.option"), FileUtils.readAccountData("customerprioritydropdown.option")));
	}
	
	
	@Test(enabled=false)
	public void createNewView_TC11() throws IOException {
		AccountPage ap=new AccountPage(driver);
		Assert.assertTrue(ap.verifyUserNameInHomePage(),"Failed to verify Home Page");
		Assert.assertTrue(ap.verifyNewViewDisplayed(driver, FileUtils.readAccountData("account.viewname"), 
				FileUtils.readAccountData("account.uniqueviewname")));
	}
	
	@Test(enabled=false)
	public void editView_TC12() throws IOException {
		AccountPage ap=new AccountPage(driver);
		Assert.assertTrue(ap.verifyUserNameInHomePage(),"Failed to verify Home Page");
		Assert.assertTrue(ap.verifyEditViewPageDisplayed(FileUtils.readAccountData("old.viewname")));
		Assert.assertTrue(ap.verifyNewViewUpdated(driver, FileUtils.readAccountData("new.viewname"),
				FileUtils.readAccountData("fielddropdown.option"), FileUtils.readAccountData("operatordropdown.option"), 
				FileUtils.readAccountData("value.textbox")));
	}
	
	@Test(enabled=false)
	public void mergeAccounts_TC13() throws IOException {
		AccountPage ap=new AccountPage(driver);
		Assert.assertTrue(ap.verifyUserNameInHomePage(),"Failed to verify Home Page");
		Assert.assertTrue(ap.verifyMergeaccountStep2pageDisplayed(FileUtils.readAccountData("mergeaccount.name")));
		Assert.assertTrue(ap.verifyMergedAccountsInRecentlyViewed(driver, FileUtils.readAccountData("recentview.option"),
				FileUtils.readAccountData("mergeaccount.name")));
	}
	
	
	@Test(enabled=false)
	public void createAccoutReport_TC14() throws IOException {
		AccountPage ap=new AccountPage(driver);
		Assert.assertTrue(ap.verifyUserNameInHomePage(),"Failed to verify Home Page");
		Assert.assertTrue(ap.verifyUnsavedReportPageDisplayed(),"Failed to verify unsaved report page");
		Assert.assertTrue(ap.verifyFinalReportPageDisplayed(driver, FileUtils.readAccountData("fromdatefield.option"), FileUtils.readAccountData("report.name"),
				FileUtils.readAccountData("reportunique.name")));
	}
	
	
	
	
	
	
	
	
	
}
