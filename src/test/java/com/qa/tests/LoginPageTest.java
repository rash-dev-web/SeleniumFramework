package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.TestListener;
import com.qa.utility.TestRetryAnalyzer;

@Listeners(TestListener.class)
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		launchApp();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service",
				"Title is not getting matched!!!");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag, "Logo is not Getting matched!!!");
	}

	@Test(priority = 3, retryAnalyzer = TestRetryAnalyzer.class)
	public void loginTest() {
		homePage = loginPage.login(pro.getProperty("userName"), pro.getProperty("passWord"));

	}
}
