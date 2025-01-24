package com.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MyBase;
import com.util.TestUtil;

public class viewContactPage  extends MyBase {

 	//<span class="selectable "> Contacts</span>
    //<div class="ui header item mb5 light-black"><div class="ui loader"></div><span class="selectable "> Contacts</span></div>
	//@FindBy(xpath="//span[@class='selectable'][text()='Contacts']")	
    @FindBy(xpath="//div[@class='ui header item mb5 light-black']")	
	WebElement contactslabel;   

	//<button class="ui linkedin button"><i aria-hidden="true" class="edit icon"></i>Create</button>
	@FindBy(xpath="//button[@class='ui linkedin button'][text()='Create']")
	WebElement addContactsLink;

    //------------1-------------Constructor---------
	public viewContactPage() {
		
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


    //------------4-------------Action--------------
	public boolean istheContactChecked(String contactName) throws InterruptedException {
		
		WebElement contactsCheckBox = d.findElement(By.xpath("//a[text()='" + contactName + "']"
			                                                    + "//parent::td"
				                                                + "//preceding-sibling::td"
			                                                    + "//input[@name='id']"));
	

		TestUtil.clickElementByJs(d,contactsCheckBox);
		
		boolean b = contactsCheckBox.isSelected();
		return b;
		
	}	

    //------------4-------------Action--------------
    public addContactsPage clickOCreateButton() {

		addContactsLink.click();
		
		return new addContactsPage();
		
	}

}
