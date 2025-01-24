package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.MyBase;

public class DealsPage extends MyBase  {

	//--------Page Factory-------------Object Repository------------
	
	@FindBy(xpath="//div[contains(@class, 'ui header')]")
	WebElement dealsLabel;	
	
	//------------1-------------Constructor---------
	public DealsPage() {
		
		PageFactory.initElements(d, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = d.getCurrentUrl();
		return currentURL;
	}	
	
	//------------3-------------Action--------------
	public boolean isDealsLabelDisplayed() {
		
		boolean b = dealsLabel.isDisplayed();
		return b;
	}
	
	
}
