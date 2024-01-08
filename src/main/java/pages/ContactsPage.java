package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class ContactsPage {
	public ContactsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@title='Contacts Tab']")
	public WebElement contactsTab;
	
	@FindBy(xpath="//h2[text()=' Home']")
	public WebElement contactsHomePage;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newContactButton;
	
	@FindBy(xpath="//h2[text()=' New Contact']")
	public WebElement newContactEditPage;
	
	@FindBy(xpath="//input[@id='name_lastcon2']")
	public WebElement lastNameTextbox;
	
	@FindBy(xpath="//input[@id='con4']")
	public WebElement accoutNameTextbox;
	
	@FindBy(xpath="//td[@id='topButtonRow']//child::input[@value=' Save ']")
	public WebElement saveContactButton;
	
	@FindBy(xpath="//h2[@class='topName']")
	public WebElement newContactPage;
	
	
	public boolean verifyContactHomePageDisplayed() {
		boolean isContactHomePageDisplayed=false;
		if(contactsTab.isDisplayed()){
			contactsTab.click();
		}if(contactsHomePage.isDisplayed()) {
			isContactHomePageDisplayed=true;
		}
		return isContactHomePageDisplayed;
		}
	
	public boolean verifyNewContactCreated(String contactLastname,String accountName) {
		boolean isNewContactCreated=false;
		if(contactsHomePage.isDisplayed()) {
			newContactButton.click();
		}if(newContactEditPage.isDisplayed()) {
			lastNameTextbox.sendKeys(contactLastname);
			accoutNameTextbox.sendKeys(accountName);
			saveContactButton.click();
		}if(newContactPage.isDisplayed()) {
			String actualContactlastName=newContactPage.getText();
			if(actualContactlastName.equals(contactLastname)) {
				isNewContactCreated=true;
			}
		}
		return isNewContactCreated;
	}
	
	
	@FindBy(xpath="//a[text()='Create New View']")
	public WebElement createNewViewLink;
	
	@FindBy(xpath="//h2[text()=' Create New View']")
	public WebElement createNewViewPage;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement contactViewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement contactViewUniqueName;
	
	@FindBy(xpath="//input[@data-uidsfdc='3']")
	public WebElement saveContactViewButton;
	
	@FindBy(xpath="//select[@title='View:']")
	public WebElement contactViewDropdown;
	
	@FindBy(xpath="//a[@title='Contacts Tab - Selected']")
	public WebElement contactsTabSelected;
	
	

	public boolean verifyNewViewCreated(WebDriver driver,String viewname, String viewUniqueName) {
		boolean isNewViewCreated=false;
		if(createNewViewLink.isDisplayed()) {
			createNewViewLink.click();
		}if(createNewViewPage.isDisplayed()) {
			contactViewName.sendKeys(viewname);
			contactViewUniqueName.clear();
			contactViewUniqueName.sendKeys(viewUniqueName);
			saveContactViewButton.click();
			}
		if(contactsTabSelected.isDisplayed()) {
			contactsTabSelected.click();
		}if(contactViewDropdown.isDisplayed()) {
			WebElement element=driver.findElement(By.xpath("//select[@title='View:']//child::option[@selected='selected']"));
			String defaultview=element.getText();
			if(defaultview.equals(viewname)) {
				isNewViewCreated=true;
			}
		}
		return isNewViewCreated;
	}
	
	
	@FindBy(xpath="//select[@id='hotlist_mode']")
	public WebElement recentlyCreatedDropdown;
	
	@FindBy(xpath="//h3[text()='Recent Contacts']")
	public WebElement recentContactsLabel;
	
	public boolean verifyRecentlyCreatedContacts(String dropdownoption) {
		boolean isRecentlyCreatedContactsDisplayed=false;
		if(recentlyCreatedDropdown.isDisplayed()) {
			CommonUtils.selectDropDown(recentlyCreatedDropdown, dropdownoption);
		}if(recentContactsLabel.isDisplayed()) {
			isRecentlyCreatedContactsDisplayed=true;
		}
		return isRecentlyCreatedContactsDisplayed;
		
	}
	
	
	@FindBy(xpath="//input[@value='New Contact']")
	public WebElement newButtonMyContactsPage;
	
	public boolean verifyMyContactsPageDisplayed(String mycontactoption) {
		boolean isMyContactsPageDisplayed=false;
		if(contactViewDropdown.isDisplayed()) {
			CommonUtils.selectDropDown(contactViewDropdown, mycontactoption);
		}
		if(newButtonMyContactsPage.isDisplayed()) {
			isMyContactsPageDisplayed=true;
		}
		return isMyContactsPageDisplayed;
	}
	
	public boolean verifyRespectiveContactPageDisplayed(WebDriver driver, String contactname) {
		boolean isRespectiveContactPageDisplayed=false;
		if(contactsHomePage.isDisplayed()) {
		WebElement respectiveContact=driver.findElement(By.xpath("//a[text()='"+contactname+"']"));
		String respectiveContactname=respectiveContact.getText();
		respectiveContact.click();
		
		WebElement displayedContact=driver.findElement(By.xpath("//h2[@class='topName']"));
		String displayedContactName=displayedContact.getText();
		if(respectiveContactname.equals(displayedContactName)) {
			isRespectiveContactPageDisplayed=true;
		}
		}
		return isRespectiveContactPageDisplayed;
	}
	
	
	@FindBy(xpath="//div[@class='requiredInput']//child::div[@class='errorMsg']")
	public WebElement errormessage;
	
	public boolean verifyErrorMessageDisplayedCorrectly(String uniqueviewname2, String expectedErrorMessage) {
		boolean isErrorMessageDisplayedCorrectly=false;
		if(createNewViewLink.isDisplayed()) {
			createNewViewLink.click();
		}if(createNewViewPage.isDisplayed()) {
			contactViewUniqueName.sendKeys(uniqueviewname2);
			saveContactViewButton.click();
		}if(errormessage.isDisplayed()) {
			String actualErrorMessage=errormessage.getText();
			if(actualErrorMessage.equals(expectedErrorMessage)) {
				isErrorMessageDisplayedCorrectly=true;
			}
		}
		return isErrorMessageDisplayedCorrectly;
	}
	
	
	
	@FindBy(xpath="//input[@data-uidsfdc='3']//following-sibling::input[@value='Cancel']")
	public WebElement cancelButton;
	
	public boolean verifyHomepageDisplayedOnclickingCancelButton(String viewname2,String viewUniqueName2) {
		boolean isHomepageDisplayedOnclickingCancelButton=false;
		if(createNewViewLink.isDisplayed()) {
			createNewViewLink.click();
		}if(createNewViewPage.isDisplayed()) {
			contactViewName.sendKeys(viewname2);
			contactViewUniqueName.clear();
			contactViewUniqueName.sendKeys(viewUniqueName2);
			cancelButton.click();
		}if(contactsHomePage.isDisplayed()) {
			isHomepageDisplayedOnclickingCancelButton=true;
		}
		return isHomepageDisplayedOnclickingCancelButton;
	}
	
	
	
	
	@FindBy(xpath="//td[@id='topButtonRow']//child::input[@value='Save & New']")
	public WebElement saveAndNewButton;
	
	public boolean verifyEditContactPageDisplayedOnClickingSaveAndNew(WebDriver driver,String newlastname,String accountname) {
		boolean isEditContactPageDisplayedOnClickingSaveAndNew=false;
		if(newContactButton.isDisplayed()) {
			newContactButton.click();
		}if(newContactEditPage.isDisplayed()) {
			lastNameTextbox.sendKeys(newlastname);
			accoutNameTextbox.sendKeys(accountname);
			saveAndNewButton.click();
		}if(newContactEditPage.isDisplayed()) {
			WebElement justnowcreatedcontact=driver.findElement(By.xpath("//span[text()='"+newlastname+"']"));
			if(justnowcreatedcontact.isDisplayed()) {
				isEditContactPageDisplayedOnClickingSaveAndNew=true;
			}
		}
		return isEditContactPageDisplayedOnClickingSaveAndNew;
	}
	
	
	
	
	
	
	
	
	

}
