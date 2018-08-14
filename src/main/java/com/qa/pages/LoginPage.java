package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//img[@alt='free crm logo']")
	WebElement appLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateCRMLogo() {
		return appLogo.isDisplayed();
	}

	public HomePage login(String userId, String passWd) {
		userName.sendKeys(userId);
		passWord.sendKeys(passWd);
		loginButton.click();
		return new HomePage();
	}
}
