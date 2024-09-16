package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class AccountPage {
	private WebDriver driver;
	
	public AccountPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(xpath="//a[text()='Accounts']")
	public WebElement accountsTab;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenuLink;
	
	
	public boolean verifyUserNameInHomePage() {
		ContactsPage cp=new ContactsPage(driver);
		if(cp.getCancelButton().isDisplayed()) {
			
		}
		boolean isUserNameInHomePageDisplayed=false;
		if(accountsTab.isDisplayed()) {
			accountsTab.click();
		}
		if(userMenuLink.isDisplayed()) {
			isUserNameInHomePageDisplayed=true;
		}
		return isUserNameInHomePageDisplayed;
	}
	
	
	
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newAccountButton;
	
	@FindBy(xpath="//input[@id='acc2']")
	public WebElement accountNameTextbox;
	
	@FindBy(xpath="//select[@id='acc6']")
	public WebElement typeDropdown;
	
	@FindBy(xpath="//select[@id='00NHs00000bAdAa']")
	public WebElement customerPriorityDropdown;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@value=' Save ']")
	public WebElement saveAccountButton;
	
	@FindBy(xpath="//h2[@class='topName']")
	public WebElement newAccountPage;
	
	
	public boolean verifyAccountPageDisplayed(String expectedaccountName,String typeDropdownOption,String customerPriorityDropdownOption) {
		boolean isAccountPageDisplayed=false;
		if(newAccountButton.isDisplayed()) {
			newAccountButton.click();
		}if(accountNameTextbox.isDisplayed()) {
			accountNameTextbox.sendKeys(expectedaccountName);
			CommonUtils.selectDropDown(typeDropdown, typeDropdownOption);
			CommonUtils.selectDropDown(customerPriorityDropdown, customerPriorityDropdownOption);
			if(saveAccountButton.isDisplayed()) {
				saveAccountButton.click();
			}
		}if(newAccountPage.isDisplayed()) {
			String actualAccountName=newAccountPage.getText();
			if(actualAccountName.equals(expectedaccountName)) {
				isAccountPageDisplayed=true;
			}
		}
		return isAccountPageDisplayed;
	}
	
	
	@FindBy(xpath="//a[text()='Create New View']")
	public WebElement createNewViewLink;
	
	
	@FindBy(xpath="//h2[text()=' Create New View']")
	public WebElement createNewViewPage;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewNameTextbox;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement uniqueViewTextbox;
	
	@FindBy(xpath="//input[@data-uidsfdc='3']")
	public WebElement saveViewButton;
	
	@FindBy(xpath="//select[@title='View:']")
	public WebElement viewDropdown;
	
	
	public boolean verifyNewViewDisplayed(WebDriver driver,String viewname,String uniqueviewname) {
		boolean isNewViewDisplayed=false;
		if(createNewViewLink.isDisplayed()) {
			createNewViewLink.click();
		}if(createNewViewPage.isDisplayed()) {
			viewNameTextbox.sendKeys(viewname);
			uniqueViewTextbox.clear();
			uniqueViewTextbox.sendKeys(uniqueviewname);
			saveViewButton.click();
		}accountsTab.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(viewDropdown.isDisplayed()) {
			WebElement element=driver.findElement(By.xpath("//select[@title='View:']//option[@selected='selected']"));
			String defaultView=element.getText();
			if(defaultView.equals(viewname)){
				isNewViewDisplayed=true;
			}
		}
		return isNewViewDisplayed;
	}
	
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement editViewButton;
	
	@FindBy(xpath="//h2[text()=' Edit View']")
	public WebElement editViewPage;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement editViewNameTextbox;
	
	@FindBy(xpath="//select[@id='fcol1']")
	public WebElement fieldDropdown;
	
	@FindBy(xpath="//select[@id='fop1']")
	public WebElement operatorDropdown;
	
	@FindBy(xpath="//input[@id='fval1']")
	public WebElement valueTextbox;
	
	@FindBy(xpath="//input[@data-uidsfdc='3']")
	public WebElement saveEditButton;
	
	public boolean verifyEditViewPageDisplayed(String oldViewName) {
		boolean isEditViewPageDisplayed=false;
		CommonUtils.selectDropDown(viewDropdown, oldViewName);
		editViewButton.click();
		if(editViewPage.isDisplayed()) {
			isEditViewPageDisplayed=true;
		}
		return isEditViewPageDisplayed;
	}
	
	public boolean verifyNewViewUpdated(WebDriver driver,String newViewname,String fieldDropdownoption,
			String operatorDropdownOption, String value) {
		boolean isNewViewUpdated=false;
		if(editViewNameTextbox.isDisplayed()) {
			editViewNameTextbox.sendKeys(newViewname);
			CommonUtils.selectDropDown(fieldDropdown, fieldDropdownoption);
			CommonUtils.selectDropDown(operatorDropdown, operatorDropdownOption);
			valueTextbox.clear();
			valueTextbox.sendKeys(value);
			saveEditButton.click();
		}
			if(viewDropdown.isDisplayed()) {
				WebElement element=driver.findElement(By.xpath("//select[@title='View:']//option[@selected='selected']"));
				String defaultView=element.getText();
				if(defaultView.equals(newViewname)){
					isNewViewUpdated=true;
		}
			}
		return isNewViewUpdated;
	}
	
	
	
	
	@FindBy(xpath="//a[text()='Merge Accounts']")
	public WebElement mergeAccountsLink;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement mergeAccountsPageStep1;
	
	@FindBy(xpath="//input[@id='srch']")
	public WebElement findAccountTextbox;
	
	@FindBy(xpath="//input[@value='Find Accounts']")
	public WebElement findAccountButton;
	
	@FindBy(xpath="//div[@class='pbTopButtons']//child::input[@value=' Next ']")
	public WebElement nextButton;
	
	@FindBy(xpath="//div[@class='pbWizardTitle tertiaryPalette brandTertiaryBgr']")
	public WebElement mergeAccountsPageStep2;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']//input[@value=' Merge ']")
	public WebElement mergeButton;
	
	public boolean verifyMergeaccountStep2pageDisplayed(String mergeAccountName) {
		boolean isMergeaccountStep2pageDisplayed=false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mergeAccountsLink.isDisplayed()) {
			mergeAccountsLink.click();
			if(mergeAccountsPageStep1.isDisplayed()) {
				findAccountTextbox.sendKeys(mergeAccountName);
				findAccountButton.click();
				nextButton.click();
			}
		}if(mergeAccountsPageStep2.isDisplayed()) {
			isMergeaccountStep2pageDisplayed=true;
		}
		
		return isMergeaccountStep2pageDisplayed;
	}
	
	public boolean verifyMergedAccountsInRecentlyViewed(WebDriver driver,String recentviewoption,String mergeAccountName) {
		boolean isMergedAccountsInRecentlyViewed=false;
		if(mergeAccountsPageStep2.isDisplayed()){
			mergeButton.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			}
		if(viewDropdown.isDisplayed()) {
			CommonUtils.selectDropDown(viewDropdown, recentviewoption);
			WebElement mergedaccountname=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-Name']//a//span[contains(text(),'"+mergeAccountName+"')]"));
		if(mergedaccountname.isDisplayed()) {
			isMergedAccountsInRecentlyViewed=true;
		}
		}
		return isMergedAccountsInRecentlyViewed;
	}
	
	
	
	@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
	public WebElement accoutLastActivityLink;
	
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement unsavedReportPage;
	
	@FindBy(xpath="//input[@name='dateColumn']//following-sibling::img")
	public WebElement dateFielddownarrow;
	
	@FindBy(xpath="//div[text()='Created Date']")
	public WebElement createdDateOption;
	
	@FindBy(xpath="//input[@name='startDate']")
	public WebElement fromDateField;
	
	@FindBy(xpath="//button[@id='ext-gen49']")
	public WebElement SaveUnsavedReportButton;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")
	public WebElement alertReportNameTextbox;
	
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")
	public WebElement alertReportUniqueName;
	
	@FindBy(xpath="//button[text()='Save and Run Report']")
	public WebElement saveAndRunReportButton;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement finalReportPage;
	
	
	
	
	public boolean verifyUnsavedReportPageDisplayed() {
		boolean isUnsavedReportPageDisplayed=false;
		if(accoutLastActivityLink.isDisplayed()) {
			accoutLastActivityLink.click();
		}if(unsavedReportPage.isDisplayed()) {
			isUnsavedReportPageDisplayed=true;
		}
		return isUnsavedReportPageDisplayed;
	}
	
	public boolean verifyFinalReportPageDisplayed(WebDriver driver, String fromDateFieldOption,
			String reportname,String reportuniquename ) {
		boolean isFinalReportPageDisplayed=false;
		if(unsavedReportPage.isDisplayed()) {
			dateFielddownarrow.click();
			createdDateOption.click();
			fromDateField.sendKeys(fromDateFieldOption);
			SaveUnsavedReportButton.click();
		}
		//driver.switchTo().alert();
		alertReportNameTextbox.sendKeys(reportname);
		alertReportUniqueName.clear();
		alertReportUniqueName.sendKeys(reportuniquename);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveAndRunReportButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(finalReportPage.isDisplayed()) {
			String actualReportName=finalReportPage.getText();
			if(actualReportName.equals(reportname)) {
				isFinalReportPageDisplayed=true;
			}	
		}
		return isFinalReportPageDisplayed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		}
	
	
	
	
	
	
	


