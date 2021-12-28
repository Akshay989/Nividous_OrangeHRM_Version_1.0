package com.HRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 

{
	Properties po;
	
	public ReadConfig() 
	{
		File src = new File(".\\Configurations\\config.properties");		
		try {
			FileInputStream fi = new FileInputStream(src);
			po = new Properties();
			po.load(fi);
			
		} catch (Exception e) 
		{
			System.out.println("Unable to load file: "+e);
		}
	}
	
	
	public String getAppURL()
	{ 
		String value = null; 
		try
		{
		value = po.getProperty("HRM_url");
	
		}
		catch (Exception e)
		{
			System.out.println("Unable to find URL in Properties file: "+e);
		}
		return value;
	}
	
	public String getUsername()
	{ 
		String value = null; 
		try
		{
		value = po.getProperty("username");
	
		}
		catch (Exception e)
		{
			System.out.println("Unable to find username in Properties file: "+e);
		}
		return value;
	}
	
	public String getPassword()
	{ 
		String value = null; 
		try
		{
		value = po.getProperty("password");
	
		}
		catch (Exception e)
		{
			System.out.println("Unable to find password in Properties file: "+e);
		}
		return value;
	}
	
	public String getChromeDriverPath()
	{ 
		String value = null; 
		try
		{
		value = po.getProperty("chrome");
	
		}
		catch (Exception e)
		{
			System.out.println("Unable to find Chrome Driver path in Properties file: "+e);
		}
		return value;
	}
	
	public String getFireFoxDriverPath()
	{ 
		String value = null; 
		try
		{
		value = po.getProperty("firefox");
	
		}
		catch (Exception e)
		{
			System.out.println("Unable to find Chrome Driver path in Properties file: "+e);
		}
		return value;
	}
	
}
