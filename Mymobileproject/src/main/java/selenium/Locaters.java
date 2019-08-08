package selenium;

import java.awt.Robot;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locaters {
	public WebDriver webDriver=null;
	public WebDriver winDriver;
	public WebDriver driver;
	public Robot robot;
	public WebDriverWait wait;
	public String ProcessLoaderID 	          = "ProgressBar";
	public static Properties prop             = new Properties();
	
	/* Locators for Loacal instance Login Page*/

	public String UserNameN 			      ="User Name";
	public String PasswordN 			      ="Password";
	public String SecurityquedropdownID		  ="SecurityQuestionComboBox";
	public String SecQueC 			          ="ComboBox";
	public String StagSecQueAnsN			  ="In what city or town does your nearest sibling live?";
	public String LocalSecQueN1            	  ="What is your name?";

	public String LocalSecQueN2               ="What is your city?";
	public String StagingSecQueN			  ="What is your previous Organization name?";
	public String SecAnsN 			          ="Security Answer";
	public String LoginBtnN 			      = "LOGIN";
	public String errormsgN                   ="Please verify username, try again.";
	public String errorpass1                  ="Invalid credentials, please check! 4 attempts left.";
	public String errorpass2                  ="Invalid credentials, please check! 3 attempts left.";
	public String errorpass3                  ="Invalid credentials, please check! 2 attempts left.";
	public String typehere					  ="Type here to search";
	/*Login verification Locators*/              
	public String HomepageN                   ="HOME";	


	/* offline mode locators for login*/
	public String offlinemodebuildlaunchN  ="Please launch the application with Active Internet Connection";
	public String invalidusermsgN          ="Could not find the specified user in this device.";
	public String invalidpassmsgN          ="Invalid credentials.";
	public String invalidquemsgN           ="Please select appropriate Hint Question";
	public String invalidansmsgN           ="Hint question answer mismatch";
	public String menulayoutID 				="InitialsTextBlock";
	public String singoutN					="Sign Out";
}
