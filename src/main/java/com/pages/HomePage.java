package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MyBase;

public class HomePage extends MyBase  {

	//--------Page Factory-------------Object Repository------------
		
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernamedisplay;	

	@FindBy(xpath="//span[@class='item-text'][text()='Contacts']")
	WebElement contactsMenuOption;		
	
	@FindBy(xpath="//span[@class='item-text'][text()='Deals']")
	WebElement dealsMenuOption;		

	@FindBy(xpath="//span[@class='item-text'][text()='Tasks']")
	WebElement tasksMenuOption;		

	//@FindBy(xpath="//a[contains(@href, 'contacts')][@class='item']//following-sibling::button")
	//<span class="item-text">Contacts</span>
	//<button class="ui linkedin button"><i aria-hidden="true" class="edit icon"></i>Create</button>
	//@FindBy(xpath="//button[@class='ui linkedin button'][text()='Create']")
	//WebElement addContactsLink;		
	
	@FindBy(xpath="//span[@class='item-text'][text()='Contacts']")
	WebElement viewContactsLink;		
	

	//------------1-------------Constructor---------
	public HomePage() {
		
		PageFactory.initElements(d, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = d.getCurrentUrl();
		return currentURL;
	}
	

	//------------3-------------Action--------------
	public viewContactPage clickOnContactsMenuOption() {

		contactsMenuOption.click();
		
		return new viewContactPage();
		
	}	
	
	//------------4-------------Action--------------
	public DealsPage clickOnDealsMenuOption() {

		dealsMenuOption.click();
		
		return new DealsPage();
		
	}	

	
	//------------5-------------Action--------------
	public TasksPage clickOnTasksMenuOption() {

		tasksMenuOption.click();
		
		return new TasksPage();
		
	}		

	//------------2-------------Action--------------
	public String fetchUsernameDisplay() {
		String unamedisplay = usernamedisplay.getText();
		return unamedisplay;
	}
	
/* 
	//------------5-------------Action--------------
	public viewContactPage clickOnNewContactOption() {

		viewContactsLink.click();
		
		return new viewContactPage();
		
	}		
*/
	
	//-----------------------------------------------
	
}
