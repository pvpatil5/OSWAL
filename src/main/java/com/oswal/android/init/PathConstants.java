package com.oswal.android.init;

import com.oswal.android.lib.GenericLib;

public class PathConstants
{
	static String DirPath = System.getProperty("user.dir");
	static String DCfile = DirPath + "/src/test/resources/DesiredCapablities.properties";
	public static String screenShotPath = DirPath+"/src/test/resources/Screenshots";
	public static String extentreport= DirPath +"/src/test/resources/Extent "+GenericLib.getDate()+".html";
	public static String LoginCredentials= DirPath +"/src/test/resources/LoginCredentials.properties";
	public static String serverlogpath= DirPath + "/ServerLogs/server "+GenericLib.getDate()+".log";

	
}