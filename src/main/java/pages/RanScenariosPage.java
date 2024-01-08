package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;
import utils.FileUtils;

public class RanScenariosPage {
	public RanScenariosPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(xpath="//a[@title='Home Tab']")
	public WebElement homeTab;
	
	@FindBy(xpath="//h1[@class='currentStatusUserName']")
	public WebElement firstnameLastNameLink;
	
	public boolean verifyHomePageDisplayed() {
		boolean isHomePageDisplayed=false;
		if(homeTab.isDisplayed()) {
			homeTab.click();
		}if(firstnameLastNameLink.isDisplayed()) {
			isHomePageDisplayed=true;
		}
		return isHomePageDisplayed;
	}

	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	public WebElement firstnameLastNameLinkPage;
	
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenuLink;
	
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[@title='My Profile']")
	public WebElement MyProfileLink;
	
	
	@FindBy(xpath="//span[@class='tailNode cxTailNode']")
	public WebElement myProfilePage;
	
	
	public boolean verifyFirstnameLastnameLinkPageDisplayed() {
		boolean isFirstnameLastnameLinkPageDisplayed=false;
		if(firstnameLastNameLink.isDisplayed()) {
			firstnameLastNameLink.click();
		}if(firstnameLastNameLinkPage.isDisplayed()) {
			String firstnameLastNameLinktext=firstnameLastNameLinkPage.getText();
			if(userMenuLink.isDisplayed()) {
				userMenuLink.click();
				MyProfileLink.click();
			}if(myProfilePage.isDisplayed()) {
				String myProfilePagetext=myProfilePage.getText();
				if(firstnameLastNameLinktext.equals(myProfilePagetext)) {
					isFirstnameLastnameLinkPageDisplayed=true;
				}
			}
		}
		
		return isFirstnameLastnameLinkPageDisplayed;
	}
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']//child::img")
	public WebElement editIconInUserProfile;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	public WebElement editProfileAboutIframe;
	
	@FindBy(xpath="//li[@id='aboutTab']/a")
	public WebElement aboutTab;
	
	@FindBy(xpath="//li[@id=\"contactTab\"]//child::a")
	public WebElement contactTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@class='zen-btn zen-primaryBtn zen-pas']")
	public WebElement saveAllButton;
	
	public boolean verifyEditProfilePopupdisplayed(WebDriver driver) {
		boolean isEditProfilePopupdisplayed=false;
		if(firstnameLastNameLink.isDisplayed()) {
			firstnameLastNameLink.click();
		}if(editIconInUserProfile.isDisplayed()) {
			editIconInUserProfile.click();
		}if(editProfileAboutIframe.isDisplayed()) {
		driver.switchTo().frame(editProfileAboutIframe);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(contactTab.isEnabled()) {
			isEditProfilePopupdisplayed=true;
		}
		}
		return isEditProfilePopupdisplayed;
	}
	
	public boolean verifyUpdatedLastnameDisplayed(WebDriver driver,String newLastname) {
		boolean isUpdatedLastnameDisplayed=false;
		boolean isUpdatedLastnameDisplayedinMyProfileandUsermenulink=false;
		boolean isUpdatedLastnameDisplayedinHomepage=false;
		if(aboutTab.isDisplayed()) {
			aboutTab.click();
			lastName.clear();
			lastName.sendKeys(newLastname);
			saveAllButton.click();
			}driver.switchTo().parentFrame();
			if(myProfilePage.isDisplayed()) {
				if(myProfilePage.getText().contains(newLastname)){
					if(userMenuLink.getText().contains(newLastname)) {
						isUpdatedLastnameDisplayedinMyProfileandUsermenulink=true;
					}
				}
			}if(homeTab.isDisplayed()) {
				homeTab.click();
				if(firstnameLastNameLink.getText().contains(newLastname)) {
					isUpdatedLastnameDisplayedinHomepage=true;
				}
			}if(isUpdatedLastnameDisplayedinMyProfileandUsermenulink && isUpdatedLastnameDisplayedinHomepage) {
				isUpdatedLastnameDisplayed=true;
			}
			return isUpdatedLastnameDisplayed;
	}
	
	
	
	@FindBy(xpath="//img[@title='All Tabs']")
	public WebElement allTabsImage;
	
	@FindBy(xpath="//h1[text()='All Tabs']")
	public WebElement allTabsPage;
	
	@FindBy(xpath="//input[@value='Customize My Tabs']")
	public WebElement customizeMyTabsButton;
	
	@FindBy(xpath="//h1[text()='Customize My Tabs']")
	public WebElement customizeMyTabsPage;
	
	
	public boolean verifyCustomizeMyTabPageDispalyed() {
		boolean isCustomizeMyTabPageDispalyed=false;
		if(allTabsImage.isDisplayed()) {
			allTabsImage.click();
		}if(allTabsPage.isDisplayed()&&customizeMyTabsButton.isDisplayed()) {
			customizeMyTabsButton.click();
		}if(customizeMyTabsPage.isDisplayed()) {
			isCustomizeMyTabPageDispalyed=true;
		}
		return isCustomizeMyTabPageDispalyed;
	}
	
	
	@FindBy(xpath="//a[text()='Subscriptions']")
	public WebElement subscriptionsTab;
	
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	public WebElement selectedTabsDropDown;
	
	@FindBy(xpath="//select[@id='duel_select_0']//child::option[@value='AppLauncher']")
	public WebElement AppLauncherOption;
	
	@FindBy(xpath="//img[@class='leftArrowIcon']")
	public WebElement removeButton;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement avaialableTabDropDown;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement saveButton;
	
	public boolean verifyRemovedTabOptionNotDisplayed(WebDriver driver,String selectedDropdownoption) {
		boolean isRemovedTabOptionNotDisplayed=false;
		boolean isRemeovedTabOptionDisplayedinAvailableDropdown=false;
		boolean isRemovedTabOptionNotDisplayedinTabbar=false;
		if(selectedTabsDropDown.isDisplayed()) {
			CommonUtils.selectDropDown(selectedTabsDropDown, selectedDropdownoption);
			removeButton.click();
		}if(avaialableTabDropDown.isDisplayed()) {
			WebElement removedInSelectedDropdown=driver.findElement(By.xpath("//select[@id='duel_select_0']//child::option[text()='"+selectedDropdownoption+"']"));
			if(removedInSelectedDropdown.isDisplayed()) {
				isRemeovedTabOptionDisplayedinAvailableDropdown=true;
			}saveButton.click();
		}try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(allTabsPage.isDisplayed()) {
		 if(!subscriptionsTab.isDisplayed()){
			//WebElement tabRemovedinTabbar=driver.findElement(By.xpath("//ul[@id='tabBar']//child::a[text()='"+selectedDropdownoption+"']"));
			//if(!tabRemovedinTabbar.isDisplayed()) {
				isRemovedTabOptionNotDisplayedinTabbar=true;
			}
		}
		if(isRemeovedTabOptionDisplayedinAvailableDropdown&&isRemovedTabOptionNotDisplayedinTabbar) {
			isRemovedTabOptionNotDisplayed=true;
		}
		
		return isRemeovedTabOptionDisplayedinAvailableDropdown;
	}
	
	
	@FindBy(xpath="//span[@class='pageDescription']//child::a")
	public WebElement dateLink;
	
	@FindBy(xpath="//h1[text()='Calendar for Sathyasheela kumar - Day View']")
	public WebElement calendarDayViewPage;
	
	@FindBy(xpath="//div[@id='p:f:j_id25:j_id61:26:j_id64']//child::a")
	public WebElement sevenPMLink;
	
	@FindBy(xpath="//h2[text()=' New Event']")
	public WebElement calendarNewEventPage;
	
	@FindBy(xpath="//img[@class='comboboxIcon']")
	public WebElement subjectComboBoxIcon;
	
	
	public String get_Month(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
		return formatter.format(date);
		}
	
	
	public boolean verfiyCurrentDateDispalyed(WebDriver driver) {
		boolean isCurrentDateDispalyed=false;
		if(homeTab.isDisplayed()) {
			homeTab.click();
		}if(dateLink.isDisplayed()) {
			isCurrentDateDispalyed=true;
		}
		return isCurrentDateDispalyed;
	}
	
	public boolean verifyCalendarNewEventPageDisplayed() {
		boolean isCalendarNewEventPAgeDisplayed=false;
		if(dateLink.isDisplayed()) {
			dateLink.click();
		}if(calendarDayViewPage.isDisplayed()) {
			if(sevenPMLink.isDisplayed()) {
				sevenPMLink.click();
				if(calendarNewEventPage.isDisplayed()) {
					isCalendarNewEventPAgeDisplayed=true;
				}
			}
		}
		return isCalendarNewEventPAgeDisplayed;
	}
	
	
	
	@FindBy(xpath="//input[@id='evt5']")
	public WebElement subjectTextbox;
	
	@FindBy(xpath="//li[@class='listItem4']//child::a")
	public WebElement comboWindowOtherLink;
	
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	public WebElement endDateField;
	
	public boolean verifyComboboxPopupClosed(WebDriver driver,String expectedText) {
		boolean isComboboxPopupClosed=false;
		boolean isTextDisplayedinSubjectTextbox=false;
		if(subjectComboBoxIcon.isDisplayed()) {
			subjectComboBoxIcon.click();
		}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> I1= allWindowHandles.iterator();
			while(I1.hasNext())
			{
				String child_window=I1.next();
				if(!parentWindow.equals(child_window)){
			driver.switchTo().window(child_window);
				}
					}if(comboWindowOtherLink.isDisplayed()){
						comboWindowOtherLink.click();
					}driver.switchTo().window(parentWindow);
					System.out.println(parentWindow);
				if(subjectTextbox.isDisplayed()) {
					endDateField.click();
					String actualTextDisplayedinSubjectTextbox=subjectTextbox.getAttribute("value");
					System.out.println(actualTextDisplayedinSubjectTextbox);
					//selectItem.getFirstSelectedOption().getText()
					if(actualTextDisplayedinSubjectTextbox.equals(expectedText)) {
							isTextDisplayedinSubjectTextbox=true;
							isComboboxPopupClosed=true;	
					}
				}
					//isTextDisplayedinSubjectTextbox=true;
					//isComboboxPopupClosed=true;
				
		return isComboboxPopupClosed;
	}
	
	@FindBy(xpath="//div[@id='simpleTimePicker']//div")
	public List<WebElement> endDateDropdownOptions;
	
	public boolean verifyEndTimeDropdownOptionsdisplayed() throws IOException {
		boolean isEndTimeDropdownOptionsdisplayed=false;
		if(endDateField.isDisplayed()) {
			endDateField.click();
		}
		String[] expecteddropdownOptions=FileUtils.readRanScenariosData("enddatedropdown.option").split(",");
		for(int i=0,j=39;i<expecteddropdownOptions.length;i++,j++)
		{
			String actualOption=endDateDropdownOptions.get(j).getText();
			System.out.println(actualOption);
			if(actualOption.equals(expecteddropdownOptions[i])) {
				isEndTimeDropdownOptionsdisplayed=true;	
		}
	}return isEndTimeDropdownOptionsdisplayed;
	}
	
	
	@FindBy(xpath="//div[@id='simpleTimePicker']//div[41]")
	public WebElement eightPMOptionFromEnddateDropdown;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']//child::input[@value=' Save ']")
	public WebElement saveEventButton;
	
	@FindBy(xpath="//div[@class='multiLineEventBlock dragContentPointer']//span[@id='p:f:j_id25:j_id69:26:j_id71:0:j_id72:calendarEvent:j_id84']")
	public WebElement eventBlockedInTimeSlot;
	
	@FindBy(xpath="//div[@class='multiLineEventBlock dragContentPointer']//span[@id='p:f:j_id12:j_id69:26:j_id71:0:j_id72:calendarEvent:j_id84']")
	public WebElement eventBlockedInTimeSlot12to1;
	
	
	public boolean verifyCorrespondingEventBlockedInTimeSlot() {
		boolean isCorrespondingEventBlockedInTimeSlot=false;
		eightPMOptionFromEnddateDropdown.click();
		saveEventButton.click();
		if(calendarDayViewPage.isDisplayed()) {
			if(eventBlockedInTimeSlot.isDisplayed()) {
				isCorrespondingEventBlockedInTimeSlot=true;
			}
		}
		return isCorrespondingEventBlockedInTimeSlot;
	}
	
	
	
	@FindBy(xpath="//div[@id='p:f:j_id25:j_id61:20:j_id64']//child::a")
	public WebElement fourPMLink;
	
	
	public boolean verifyCalendarNewEventPageDisplayedwithStarttimeFourPM() {
		boolean isCalendarNewEventPAgeDisplayed=false;
		if(dateLink.isDisplayed()) {
			dateLink.click();
		}if(calendarDayViewPage.isDisplayed()) {
			if(fourPMLink.isDisplayed()) {
				fourPMLink.click();
				if(calendarNewEventPage.isDisplayed()) {
					isCalendarNewEventPAgeDisplayed=true;
				}
			}
		}
		return isCalendarNewEventPAgeDisplayed;
	}
	
	
	
	
	@FindBy(xpath="//div[@id='timePickerItem_36']")
	public WebElement sixPMLinkFromEnddateDropdown;
	
	@FindBy(xpath="//input[@id='IsRecurrence']")
	public WebElement createRecurrenceSeriesCheckbox;
	
	@FindBy(xpath="//input[@id='rectypeftw']")
	public WebElement weeklyRadioButton;
	
	@FindBy(xpath="//input[@id='RecurrenceEndDateOnly']")
	public WebElement recurrenceEnddateField;
	
	@FindBy(xpath="//select[@id='calMonthPicker']")
	public WebElement monthDropdownInEnddateField;
	
	@FindBy(xpath="//select[@id='calYearPicker']")
	public WebElement yearDropdownInEnddateField;
	
	@FindBy(xpath="//tr[@id='calRow3']//child::td[text()='14']")
	public WebElement dateInEnddateField_date14;
	
	@FindBy(xpath="//div[@class='multiLineEventBlock dragContentPointer']//child::span[@id='p:f:j_id25:j_id69:20:j_id71:0:j_id72:calendarEvent:j_id84']")
	public WebElement eventBlockedInTimeSlotFromFourToSixPM;
	
	
	
	public boolean verifyCorrespondingEventBlockedInTimeSlotForFourToSixPM(WebDriver driver,String month,String year,String date) {
		boolean isCorrespondingEventBlockedInTimeSlotForFourToSixPM=false;
		sixPMLinkFromEnddateDropdown.click();
		if(createRecurrenceSeriesCheckbox.isDisplayed()){
			createRecurrenceSeriesCheckbox.click();
		}if(weeklyRadioButton.isDisplayed()) {
			weeklyRadioButton.click();
			recurrenceEnddateField.click();
			CommonUtils.selectDropDown(monthDropdownInEnddateField, month);
			CommonUtils.selectDropDown(yearDropdownInEnddateField, year);
			WebElement dateLink=driver.findElement(By.xpath("//tr[@id='calRow3']//child::td[text()='"+date+"']"));
			dateLink.click();
			saveEventButton.click();
			}if(calendarDayViewPage.isDisplayed()) {
				if(eventBlockedInTimeSlotFromFourToSixPM.isDisplayed()) {
					isCorrespondingEventBlockedInTimeSlotForFourToSixPM=true;
				}
				}
		return isCorrespondingEventBlockedInTimeSlotForFourToSixPM;
	}
	
	
	@FindBy(xpath="//img[@class='monthViewIcon']")
	public WebElement monthViewIcon;
	
	@FindBy(xpath="//h1[@class='pageType']")
	public WebElement monthViewPage;
	
	public boolean verifyEventBlockedDisplayedInMonthViewPage() {
		boolean isEventBlockedDisplayedInMonthViewPage=false;
		if(monthViewIcon.isDisplayed()) {
			monthViewIcon.click();
		}if(monthViewPage.isDisplayed()) {
			
		}
		
		return isEventBlockedDisplayedInMonthViewPage;
	}
	
	
	
	
	
	
	
	
	
}

