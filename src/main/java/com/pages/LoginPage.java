package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MyBase;

public class LoginPage extends MyBase {
	
	//--------Page Factory-------------Object Repository------------
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signup;	
	
	//------------1-------------Constructor---------
	public LoginPage() {
		
		PageFactory.initElements(d, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchTitle() {
		String title = d.getTitle();
		return title;
	}
	
	//------------3-------------Action--------------
	public HomePage login(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
	}
	
	//------------4-------------Action--------------
	public SignUpPage clickOnSignUpLink() {

		signup.click();
		
		return new SignUpPage();
		
	}	

	//-----------------------------------------------
	
	
}
