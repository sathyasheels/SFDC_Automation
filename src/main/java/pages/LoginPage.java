package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
    public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(name="Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id="error")
	public WebElement errorMessage;
	
	@FindBy(partialLinkText="Forgot")
	public WebElement forgotPassword;
	
	@FindBy(xpath="//span[text()='sheela@hexaware.com']")
	public WebElement savedUsername;
	
	@FindBy(xpath="//input[@id='un']")
	public WebElement forgotUsernameTextbox;
	
	public void enterUserName(String uname)
	{
		if(username.isDisplayed())
		{
			username.sendKeys(uname);
		}
		else 
		{
			System.out.println("Username webelement is not found");
		}
	}
	public void enterPassword(String pwd)
	{
		if(username.isDisplayed())
		{
			username.sendKeys(pwd);
		}
		else 
		{
			System.out.println("Password webelement is not found");
		}
	}
	public void clickLoginButton()
	{
		if(loginButton.isDisplayed())
		{
			loginButton.click();
		}
		else 
		{
			System.out.println("LoginButton webelement is not found");
		}
	}
	public void selectRememberMeCheckbox()
	{
		if(!rememberMe.isSelected())
		{
			rememberMe.click();
		}
		else 
		{
			System.out.println("RememberMe check box not already selected");
		}
	}
	public String getUserName() {
		return username.getText();
	}
	public String getPassword() {
		return password.getText();
	}
	
	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.readTestData("test.app.url"));
		driver.manage().window().maximize();
		if(CommonUtils.waitForElementToBeClickable(driver, username)) {
			username.sendKeys(FileUtils.readTestData("test.username"));
			password.sendKeys(FileUtils.readTestData("test.password"));
			loginButton.click();
		}else {
			System.out.println("Login is failed");
		}
	}
	
	public boolean verifyErrorMessageOngivingInvalidPassword(String name,String pwd,String expectederrormessage) {
		boolean isErrorMessageDisplayedCorrectly=false;
		if(username.isDisplayed()) {
			username.sendKeys(name);
			password.clear();
			password.sendKeys(pwd);
			loginButton.click();
		}if(errorMessage.isDisplayed()) {
			String actualErrMessage=errorMessage.getText();
			if(actualErrMessage.equals(expectederrormessage)) {
				isErrorMessageDisplayedCorrectly=true;
			}
		}
		return isErrorMessageDisplayedCorrectly;
	}
	
	
	@FindBy(xpath="//span[@class='helpLink']")
	public WebElement landingPage;
	
	public boolean verifyLoginSuccessful(String name,String pwd) {
		boolean isLoginSuccessful=false;
		if(username.isDisplayed()) {
			username.sendKeys(name);
			password.clear();
			password.sendKeys(pwd);
			loginButton.click();
		}if(landingPage.isDisplayed()) {
			isLoginSuccessful=true;
		}
		return isLoginSuccessful;
	}
	
	
	@FindBy(xpath="//span[@class='menuButtonLabel']")
	public WebElement userMenuLink;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[5]")
	public WebElement logoutOption;
	
	public boolean verifyLoginSuccessfulWithRemembermeChecked(String name,String pwd) {
		boolean isLoginSuccessfulWithRemembermeChecked=false;
		if(username.isDisplayed()) {
			username.sendKeys(name);
			password.clear();
			password.sendKeys(pwd);
			selectRememberMeCheckbox();
			loginButton.click();
		}if(landingPage.isDisplayed()) {
			isLoginSuccessfulWithRemembermeChecked=true;
		}
		return isLoginSuccessfulWithRemembermeChecked;
	}
	
	
	@FindBy(xpath="//title[text()='Login | Salesforce']")
	public WebElement loginPage;
	
	
	
	
	@FindBy(xpath="//a[@id='forgot_password_link']")
	public WebElement forgotYourPasswordlink;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	public WebElement usernamefield;
	
	@FindBy(xpath="//img[@class='clearicon']")
	public WebElement closeImageIcon;
	
	@FindBy(xpath="//a[text()='1 Saved Username']")
	public WebElement saveUsernameMessage;
	
	public boolean verifyRemembermeCheckedOnLogout(String username) throws IOException {
		boolean isRemembermeCheckedOnLogout=false;
		boolean isUsernamedisplayed=false;
		boolean isRemembermeChecked=false;
		if(userMenuLink.isDisplayed()) {
			userMenuLink.click();
			logoutOption.click();
		}try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(forgotYourPasswordlink.isDisplayed()) {
			if(usernamefield.isDisplayed()){
				String actualusername=usernamefield.getText();
				System.out.println(actualusername);
				if(actualusername.equals(username)) {
					isUsernamedisplayed=true;
				}
			}if(rememberMe.isSelected()) {
				isRemembermeChecked=true;
			}
		}if(isUsernamedisplayed&&isRemembermeChecked) {
			isRemembermeCheckedOnLogout=true;
		}
		return isRemembermeCheckedOnLogout;
	}
	
	
	public boolean verifySavedUsernameMessageDisplayed(String expectedusernamemessage) {
		boolean isSavedUsernameMessageDisplayed=false;
		boolean isCloseIconDisplayed=false;
		boolean areBothAboveValidated=false;
		if(saveUsernameMessage.isDisplayed()) {
			String actualusernamemessage=saveUsernameMessage.getText();
			if(actualusernamemessage.equals(expectedusernamemessage)) {
				isSavedUsernameMessageDisplayed=true;
			}
		}if(closeImageIcon.isDisplayed()) {
			isCloseIconDisplayed=true;
		}
		if(isSavedUsernameMessageDisplayed&&isCloseIconDisplayed) {
			areBothAboveValidated=true;
		}
		return areBothAboveValidated;
	}
	
	
	
	@FindBy(xpath="//h1[text()='Forgot Your Password']")
	public WebElement forgotYourPasswordPage;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement forgotContinueButton;
	
	@FindBy(xpath="//h1[text()='Check Your Email']")
	public WebElement checkYouremailPage;
	
	public boolean verifyForgotPasswordPageDisplayed() {
		boolean isForgotPasswordPageDisplayed=false;
		if(forgotYourPasswordlink.isDisplayed()) {
			forgotYourPasswordlink.click();
		}
		if(forgotYourPasswordPage.isDisplayed()) {
			isForgotPasswordPageDisplayed=true;
		}
		return isForgotPasswordPageDisplayed;
	}
	
	public boolean verifyCheckYourEmailPageDisplayed(String name) {
		boolean isCheckYourEmailPageDisplayed=false;
		if(forgotYourPasswordPage.isDisplayed()) {
			if(forgotUsernameTextbox.isDisplayed()) {
				forgotUsernameTextbox.sendKeys(name);
				forgotContinueButton.click();
			}
		}if(checkYouremailPage.isDisplayed()) {
			isCheckYourEmailPageDisplayed=true;
		}
		return isCheckYourEmailPageDisplayed;
	}
	
	@FindBy(xpath="//form[@id='login_form']//child::div[@class='loginError']")
	public WebElement errorMessage2;
	
	public boolean verifyErrorMessageForInvalidUsernamePasswordDisplayed(String Invalidname,String InvalidPwd, String expectederrormessage2) {
		boolean isErrorMessageForInvalidUsernamePasswordDisplayed=false;
		if(username.isDisplayed()) {
			username.sendKeys(Invalidname);
			password.sendKeys(InvalidPwd);
			loginButton.click();
			}if(errorMessage2.isDisplayed()) {
				String actaualerrormessage2=errorMessage2.getText();
				if(actaualerrormessage2.equals(expectederrormessage2)) {
					isErrorMessageForInvalidUsernamePasswordDisplayed=true;
				}
			}
		return isErrorMessageForInvalidUsernamePasswordDisplayed;
	}
	
	
	
	
	
	
	
	
	
	
}
