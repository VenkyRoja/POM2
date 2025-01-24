package com.pages;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MyBase;
//import com.util.TestUtil;


public class addContactsPage extends MyBase  {
	
	//--------Page Factory-------------Object Repository------------
	
	//<span class="selectable "> Contacts</span>
	
	//<span class="selectable "> Create New Contact</span>
	@FindBy(xpath="//span[@class='selectable'][text()='Create New Contact']")	
	WebElement contactslabel;	
	
	@FindBy(xpath="//th[text()='Address']")
	WebElement addresslabel;	
	
	//--new contact---
	@FindBy(name="first_name")
	WebElement firstnameInput;

	@FindBy(name="last_name")
	WebElement lastnameInput;

	@FindBy(xpath="//input[@class='search'][@type='text']")
	WebElement companyInput;	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;	
	
	//<div class="ui header item mb5 light-black"><div class="ui loader"></div><span class="selectable "><i class="large user red icon"></i> Test3 Test3</span></div>
	@FindBy(xpath="//div[contains(@class, 'ui header item mb5 light-black')]")
	WebElement namelabel;	
	

	//------------1-------------Constructor---------
	public addContactsPage() {
		
		PageFactory.initElements(d, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = d.getCurrentUrl();
		return currentURL;
	}
	
	
	//------------3-------------Action--------------
	public boolean isContactsLabeleDisplayed() {
		
		boolean b = contactslabel.isDisplayed();
		return b;
	}

	
	//------------5-------------Action--------------
	public void addContact(String fn, String ln, String company) {
		
		firstnameInput.sendKeys(fn);
		lastnameInput.sendKeys(ln);
		companyInput.sendKeys(company);
		
		saveButton.click();

	}
	
	//------------6-------------Action--------------
	public String fetchLabelName() {
		String labelName = namelabel.getDomAttribute("innerText");
		return labelName;
	}	

	
	//----------------------------------------------
}
