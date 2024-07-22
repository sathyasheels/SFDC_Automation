package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {
public static boolean waitForElementToBeClickable(WebDriver driver, WebElement element)
{
	boolean isElementClickable=false;
	WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT_TOBECLICKABLE);
	try
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		isElementClickable=true;
	}
	catch (Exception e){
		e.printStackTrace();
	}
	return isElementClickable;
}

public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
	boolean isElementInvisible=false;
	WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT_TODISAPPEAR);
	try {
		wait.until(ExpectedConditions.invisibilityOf(element));
		isElementInvisible=true;
		}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return isElementInvisible;
}
public static void mouseHover(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
}

public static void selectDropDown(WebElement element, String text) {
	Select select=new Select(element);
	select.selectByVisibleText(text);
	//select.selectByValue(text);
	//select.selectByIndex(1);

}

public static String selectDefaultView(WebElement element) {
	Select item=new Select(element);
	String text=item.getFirstSelectedOption().getText();
	return text;
}

public static boolean waitForWindowToPopup(WebDriver driver, String title) {
	boolean isWindowPopped=false;
	WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_WINDOW_TOPOPUP);
	try {
		wait.until(ExpectedConditions.titleContains(title));
		isWindowPopped=true;
		}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return isWindowPopped;
}

public static String  getScreenshot(WebDriver driver) {
	String filepath=FileConstants.SCREENSHOTS_FOLDER_PATH;
	TakesScreenshot screen=(TakesScreenshot)driver;
	File src=screen.getScreenshotAs(OutputType.FILE);
	File dst=new File(filepath);
	src.renameTo(dst);
	return filepath;
}

public static String getCurrentTimestamp() {
	return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
}











}
