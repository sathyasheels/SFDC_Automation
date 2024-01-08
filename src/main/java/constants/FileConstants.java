package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String TEST_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.properties";
	public static final String USERMENU_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\UserMenuData.properties";
	public static final String PATH_OF_FILE_TO_POST="C:\\Users\\sathy\\Desktop\\GSMA 17127758888.txt";
	public static final String PATH_OF_PHOTO_TO_ADD="C:\\Users\\sathy\\Desktop\\Screenshot 2023-07-20 134542.png";
	public static final String OPPURTUNITY_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\OppurtunityData.properties";
	public static final String LEADS_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\LeadsData.properties";
	public static final String ACCOUNT_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\AccountData.properties";
	public static final String CONTACTS_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\ContactsData.properties";
	public static final String RANSCENARIOS_DATA_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\RanScenariosData.properties";
	public static final String SCREENSHOTS_FOLDER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+CommonUtils.getCurrentTimestamp()+".PNG";
	public static final String REPORTS_FOLDER_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\"+CommonUtils.getCurrentTimestamp()+".html";
}
