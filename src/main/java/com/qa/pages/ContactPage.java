package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class ContactPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[contains(text(), 'Angelinax Jolie')]")
	WebElement contactLabel;
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel(){
		return userNameLabel.isDisplayed();
	}
	
	public void selectContactByName(String name){
		driver.findElement(By.xpath("//*[contains(text(), '"+name+"')]")).click();
	}
}
