package pages;
import pages.BasePage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.interactions.KeyInput;

public class UserMenuPage extends BasePage{
	
	public UserMenuPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[1]")
	public WebElement myProfile;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[2]")
	public WebElement mySettings;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[3]")
	public WebElement developerConsole;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[4]")
	public WebElement lightningExperience;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[5]")
	public WebElement logout;
	
	@FindBy(xpath="//a[text()='Feed']")
	public WebElement myProfilePage;
	
	//@FindBy(xpath="//a[@class='contactInfoLaunch editLink']/img[@title='Edit Profile']")
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
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	public WebElement firstNameLastNameDisplayMyProfile;
	
	@FindBy(xpath="//span[text()='Post']")
	public WebElement postLink;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement postTextIframe;
	
	@FindBy(xpath="//html[@dir='ltr']//child::body")
	public WebElement textToPost;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	public WebElement sharePostButton;
	
	@FindBy(xpath="//span[text()='File']")
	public WebElement fileLink;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	public WebElement uploadFileLink;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	public WebElement chooseFileButton;
	
	@FindBy(xpath="//div[@id='progressIcon']")
	public WebElement spinningWheelShareFile;
	
	@FindBy(xpath="//input[@id='publishersharebutton']")
	public WebElement shareFileButton;
	
	@FindBy(xpath="//span[@class='contentTitleLink']")
	public WebElement postedFileName;
	
	@FindBy(xpath="//span[@id='displayBadge']")
	public WebElement moderatorSection;
	
	@FindBy(xpath="//a[@id='uploadLink']")
	public WebElement addPhotoLink;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	public WebElement photoUploadIframe;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement choosePhotoFileButton;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement savePhotoButton;
	
	@FindBy(xpath="//input[@name='j_id0:waitingForm']//following-sibling::img")
	public WebElement spinningWheelUploadPhoto;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	public WebElement croppingIframe;
	
	@FindBy(xpath="//input[@id='j_id0:j_id7:save']")
	public WebElement savePhotoButton2;
	
	@FindBy(xpath="//input[@name='cropWaitingPage:croppingForm']//following-sibling::img")
	public WebElement spinningWheelUploadPhoto2;
	
	public boolean verifyHomePage() throws IOException{
		boolean isHomePageVerified=false;
		{
		if(userMenu.isDisplayed()) {
			isHomePageVerified=true;
	}
		}
		return isHomePageVerified;
	}
	
	
	public boolean verifyUserMenuItems() throws IOException {
		boolean isUserMenuItemsVerified=true;
		String[] expectedUserMenuItems=FileUtils.readUserMenuData("userMenu.items").split(",");
		for(int i=0;i<expectedUserMenuItems.length;i++)
		{
			String actualOption=userMenuOptions.get(i).getText();
			if(actualOption.equals(expectedUserMenuItems[i])) {
				System.out.println("Expected Option:" +expectedUserMenuItems[i]+ "Actual Option:"+actualOption);
			}else {
				System.out.println("Expected Option:" +expectedUserMenuItems[i]+ "Actual Option:"+actualOption);
				isUserMenuItemsVerified=false;
			}
		}
		return isUserMenuItemsVerified;
	}
	public void selectUserMenuOption(WebDriver driver,String option) {
		WebElement userMenuOption=driver.findElement(By.xpath("//*[text()='"+option+"']"));
		userMenuOption.click();
		logger.info("Corresponding usermenu option is clicked");
	}
	
	public boolean isMyProfilePagedisplayed() {
		return myProfilePage.isDisplayed();
	}
	
	public void selectEditContactIcon(WebDriver driver) {
		if(CommonUtils.waitForElementToBeClickable(driver, editIconInUserProfile)) {
			editIconInUserProfile.click();
		}
	}
	public boolean verifyEditProfileframe(WebDriver driver) {
		boolean isFrameLoaded=false;
		if(CommonUtils.waitForElementToBeClickable(driver, editProfileAboutIframe)) {
			driver.switchTo().frame(editProfileAboutIframe);
			if(aboutTab.isDisplayed()&& contactTab.isDisplayed()) {
				isFrameLoaded=true;
			}
		}
		return isFrameLoaded;
	}
	public boolean verifyLastNameChangeInMyProfilePage(WebDriver driver,String lastname) {
		boolean isLastNameChanged=false;
		if(aboutTab.isDisplayed()) {
			aboutTab.click();
			lastName.clear();
			lastName.sendKeys(lastname);
			saveAllButton.click();
			driver.switchTo().parentFrame();
			if(firstNameLastNameDisplayMyProfile.isDisplayed()) {
				String actualName=firstNameLastNameDisplayMyProfile.getText();
				if(actualName.contains(lastname)) {
					isLastNameChanged=true;
				}else {
					System.out.println("Lastname not changed in My profile page");
				}
			}
		}
		return isLastNameChanged;
	}
	public boolean verifyPostCreated(WebDriver driver,String message) {
		boolean isPostCreated=false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(postTextIframe);
			//driver.switchTo().fr
			textToPost.sendKeys(message);
			driver.switchTo().defaultContent();
			if(sharePostButton.isDisplayed()) {
				sharePostButton.click();
				isPostCreated=true;
				System.out.println("post created");
			}
	}
		return isPostCreated;
	}
	public boolean verifyFileUploaded(WebDriver driver, String filepath) {
		boolean isFileUploaded=false;
		if(fileLink.isDisplayed()) {
			fileLink.click();
			if(CommonUtils.waitForElementToBeClickable(driver,uploadFileLink)) {
				uploadFileLink.click();
				}
			if(CommonUtils.waitForElementToBeClickable(driver,chooseFileButton )) {
				chooseFileButton.sendKeys(filepath);
				shareFileButton.click();
				if(CommonUtils.waitForElementToDisappear(driver,spinningWheelShareFile)) {
					if(postedFileName.isDisplayed()) {
						isFileUploaded=true;
					}
				}
			}
		}
		return isFileUploaded;
	}
	
	public void clickOnAddPhotoLink(WebDriver driver) {
		CommonUtils.mouseHover(driver, moderatorSection);
		if(addPhotoLink.isDisplayed()) {
			addPhotoLink.click();
		}
	}
	
	public boolean verifyPhotoUploaded(WebDriver driver,String photoPath) {
		boolean isPhotoUploaded=false;
		this.clickOnAddPhotoLink(driver);
		driver.switchTo().frame(photoUploadIframe);
		if(CommonUtils.waitForElementToBeClickable(driver,choosePhotoFileButton)) {
			choosePhotoFileButton.sendKeys(photoPath);
			savePhotoButton.click();
		}
		if(CommonUtils.waitForElementToDisappear(driver, spinningWheelUploadPhoto)&&
				CommonUtils.waitForElementToBeClickable(driver, savePhotoButton2)) {
			savePhotoButton2.click();
			if(CommonUtils.waitForElementToDisappear(driver, spinningWheelUploadPhoto2)) {
				isPhotoUploaded=true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploaded;
	}
	//My Settings
	
	
	@FindBy(xpath="//span[text()='My Settings']")
	public WebElement mySettingPage;
	
	@FindBy(xpath="//span[@id='PersonalInfo_font']")
	public WebElement personalLink;
	
	@FindBy(xpath="//span[@id='LoginHistory_font']")
	public WebElement loginHistoryLink;
	
	@FindBy(xpath="//div[@class='pShowMore']//child::a")
	public WebElement downloadHistoryLink;
	
	@FindBy(xpath="//h3[@id='RelatedUserLoginHistoryList_title']")
	public WebElement loginHistoryPage;
	
	@FindBy(xpath="//span[@id='DisplayAndLayout_font']")
	public WebElement displayLayoutLink;
	
	@FindBy(xpath="//span[@id='CustomizeTabs_font']")
	public WebElement customizeMyTabsLink;
	
	@FindBy(xpath="//select[@id='p4']")
	public WebElement contentDropDown;
	
	@FindBy(xpath="//label[text()='Available Tabs']")
	public WebElement labelAvailableTabs;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement avaialableTabDropDown;
	
	@FindBy(xpath="//img[@class='rightArrowIcon']")
	public WebElement avaialableTabDropDownAddButton;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	public WebElement selectedTabsDropDown;
	
	@FindBy(xpath="//img[@class='rightArrowIcon']")
	public WebElement addUpArrow;
	
	@FindBy(xpath="//select[@id='duel_select_1']//child::option[@value='report']")
	public WebElement reportOption;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement saveButton;
	
	@FindBy(xpath="//span[@id='tsidLabel']")
	public WebElement contentMenu;
	
	@FindBy(xpath="//a[@title='Reports Tab']")
	public WebElement reportsTab;
	
	@FindBy(xpath="//span[text()='Salesforce Chatter']")
	public WebElement salesforceChatter;
	
	public boolean verifyFileDownload() {
		boolean isFileDownloaded=false;
		
		return isFileDownloaded;
	}
	
	public boolean isMySettingsPagedisplayed() {
		return mySettingPage.isDisplayed();
	}
	
	public boolean verifyLoginHistoryDisplayed(WebDriver driver) {
		boolean isLoginHistoryDisplayed=false;
		if(CommonUtils.waitForElementToBeClickable(driver,personalLink)) {
			personalLink.click();
			if(CommonUtils.waitForElementToBeClickable(driver,loginHistoryLink)) {
				loginHistoryLink.click();
			}
		}if(loginHistoryPage.isDisplayed()&&CommonUtils.waitForElementToBeClickable(driver,downloadHistoryLink)) {
			downloadHistoryLink.click();
			isLoginHistoryDisplayed=true;
		}
		return isLoginHistoryDisplayed;
	}
	
	public boolean verifyReportsFieldAdded(WebDriver driver,String contentdropdownoption,String availabledropdownoption) {
		boolean isReportsTabAdded=false;
		if(CommonUtils.waitForElementToBeClickable(driver,displayLayoutLink)) {
			displayLayoutLink.click();
			customizeMyTabsLink.click();
			}if(contentDropDown.isDisplayed()) {
				CommonUtils.selectDropDown(contentDropDown, contentdropdownoption);
				if(avaialableTabDropDown.isDisplayed()) {
					CommonUtils.selectDropDown(avaialableTabDropDown, availabledropdownoption);
					addUpArrow.click();
				}
			}if(driver.findElement(By.xpath("//option[text()='"+availabledropdownoption+"']")).isDisplayed()) {
				saveButton.click();
			}if(isMySettingsPagedisplayed()&& CommonUtils.waitForElementToBeClickable(driver, contentMenu)) {
				contentMenu.click();
				driver.findElement(By.xpath("//a[text()='"+contentdropdownoption+"']")).click();
				if(CommonUtils.waitForElementToBeClickable(driver, reportsTab)) {
					isReportsTabAdded=true;
				}
			}
		return isReportsTabAdded;
	}
	
	@FindBy(xpath="//span[@id='EmailSetup_font']")
	public WebElement emailLink;
	
	@FindBy(xpath="//span[@id='EmailSettings_font']")
	public WebElement emailSettingsLink;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement emailSettingsPage;
	
	@FindBy(xpath="//input[@id='sender_name']")
	public WebElement emailNameTextBox;
	
	@FindBy(xpath="//input[@id='sender_email']")
	public WebElement emailAddressTextBox;
	
	@FindBy(xpath="//input[@id='auto_bcc1']")
	public WebElement radioButton;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement saveEmailButton;
	
	@FindBy(xpath="//div[@class='messageText']")
	public WebElement message;
	
	
	public boolean verifyEmailSettingsMessage(WebDriver driver, String name, String emailaddress, String emailMessage) {
		boolean isMessageVerified=false;
		if(isMySettingsPagedisplayed()&&CommonUtils.waitForElementToBeClickable(driver, emailLink)) {
			emailLink.click();
			if(CommonUtils.waitForElementToBeClickable(driver, emailSettingsLink)) {
				emailSettingsLink.click();
			}if(emailSettingsPage.isDisplayed()) {
				emailNameTextBox.clear();
				emailNameTextBox.sendKeys(name);
				emailAddressTextBox.clear();
				emailAddressTextBox.sendKeys(emailaddress);
					radioButton.click();
				if(CommonUtils.waitForElementToBeClickable(driver, saveEmailButton)) {
					saveEmailButton.click();
				}
				}
		}
		if(message.isDisplayed()) {
			String actualMessage=message.getText();
			if(actualMessage.equals(emailMessage)){
				isMessageVerified=true;
			}
		}
		return isMessageVerified;
	}
	
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']")
	public WebElement calendarRemaindersLink;
	
	@FindBy(xpath="//span[@id='Reminders_font']")
	public WebElement activityRemainderLink;
	
	@FindBy(xpath="//input[@value='Open a Test Reminder']")
	public WebElement testRemainderLink;
	
	@FindBy(xpath="//input[@value=' Save ']")
	public WebElement saveRemainderButton;
	
	@FindBy(xpath="//div[@class='subject']")
	public WebElement sampleEventLabel;
	
	@FindBy(xpath="//a[text()='Sample Event.']")
	public WebElement sampleEventLink;
	
	public boolean verifyRemainderPopupWindow(WebDriver driver) throws IOException {
		boolean isPopupWindowDisplayed=false;
		if(isMySettingsPagedisplayed()&&CommonUtils.waitForElementToBeClickable(driver, calendarRemaindersLink)) {
			calendarRemaindersLink.click();
		}if(CommonUtils.waitForElementToBeClickable(driver, activityRemainderLink)) {
			activityRemainderLink.click();
		}if(CommonUtils.waitForElementToBeClickable(driver, testRemainderLink)) {
			testRemainderLink.click();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println(allWindowHandles.size());
			// Now iterate using Iterator
			Iterator<String> I1= allWindowHandles.iterator();
			while(I1.hasNext())
			{
				String child_window=I1.next();
				if(!parentWindow.equals(child_window)){
			driver.switchTo().window(child_window);
			System.out.println(driver.switchTo().window(child_window).getTitle());
			isPopupWindowDisplayed=true;
			}
			}
			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindow);
		}
		//if(CommonUtils.waitForElementToBeClickable(driver, sampleEventLink)) 
			//{
				//}
		return isPopupWindowDisplayed;
		}
	
	
	//Developer Console
	
	@FindBy(xpath="//span[@id='editorMenuEntry-btnInnerEl']")
	public WebElement fileButtonDeveloperConsole;
	
	public boolean verifyDeveloperConsoleWindow(WebDriver driver) {
		boolean isDeveloperConsoleWindowPopped=false;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String parentWindow = driver.getWindowHandle();
		logger.info("Parent window is captured");
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles.size());
		Iterator<String> I1= allWindowHandles.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parentWindow.equals(child_window)){
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		logger.info("WebDriver switches to the child window");
		driver.close();
		logger.info("Child window is closed");
		isDeveloperConsoleWindowPopped=true;
		}
	
		}return isDeveloperConsoleWindowPopped;
	}
	
	public boolean verifyLoginPageDisplayed(WebDriver driver, String expectedTitle) {
		boolean isLoginPageDisplayed=false;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			isLoginPageDisplayed=true;
		}
		logger.info("Login page is displayed");
		return isLoginPageDisplayed;
	}
	
	
	
	
	
	
	
	
	
}
