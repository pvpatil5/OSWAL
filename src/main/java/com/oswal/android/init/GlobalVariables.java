package com.oswal.android.init;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.oswal.android.lib.GenericLib;
import com.oswal.android.init.PathConstants;

import io.appium.java_client.android.AndroidDriver;

public class GlobalVariables 
{

	public static AndroidDriver driver;
	public DesiredCapabilities capabilities;

	//	DesiredCapabilities Variables
	public int port =Integer.parseInt(GenericLib.getProprtyValue(PathConstants.DCfile, "port"));
	public String deviceName=GenericLib.getProprtyValue(PathConstants.DCfile, "devicename");
	public String platformName=GenericLib.getProprtyValue(PathConstants.DCfile, "platformname");;
	public String platforVersion=GenericLib.getProprtyValue(PathConstants.DCfile, "platformversion");;
	public String automationName=GenericLib.getProprtyValue(PathConstants.DCfile, "automationname");;
	public String appPackage=GenericLib.getProprtyValue(PathConstants.DCfile, "apppackage");;
	public String appActivity=GenericLib.getProprtyValue(PathConstants.DCfile, "appactivity");;
	public String UDID=GenericLib.getProprtyValue(PathConstants.DCfile, "udid");


}

