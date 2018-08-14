package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.TestListener;
import com.qa.utility.TestUtil;

@Listeners(TestListener.class)
public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil util;
	
	public ContactPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		launchApp();
		util = new TestUtil();
		contactPage = new ContactPage();
		loginPage = new LoginPage();
		util.swithchToIframe();
		util.switchToDefault();
		homePage = loginPage.login(pro.getProperty("userName"), pro.getProperty("passWord"));
		util.switchToFrame();
		contactPage=homePage.clickContact();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabelTest(){
		Assert.assertTrue(contactPage.verifyContactLabel(),"Contact label is missing on the page!!!");
	}
	
	@Test(priority=2)
	public void selectContactTest(){
		contactPage.selectContactByName("Angelinax Jolie");
	}
}
