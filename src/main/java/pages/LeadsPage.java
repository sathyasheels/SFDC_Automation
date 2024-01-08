package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class LeadsPage {
	public LeadsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@title='Leads Tab']")
	public WebElement leadsTab;
	
	@FindBy(xpath="//h1[@class='pageType']")
	public WebElement leadsPage;
	
	public boolean verifyLeadsHomePageDisplayed() {
		boolean isLeadsHomePageDisplayed=false;
		if(leadsPage.isDisplayed()) {
			isLeadsHomePageDisplayed=true;
		}
		
		return isLeadsHomePageDisplayed;
	}
	
	
	
	@FindBy(xpath="//select[@title='View:']")
	public WebElement leadsViewDropdown;
	
	@FindBy(xpath="//select[@title='View:']//option")
	public List<WebElement> leadsViewDropdownOption;
	
	public boolean verifyLeadsDropdown() throws IOException {
		boolean isLeadsDropdownVerified=false;
		String[] expecteddropdownoptions=FileUtils.readLeadsData("leadsdropdown.option").split(",");
		
		for(int i=0;i<expecteddropdownoptions.length;i++)
		{
			CommonUtils.selectDropDown(leadsViewDropdown, expecteddropdownoptions[i]);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(expecteddropdownoptions[i].equals(leadsViewDropdownOption.get(i).getText())) {
				isLeadsDropdownVerified=true;
			System.out.println("Expected Option:" +expecteddropdownoptions[i]+ "Actual Option:"+leadsViewDropdownOption.get(i).getText());
			}else {
			System.out.println("Expected Option:" +expecteddropdownoptions[i]+ "Actual Option:"+leadsViewDropdownOption.get(i).getText());
		}			
				}
return isLeadsDropdownVerified;
	}
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenuLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutLink;
	
	public boolean verifyTodaysLeads(WebDriver driver,String expectedTitle ) throws IOException {
		boolean isTodaysLeadsSelected=false;
		CommonUtils.selectDropDown(leadsViewDropdown,FileUtils.readLeadsData("viewdropdown.option"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(CommonUtils.waitForElementToBeClickable(driver, userMenuLink) && userMenuLink.isDisplayed()) {
			userMenuLink.click();
			logoutLink.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			isTodaysLeadsSelected=true;
		}
		return isTodaysLeadsSelected;
	}
	
	
	
	@FindBy(xpath="//input[@value=' Go! ']")
	public WebElement goViewButton;
	
	public boolean verifyDefaultView(WebDriver driver) throws IOException {
		boolean isDefaultViewDisplayed=false;
		WebElement element=driver.findElement(By.xpath("//select[@title='View:']//option[@selected='selected']"));
		String defaultView=element.getText();
		if(defaultView.equals(FileUtils.readLeadsData("viewdropdown.option"))){
			goViewButton.click();
			isDefaultViewDisplayed=true;
		}
		
		return isDefaultViewDisplayed;
	}
	
	public boolean verifyDefaultView1() throws IOException {
		boolean isDefaultViewDisplayed=false;
		String defaultView=CommonUtils.selectDefaultView(leadsViewDropdown);
		if(defaultView.equals(FileUtils.readLeadsData("viewdropdown.option"))){
			goViewButton.click();
			isDefaultViewDisplayed=true;
		}
		return isDefaultViewDisplayed;
	}
	
	
	@FindBy(xpath="//input[@value='New Lead']")
	public WebElement newLeadsTab;
	
	
	public boolean verifyTodayLeadsPage() throws IOException {
		boolean isTodayLeadsPageDisplayed=false;
		CommonUtils.selectDropDown(leadsViewDropdown,FileUtils.readLeadsData("viewdropdown.option"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newLeadsTab.isDisplayed()) {
			isTodayLeadsPageDisplayed=true;
		}
		return isTodayLeadsPageDisplayed;
	}
	
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newLeadButton;
	
	@FindBy(xpath="//h2[text()=' New Lead']")
	public WebElement newLeadPage;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	public WebElement newLeadLastname;
	
	@FindBy(xpath="//input[@id='lea3']")
	public WebElement newCompanyname;
	
	@FindBy(xpath="//td[@id='topButtonRow']//child::input[@value=' Save ']")
	public WebElement saveLeadButton;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Edit']")
	public WebElement editViewButton;
	
	public boolean verifyNewLeadPageDisplayed() {
	 boolean isNewLeadPageDisplayed=false;
	 if(newLeadButton.isDisplayed()) {
		 newLeadButton.click();
	 }if(newLeadPage.isDisplayed()) {
		 isNewLeadPageDisplayed=true;
	 }
	  return isNewLeadPageDisplayed;
		}
	
	
	public boolean verifyNewLeadCreated(WebDriver driver,String lastname,String companyname) {
		boolean isNewLeadCreated=false;
		if(newLeadLastname.isDisplayed()) {
			newLeadLastname.sendKeys(lastname);
		}if(newCompanyname.isDisplayed()) {
			newCompanyname.sendKeys(companyname);
		}
		saveLeadButton.click();
		if(CommonUtils.waitForElementToBeClickable(driver, editViewButton)) {
			isNewLeadCreated=true;
		}
		return isNewLeadCreated;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
