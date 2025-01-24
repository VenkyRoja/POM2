package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.MyBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;

public class LoginPageTest extends MyBase {
	
	LoginPage  loginpage;
	HomePage   homepage;
	SignUpPage signuppage;

	//--------1--------------------
	public LoginPageTest() {
		
		super();
	}
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		loginpage = new LoginPage();
	}

	//--------3.1--------------------
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		System.out.println(" ==== newcontactOptionTest ==== " );

		String title = loginpage.fetchTitle();
		String expectedTitle = prop.getProperty("ExpectedLoginPageTitle");
		
		Assert.assertEquals(title, expectedTitle, "Title of Login Page did not match!");
	}
	
	//--------3.2--------------------
	@Test(priority=2)
	public void loginTest() {
		
		System.out.println(" ==== loginTest ==== " );

		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		homepage = loginpage.login(uname, pwd);
		
	}

	
	//--------3.3--------------------
	@Test(priority=3)
	public void signuplinkTest() {
		System.out.println(" ==== loginpage:signuplinkTest ==== " );
		signuppage = loginpage.clickOnSignUpLink();
		
	}	
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		d.quit();

	}
	
	//-----------------------------

}
