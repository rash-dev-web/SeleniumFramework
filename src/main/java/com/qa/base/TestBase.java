package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.qa.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public Properties pro;
	File file;
	FileInputStream fis;

	public TestBase() {
		try {
			file = new File(
					"C:\\Users\\Rasheed\\workspace\\framework\\src\\main\\java\\com\\qa\\config\\config.properties");
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void initialization() {
		if ((pro.getProperty("browser")).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Rasheed\\workspace\\framework\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
	}

	public void launchApp() {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("appUrl"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TestUtil.appScreenshot();
				System.out.println("Failure Screenshot taken!");
			} catch (IOException e) {
				e.getMessage();
			}
		}
		driver.quit();
	}

}
