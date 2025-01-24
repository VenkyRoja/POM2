package com.testcases;

import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.MyBase;
import com.pages.viewContactPage;
import com.util.TestUtil;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.addContactsPage;

public class addContactPageTest extends MyBase {

	LoginPage          loginpage;
	HomePage           homepage;
	viewContactPage    viewcontactpage;
	addContactsPage    addcontactspage;
	String             contactsheet = "Contacts";

	//--------1--------------------
	public addContactPageTest() {
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

		addcontactspage = viewcontactpage.clickOCreateButton();
		
	}    

//--------3.5.1--------------------
	@DataProvider
	public Object[][] getContactsData() throws InvalidFormatException {
		
		Object data[][] = TestUtil.getDataFromExcel(contactsheet);
		return data;
	}
	

	//--------3.5.2--------------------
	@Test(priority=1, dataProvider="getContactsData")
	public void addContactsTest(String fname, String lname, String company )  {

		System.out.println(" ==== addContactsTest ==== " + fname + " == " + lname + " == " + company + " ====== ");
		addcontactspage.addContact(fname, lname, company);

		Duration duration = Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_MILLISECONDS);
		TestUtil.waitforPageLoad(d, duration);
		
		//String labelName = addcontactspage.fetchLabelName();
		//System.out.println(labelName);
		//Assert.assertEquals(labelName, fname + " " + lname);
	}		

	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		d.quit();
	}	


}
