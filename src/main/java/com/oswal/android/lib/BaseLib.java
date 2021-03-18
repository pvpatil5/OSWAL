package com.oswal.android.lib;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.oswal.android.init.GlobalVariables;
import com.oswal.android.init.PathConstants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseLib {

	public AppiumDriverLocalService service;

	@BeforeSuite
	public void StartServer() throws Exception 
	{
		service=getAppiumService();		
		if(!checkIfAppiumServerIsRunnning(4723)) {
			service.start();
			service.clearOutPutStreams();
		}
		else {
			System.out.println("Appium Server is already running");
		}
	}


	public AppiumDriverLocalService getAppiumService() {
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingPort(4723)
				.withAppiumJS(new File("C:\\Users\\AMAR-G\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withLogFile(new File(PathConstants.serverlogpath)));
	}
	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}

	@AfterSuite
	public void StopServer() 
	{
		service.stop();
	}


	public static  GlobalVariables gv = new GlobalVariables();
	@BeforeClass
	public void _LaunchApp() throws MalformedURLException
	{
		gv.capabilities = new DesiredCapabilities();
		gv.capabilities.setCapability("deviceName", gv.deviceName);
		gv.capabilities.setCapability("platformName", gv.platformName);
		gv.capabilities.setCapability("platformVersion", gv.platforVersion);
		gv.capabilities.setCapability("automationName", gv.automationName);
		gv.capabilities.setCapability("appPackage", gv.appPackage);
		gv.capabilities.setCapability("appActivity", gv.appActivity);
		gv.capabilities.setCapability("UDID", gv.UDID);
		gv.capabilities.setCapability("fullReset", false);
		gv.capabilities.setCapability("noReset", false);
		gv.capabilities.setCapability("appWaitDuration", 180000);
		gv.capabilities.setCapability("autoGrantPermissions", true);
		gv.capabilities.setCapability("autoAcceptAlerts", true);
		System.out.println("http://127.0.0.1:"+gv.port+"/wd/hub");
		gv.driver = new AndroidDriver(new URL("http://127.0.0.1:"+gv.port+"/wd/hub"), gv.capabilities);
		gv.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



	}	


		@AfterClass
		public void shutDownApp()
		{
			
			gv.driver.quit();
		}
}
