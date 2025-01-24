package com.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.MyBase;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import com.util.TestUtil;

public class SignUpPageTest extends MyBase  {
	
	SignUpPage signuppage;
	LoginPage  loginpage;
	String     signupsheet = "SignUp";
	
	//--------1--------------------
	public SignUpPageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		loginpage = new LoginPage();
		signuppage = loginpage.clickOnSignUpLink();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void signupPageURLTest() {

		System.out.println(" ==== signupPageURLTest ==== " );
		
		String currentURL = signuppage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedSignUpPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Signup Page URL did not match!");
	}	
	
	//--------3.2.1--------------------
	@DataProvider
	public Object[][] getSignUpData() throws InvalidFormatException {
		
		Object data[][] = TestUtil.getDataFromExcel(signupsheet);
		return data;
	}
	
	
	//--------3.2.2--------------------
	@Test(priority=2, dataProvider="getSignUpData")
	public void registrationTest(String email, String countrycode, String phonenumber) {

		System.out.println(" ==== registrationTest ==== " + email + " == " + countrycode + " == " +  phonenumber + " =====" );
	
		String returnMsg = signuppage.registerUser(email, countrycode, phonenumber);
		
		String expectedUreturnMsg= prop.getProperty("ExpectedSignUpMessage");
		
		Assert.assertEquals(returnMsg, expectedUreturnMsg);	
		
	}	

	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		d.quit();

	}	
	
	//------------------------------
	

}
