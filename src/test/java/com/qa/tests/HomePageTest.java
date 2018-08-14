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
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil util;

	public HomePageTest() {
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
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Title is not Getting matched!!!");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		util.switchToFrame();
		Assert.assertTrue(homePage.veriyUserName(), "User name is not getting matched!!!");
	}

	@Test(priority = 3)
	public void verifyClickContactTest() {
		util.switchToFrame();
		contactPage = homePage.clickContact();
	}

}
