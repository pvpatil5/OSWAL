package com.oswal.android.POM;

import org.openqa.selenium.support.PageFactory;

import com.oswal.android.util.MobileActionUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WatchListPage 
{
	AndroidDriver driver;
	@AndroidFindBy(id="com.mosl.mobile.dev:id/tvSkip")
	private MobileElement skipbtn;
	
	public WatchListPage(AndroidDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='WATCHLIST']")
	private MobileElement watchlisttitle;
	
	public String watchlistTitle(MobileElement e) 
	{
		String txt=MobileActionUtil.getText(e);
		return txt;
	}
	
	@AndroidFindBy(id="com.mosl.mobile.dev:id/txt_watchlist")
	private MobileElement createWatchlistbtn;
	
	public void clickonCreateWatchlistbtn() 
	{
		MobileActionUtil.click(createWatchlistbtn);
	}
	
	@AndroidBy(id="com.mosl.mobile.dev:id/edit_text")
	private MobileElement newwatchlisttxtfld;
	
	public void createnewwatchlist() 
	{
	MobileActionUtil.sendKeys(newwatchlisttxtfld, "");
	}

	
	
	
}
