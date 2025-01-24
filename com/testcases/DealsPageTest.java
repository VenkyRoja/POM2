package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.MyBase;

import com.pages.DealsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class DealsPageTest extends MyBase  {
	
	LoginPage loginpage;
	HomePage  homepage;
	DealsPage dealspage;
	
	//--------1--------------------
	public DealsPageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		dealspage = new DealsPage();

		loginpage = new LoginPage();
		
		homepage = loginpage.login(uname, pwd);
		
		dealspage = homepage.clickOnDealsMenuOption();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void dealsPageURLTest() {
		
		System.out.println(" ==== dealsPageURLTest ==== " );

		String currentURL = dealspage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedDealsPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Deals Page URL did not match!");
	}	

	//--------3.2--------------------
	@Test(priority=2)
	public void dealsLabelDisplayTest() {

		System.out.println(" ==== dealsLabelDisplayTest ==== " );
		
		boolean b = dealspage.isDealsLabelDisplayed();
		
		Assert.assertTrue(b,"Deals label on Deals page is NOT displayed!");
	}		
	

	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		d.quit();

	}	
	
	//------------------------------

}
