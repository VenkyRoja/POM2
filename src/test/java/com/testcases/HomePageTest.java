package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.MyBase;
import com.pages.viewContactPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class HomePageTest extends MyBase  {
	
	LoginPage         loginpage;
	HomePage          homepage;
	viewContactPage   viewcontactpage;
	
	//--------1--------------------
	public HomePageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		viewcontactpage = new viewContactPage();

		loginpage = new LoginPage();
		
		homepage = loginpage.login(uname, pwd);
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void homePageURLTest() {

		System.out.println(" ==== homePageURLTest ==== " );
		
		String currentURL = homepage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedHomePageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Home Page URL did not match!");
	}	

	//--------3.2--------------------
	@Test(priority=2)
	public void homePageUsernameDisplayTest() {

		System.out.println(" ==== homePageUsernameDisplayTest ==== " );
		
		String unamedispay = homepage.fetchUsernameDisplay();
		String expectedunamedispay= prop.getProperty("ExpectedHomePageUsernameDisplay");
		
		Assert.assertEquals(unamedispay, expectedunamedispay, "User name on Home Page did not match!");
	}		
	
	//--------3.3--------------------
	@Test(priority=3)
	public void contactsOptionTest() {
		
		System.out.println(" ==== homepage:contactsOptionTest ==== " );

		viewcontactpage = homepage.clickOnContactsMenuOption();
		
	}
	
/* 
	//--------3.4--------------------
	@Test(priority=4)
	public void newcontactOptionTest() {
		System.out.println(" ==== homepage:newcontactOptionTest ==== " );
		contactspage = homepage.clickOnNewContactOption();
		
	}
*/
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		d.quit();

	}	
	
	//------------------------------
}
