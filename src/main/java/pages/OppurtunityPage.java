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

public class OppurtunityPage {
	public OppurtunityPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[@title='Opportunities Tab']")
	public WebElement oppurtunitiesTab;
	
	@FindBy(xpath="//select[@title='View:']")
	public WebElement viewDropdown;
	
	@FindBy(xpath="//select[@title='View:']//option")
	public List<WebElement> viewDropdownOptions ;
	
	@FindBy(xpath="//h1[@class='pageType']")
	public WebElement opportunityHomePage;
	
	public boolean verifyOpportunityHomePage() {
		boolean isOpportunityPagedDisplayed=false;
		if(opportunityHomePage.isDisplayed()) {
			isOpportunityPagedDisplayed=true;	
		}
		return isOpportunityPagedDisplayed;
	}
	
	public boolean verifyViewOppurtunityDropDown() throws IOException {
		boolean isOppurtunityDropdownVerified=false;
		
		String[] expecteddropdownoptions=FileUtils.readOppurtunityData("viewdropdown.option").split(",");
		
		for(int i=0;i<expecteddropdownoptions.length;i++)
		{
			CommonUtils.selectDropDown(viewDropdown, expecteddropdownoptions[i]);
			if(expecteddropdownoptions[i].equals(viewDropdownOptions.get(i).getText())) {
				isOppurtunityDropdownVerified=true;
			System.out.println("Expected Option:" +expecteddropdownoptions[i]+ "Actual Option:"+viewDropdownOptions.get(i).getText());
			}else {
			System.out.println("Expected Option:" +expecteddropdownoptions[i]+ "Actual Option:"+viewDropdownOptions.get(i).getText());
		}			
				}
		return isOppurtunityDropdownVerified;
		}
	
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newOpportunityButton;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement newoppurtunityEditPage;
	
	@FindBy(xpath="//input[@id='opp3']")
	public WebElement opportunityNameTextbox;
	
	@FindBy(xpath="//input[@id='opp4']")
	public WebElement accountNameTextbox;
	
	@FindBy(xpath="//input[@id='opp9']")
	public WebElement closeDateTextbox;
	
	@FindBy(xpath="//select[@id='opp11']")
	public WebElement stageDropdown;
	
	@FindBy(xpath="//input[@id='opp12']")
	public WebElement probabilityTextbox;
	
	@FindBy(xpath="//select[@id='opp6']")
	public WebElement leadSourceDropdown;
	
	@FindBy(xpath="//input[@id='opp17']")
	public WebElement primaryCampaignSource;
	
	@FindBy(xpath="//td[@id='topButtonRow']//child::input[@value=' Save ']")
	public WebElement saveNewOppurtunitybutton;

	
	public boolean verifyNewOppurtunityPageDisplayed(WebDriver driver,String oppurtunityName,String closeDate,String stageDropdownOption,
			String probability,String leadSourceOption) {
		boolean isNewOppurtunityPageDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver, newOpportunityButton)) {
			newOpportunityButton.click();
		}if(newoppurtunityEditPage.isDisplayed()) {
			opportunityNameTextbox.sendKeys(oppurtunityName);
			closeDateTextbox.sendKeys(closeDate);
			CommonUtils.selectDropDown(stageDropdown, stageDropdownOption);
			probabilityTextbox.clear();
			probabilityTextbox.sendKeys(probability);
			CommonUtils.selectDropDown(leadSourceDropdown, leadSourceOption);
			saveNewOppurtunitybutton.click();
		}try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElement(By.xpath("//h2[text()=' "+oppurtunityName+"']")).isDisplayed()) {
			isNewOppurtunityPageDisplayed=true;
		}
		return isNewOppurtunityPageDisplayed;
		
	}
	
	
	@FindBy(xpath="//a[text()='Opportunity Pipeline']")
	public WebElement pipelineLink;
	
	@FindBy(xpath="//h1[text()='Opportunity Pipeline']")
	public WebElement opportunityPipelineReportPage;
	

	public boolean verifyOpportunityPipelineReportPage(WebDriver driver) {
		boolean isOpportunityPipelineReportPageDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver, pipelineLink)) {
			pipelineLink.click();
		}if(opportunityPipelineReportPage.isDisplayed()) {
			isOpportunityPipelineReportPageDisplayed=true;
		}
		
		return isOpportunityPipelineReportPageDisplayed;
	}
	
	
	
	@FindBy(xpath="//a[text()='Stuck Opportunities']")
	public WebElement stuckOpportunityLink;
	
	@FindBy(xpath="//h1[text()='Stuck Opportunities']")
	public WebElement stuckOpportunityReportPage;
	
	public boolean verifystuckOpportunityReportPage(WebDriver driver) {
		boolean isStuckOpportunityReportPageDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver, stuckOpportunityLink)) {
			stuckOpportunityLink.click();
		}if(stuckOpportunityReportPage.isDisplayed()) {
			isStuckOpportunityReportPageDisplayed=true;
		}
		
		return isStuckOpportunityReportPageDisplayed;
	}
	
	
	@FindBy(xpath="//h3[text()='Quarterly Summary']")
	public WebElement quarterlySummaryLabel;
	
	@FindBy(xpath="//select[@id='quarter_q']")
	public WebElement intervalDropdown;
	
	@FindBy(xpath="//select[@id='open']")
	public WebElement includeDropdown;
	
	@FindBy(xpath="//input[@value='Run Report']")
	public WebElement runReportButton;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement opportunityReportLabel;
	
	public boolean verifyQuarterlySummaryReportPageDisplayed(WebDriver driver,String intervalOption,String includeOption) {
		boolean isQuarterlySummaryPageDisplayed=false;
		if(opportunityHomePage.isDisplayed()) {
			CommonUtils.selectDropDown(intervalDropdown, intervalOption);
			CommonUtils.selectDropDown(includeDropdown, includeOption);
			runReportButton.click();
		}if(opportunityReportLabel.isDisplayed()) {
			isQuarterlySummaryPageDisplayed=true;
		}
		
		return isQuarterlySummaryPageDisplayed;
	}
	
	
	

}
