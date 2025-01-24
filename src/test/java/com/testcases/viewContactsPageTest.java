package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.MyBase;
import com.pages.viewContactPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.addContactsPage;

public class viewContactsPageTest extends MyBase   {

	LoginPage          loginpage;
	HomePage           homepage;
	viewContactPage    viewcontactpage;
	addContactsPage    addcontactspage;
	
	//--------1--------------------
	public viewContactsPageTest() {
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");

		loginpage = new LoginPage();
		
		homepage = loginpage.login(uname, pwd);
		
		viewcontactpage = homepage.clickOnContactsMenuOption();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void viewcontactPageURLTest() {

		System.out.println(" ==== viewcontactPageURLTest ==== " );
		
		String currentURL = viewcontactpage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedContactsPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Contact Page URL did not match!");
	}	


	//--------3.2--------------------
	@Test(priority=2)
	public void viewcontactsPageContactsLabelTest() {

		System.out.println(" ==== viewcontactsPageContactsLabelTest ==== " );
		
		boolean b = viewcontactpage.isContactsLabeleDisplayed();
		
		Assert.assertTrue(b,"Contacts label on Contacts page is NOT displayed!");
	}		
	


	//--------3.3--------------------
	@Test(priority=3)
	public void viewcontactsPageCheckBoxTest() throws InterruptedException {

		System.out.println(" ==== viewcontactsPageCheckBoxTest ==== " );
		
		String cname = prop.getProperty("ContactName2");
		
		boolean b = viewcontactpage.istheContactChecked(cname);
		
		Assert.assertTrue(b,"Contact name" + cname + "on Contacts page is NOT selected!");
	}		
		

	
	//--------3.4--------------------
	@Test(priority=4)
	public void viewcontactsPageCheckBoxesTest() throws InterruptedException {

		System.out.println(" ==== viewcontactsPageCheckBoxesTest ==== " );
		
		String cname1 = prop.getProperty("ContactName1");
		String cname2 = prop.getProperty("ContactName2");
		String cname3 = prop.getProperty("ContactName3");
		
		boolean b1 = viewcontactpage.istheContactChecked(cname1);
		boolean b2 = viewcontactpage.istheContactChecked(cname2);
		boolean b3 = viewcontactpage.istheContactChecked(cname3);
		
		Assert.assertTrue(b1,"Contact name " + cname1 + "on Contacts page is NOT selected!");
		Assert.assertTrue(b2,"Contact name " + cname2 + "on Contacts page is NOT selected!");
		Assert.assertTrue(b3,"Contact name " + cname3 + "on Contacts page is NOT selected!");
	}		
			
	//--------3.3--------------------
	@Test(priority=5)
	public void createContactTest() {
		System.out.println(" ==== createContactTest ==== " );
		
		addcontactspage = viewcontactpage.clickOCreateButton();

	}
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		d.quit();

	}		
	
}
