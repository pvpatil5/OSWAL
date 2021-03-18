package com.oswal.android.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import com.oswal.android.init.PathConstants;
import com.oswal.android.lib.BaseLib;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileActionUtil extends BaseLib
{
	 AndroidDriver driver;

	public static void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(gv.driver, 15);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public static void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public static void  click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public static void click(MobileElement e, String msg) {
		waitForVisibility(e);
		e.click();
	}

	public static void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
	}

	public static void sendKeys(MobileElement e, String txt, String msg) {
		waitForVisibility(e);
		
		e.sendKeys(txt);
	}

	public static String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}
	
	public static String getText(MobileElement e) {
		waitForVisibility(e);
		return e.getText();
	}



//	public static void closeApp() {
//		((InteractsWithApps) getDriver()).closeApp();
//	}

//	public static void launchApp() {
//		((InteractsWithApps) getDriver()).launchApp();
//	}
//
//	public static MobileElement scrollToElement() {	  
//		return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
//						+ "new UiSelector().description(\"test-Price\"));");
//	}
	public static String capture(AndroidDriver driver, String screenShotName) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String dest = PathConstants.screenShotPath +" " +screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}


}

