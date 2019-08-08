package selenium;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Executable extends Regression{

	
	@BeforeClass
	public void launchApplication() throws Exception
	{		
		initialize();
		orproperties();	
		launching();
		
}
	@Test(priority=1)
	public void verifylogin() throws Exception
	{
		invaliduser();		
		invalidpassword();		
		validlogin();		
		signout();		
		wifidisconnect();			
		invalidloginoffline();	
		validlogin();		
		wificonnect();		
	}
}