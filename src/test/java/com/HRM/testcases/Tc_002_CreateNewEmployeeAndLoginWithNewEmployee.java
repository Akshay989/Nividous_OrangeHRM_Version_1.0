package com.HRM.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.pages.HRM_HomePage;
import com.HRM.pages.HRM_LoginPage;
import com.HRM.pages.HRM_PIM;
import com.HRM.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class Tc_002_CreateNewEmployeeAndLoginWithNewEmployee extends BaseClass

{
	HRM_PIM pim;
	HRM_LoginPage lp;
	HRM_HomePage hp;

	@Test(priority=1)
	public void set_LoginCredentials()
	{
		
		String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		lp = new HRM_LoginPage(driver);
		setLogger(currenMethodName);
			
		lp.setUserName(userName);
		log.info("Username is set");
		customLogger(Status.PASS, "Username is set successfully");
		lp.setPassWord(passWord);
		customLogger(Status.PASS, "Password is set successfully");
		log.info("Password is set");	
	}
	
	@Test(priority=2)
	public void click_onLoginButton()
	{
		String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		setLogger(currenMethodName);
		lp.clickOnLoginButton();
		log.info("Clicked on the login button");
		customLogger(Status.INFO, "User Clicked on the login button");
	}
	
  @Test(priority=3)
  public void creatingNewUser()  throws Exception
  {
	  
	  String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
	  setLogger(currenMethodName);
	  
	  pim = new HRM_PIM(driver);
	  
	  pim.clickOnPIMTab();
	  log.info("User Clicked on PIM Tab"); //log4j
	  customLogger(Status.PASS, "User Clicked on PIM Tab"); //extentReport logs
	  pim.clickOnAddEmployee();
	  log.info("User Clicked on Add Employee"); //log4j
	  customLogger(Status.PASS, "User Clicked on Add Employee"); //extentReport logs
	  pim.setFirstName("DEMO");
	  log.info("FirstName is set");
	  customLogger(Status.PASS, "FirstName is set successfully");
	  pim.setMiddleName("QA");
	  log.info("MiddleName is set");
	  customLogger(Status.PASS, "MiddleName is set successfully");
	  pim.setLastName("TEST06");
	  log.info("LastName is set");
	  customLogger(Status.PASS, "LastName is set successfully");
	  pim.setEmployeID("0392");
	  log.info("EmployeeID is set");
	  customLogger(Status.PASS, "EmployeeID is set successfully");
	  pim.clickOnLoginDetails();
	  log.info("User Clicked on LoginDetails Checkbox"); //log4j
	  customLogger(Status.PASS, "User Clicked on LoginDetails Checkbox"); //extentReport logs
	  pim.setUsername("DEMOTEST06");
	  log.info("Username is set");
	  customLogger(Status.PASS, "Username is set successfully");
	  pim.setPassword("Test1234");
	  log.info("Password is set");
	  customLogger(Status.PASS, "Password is set successfully");
	  pim.setConfirmPassword("Test1234");
	  log.info("ConfirmPassword is set");
	  customLogger(Status.PASS, "ConfirmPassword is set successfully");
	  pim.clickOnSaveButton();
	  Thread.sleep(3000);
	  log.info("User Clicked on saveButton"); //log4j
	  customLogger(Status.PASS, "User Clicked on SaveButton"); //extentReport logs	   
  }
  
  @Test(priority=4)
  public void logOutFromHRMApplication()  throws Exception
  {
	  String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
	  setLogger(currenMethodName);
	  hp = new HRM_HomePage(driver);
	  hp.clickOnWelcomeOption();
	  Thread.sleep(5000);
	  hp.clickOnLogOutButton();
	  log.info("Clicked on the logout button");
	 customLogger(Status.INFO, "User Clicked on the Logout button");
  }
  
  @Test(priority=5)
  public void loginWithNewlyCreatedUser()  
  {
	  	String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		lp = new HRM_LoginPage(driver);
		setLogger(currenMethodName);
			
		lp.setUserName("DEMOTEST06");
		log.info("Username is set");
		customLogger(Status.PASS, "Username is set successfully");
		lp.setPassWord("Test1234");
		customLogger(Status.PASS, "Password is set successfully");
		log.info("Password is set");	
		lp.clickOnLoginButton();
		log.info("Clicked on the login button");
		customLogger(Status.INFO, "User Clicked on the login button");

		String expectedTitle = "OrangeHRM";
		setLogger(currenMethodName);
		if (driver.getTitle().equals(expectedTitle)) 
		{		
			log.info("Actual Title : "+driver.getTitle()+" Matched with Expected title : "+expectedTitle);
			customLogger(Status.PASS, "Actual Title : "+driver.getTitle()+" Matched with Expected title : "+expectedTitle);
			Assert.assertTrue(true, "Expected Title & Actual Title matched");
		} else 
		{
			takeScreenshot(currenMethodName, driver);
			log.info("Actual Title : "+driver.getTitle()+" did not match with Expected title : "+expectedTitle);
			customLogger(Status.FAIL,"Actual Title : "+driver.getTitle()+" did not match with Expected title : "+expectedTitle);
			Assert.assertTrue(false, "Expected Title & Actual Title did not match");
		}
  }
  
}
