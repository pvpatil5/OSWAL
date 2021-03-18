package com.oswal.android.testscripts;

import org.testng.annotations.Test;

import com.oswal.android.POM.LandingPage;
import com.oswal.android.POM.LoginPage;
import com.oswal.android.lib.BaseLib;



public class TC_001 extends BaseLib
{
	
	@Test
	public void tc_001() 
	{
		LandingPage lp = new LandingPage(gv.driver);
		
		lp.clickonskip();
		
		LoginPage lpg= new LoginPage(gv.driver);
		
		lpg.enterUsername();
		lpg.enterPassword();
		lpg.clickonloginbtn();
		
	}
	

}
