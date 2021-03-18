package com.oswal.android.POM;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oswal.android.util.MobileActionUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage 
{
	AndroidDriver driver;
	
	@FindBy(id="com.mosl.mobile.dev:id/skip")
	
	private MobileElement skipbtn;

	public LandingPage(AndroidDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickonskip()
	{
	MobileActionUtil.click(skipbtn);
	}
	
	@AndroidFindBy(accessibility = "Watchlist")
	private MobileElement watchlistbtn;
	
	public void clickonwatchlist()
	{
	MobileActionUtil.click(watchlistbtn);
	}

	
	
	
}
