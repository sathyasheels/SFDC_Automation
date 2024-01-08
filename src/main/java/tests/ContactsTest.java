package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.LoginPage;
import utils.FileUtils;

public class ContactsTest extends BaseTest {
	private WebDriver driver;

	@BeforeMethod
	public void preRequisite() throws IOException
	{
		driver=BaseTest.getBrowserType("edge");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
	@Test(enabled=false)
	public void createNewContact_TC25() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyNewContactCreated(FileUtils.readContactsData("contact.lastname"), FileUtils.readContactsData("contact.accountname")));
	}

	
	@Test(enabled=false)
	public void createNewView_TC26() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyNewViewCreated(driver, FileUtils.readContactsData("contact.viewname"), FileUtils.readContactsData("contact.uniquename")));
	}

	
	
	@Test(enabled=false)
	public void checkRecentlyCreatedContacts_TC27() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyRecentlyCreatedContacts(FileUtils.readContactsData("recentlycreatesdropdown.option")));
	}
	
	
	
	@Test(enabled=false)
	public void checkMyContactsView_TC28() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyMyContactsPageDisplayed(FileUtils.readContactsData("viewdropdown.mycontactsoption")));
	}
	
	@Test(enabled=false)
	public void viewContact_TC29() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyRespectiveContactPageDisplayed(driver, FileUtils.readContactsData("contact.lastname")));
	}
	
	
	@Test(enabled=false)
	public void checkErrorMessage_TC30() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyErrorMessageDisplayedCorrectly(FileUtils.readContactsData("contact.uniquename2"), 
				FileUtils.readContactsData("expected.errormessage")));
	}
	
	
	@Test(enabled=false)
	public void checkCancelButton_TC31() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyHomepageDisplayedOnclickingCancelButton(FileUtils.readContactsData("contact.viewname2"),
				FileUtils.readContactsData("contact.uniquename2")));
	}
	
	
	
	@Test(enabled=false)
	public void checkSaveAndNewButton_TC32() throws IOException {
		ContactsPage cp=new ContactsPage(driver);
		Assert.assertTrue(cp.verifyContactHomePageDisplayed(),"Failed to verify contacts home page");
		Assert.assertTrue(cp.verifyEditContactPageDisplayedOnClickingSaveAndNew(driver, FileUtils.readContactsData("contact.newlastname"), 
				FileUtils.readContactsData("contact.accountname")));
	}
	
	
	
	
	
	
	
	
}
