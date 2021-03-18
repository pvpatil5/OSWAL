package com.oswal.android.POM;

import org.openqa.selenium.support.PageFactory;

import com.oswal.android.init.PathConstants;
import com.oswal.android.lib.GenericLib;
import com.oswal.android.util.MobileActionUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
	AndroidDriver driver;
	@AndroidFindBy(id="com.mosl.mobile.dev:id/edClientCode")
	private MobileElement usernametxtfld;
	
	@AndroidFindBy(id="com.mosl.mobile.dev:id/edClientPass")
	private MobileElement passwordtxtfld;

	@AndroidFindBy (id="com.mosl.mobile.dev:id/btnLogin")
	private MobileElement loginbtn;
	
	public LoginPage(AndroidDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void enterUsername() {
		usernametxtfld.sendKeys(GenericLib.getProprtyValue(PathConstants.LoginCredentials, "username"));
	}
	public void enterPassword() {
		passwordtxtfld.sendKeys(GenericLib.getProprtyValue(PathConstants.LoginCredentials, "password"));
	}
	public void clickonloginbtn() 
	{
		MobileActionUtil.click(loginbtn);
	}
}
