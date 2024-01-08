package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	public static String readTestData(String testData) throws IOException
	{
		
		FileInputStream f=new FileInputStream(FileConstants.TEST_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
		
	}
	
	public static String readUserMenuData(String testData) throws IOException
	{
		
		FileInputStream f=new FileInputStream(FileConstants.USERMENU_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
		
	}
	public static String readOppurtunityData(String testData) throws IOException
	{
		
		FileInputStream f=new FileInputStream(FileConstants.OPPURTUNITY_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
		
	}
	public static String readLeadsData(String testData) throws IOException
	{
		
		FileInputStream f=new FileInputStream(FileConstants.LEADS_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
		
	}
	public static String readAccountData(String testData) throws IOException
	{
		FileInputStream f=new FileInputStream(FileConstants.ACCOUNT_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
	}
	
	public static String readContactsData(String testData) throws IOException
	{
		FileInputStream f=new FileInputStream(FileConstants.CONTACTS_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
	}
	
	public static String readRanScenariosData(String testData) throws IOException
	{
		FileInputStream f=new FileInputStream(FileConstants.RANSCENARIOS_DATA_FILE_PATH);
		Properties p=new Properties();
		p.load(f);
		return p.getProperty(testData);
	}

}


