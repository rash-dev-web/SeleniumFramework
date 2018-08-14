package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath = "//*[contains(text(),'User: Naveen K')]")
	WebElement userName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean veriyUserName(){
		return userName.isDisplayed();
	}
	
	public ContactPage clickContact(){
		contactLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickDeals(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickTask(){
		tasksLink.click();
		return new TaskPage();
	}
}
