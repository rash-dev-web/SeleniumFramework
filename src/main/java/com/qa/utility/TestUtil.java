package com.qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 30;
	public static int IMPLICITLY_TIMEOUT = 20;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public void swithchToIframe() {
		driver.switchTo().frame("intercom-borderless-frame");
	}
	
	public void switchToDefault(){
		driver.switchTo().defaultContent();
	}
	
	public static void appScreenshot() throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./FailedScreenshot/"+System.currentTimeMillis()+".jpg"));
	}
	
	
}
