package selenium;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Sanitytest extends Locaters{

	public String guidingcare 						= "C:\\Windows\\System32\\notepad.exe";
	public String winiumDriverPath 	 				=".\\src\\main\\java\\Winium.Desktop.Driver.exe";
	public File drivePath							;
	public Actions act 								= null;	
	public static ExtentTest logger					;
	public static String folderName 				= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	public static String fileName 					= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss'.html'").format(new Date());
	public static String reportLocation 			= "C:\\GuidingCare\\Mobile_"+folderName+"\\";	
	public static String htmlLocation 				= "Windows_"+fileName;
	public static ExtentReports reports  			= new ExtentReports();
	public ExtentTest parent 						;
	Robot r											;
	public WebDriver wdriver				  =null	;
	public static File file 					    = new File(".\\src\\main\\java\\OR.properties");	
	public static File orfile             		    = new File(".\\src\\main\\java\\OR.properties");
	public static FileInputStream fileInput         = null;
	public static Properties   prop                 = new Properties();
	public static Properties   orprop               = new Properties();
	public WebElement wifi				            =null;
	public FileInputStream fileinput        		=null;


	///////////////////////////////// Mobile config property file/////////////////////////////////////////

	public static void initialize(){
		try {
			fileInput = new FileInputStream(file);
			if(fileInput != null)
				prop.load(fileInput);			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	public static void orproperties(){
		try {
			fileInput = new FileInputStream(orfile);
			if(fileInput != null)
				orprop.load(fileInput);			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String captureScreenshot()
	{
		try { 
			Robot robot = new Robot(); 
			BufferedImage tmp = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));  
			String path=reportLocation+System.currentTimeMillis()+".png";
			ImageIO.write(tmp, "png",new File(path)); 
			Dimension dim = new Dimension(1375, 727);
			int w = dim.getWidth();
			int h = dim.getHeight();
			Image orig = ImageIO.read(new File(path));
			BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			bi.getGraphics().drawImage(orig, 0, 0, w, h, 0, 70, w, h, null);
			ImageIO.write(bi, "png", new File(path));
			//logger.addScreenCapture(path);
			return path;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}

	}
	public WebElement DX(String Xpathkey){
		return driver.findElement(By.xpath(Xpathkey));
	}
	public WebElement DN(String Namekey){
		return driver.findElement(By.name(Namekey));
	}
	public WebElement DI(String Namekey){
		return driver.findElement(By.id(Namekey));
	}
	public void clickDI(String ID, String elementName) throws Exception  {

		try {
			DI(ID).click();
		} catch (Exception e) {
		}
	}
	public void clickDN(String Name, String elementName) throws Exception{

		try {
			DN(Name).click();
		} catch (Exception e) {

		}
	}
	public void clearNEnterTextX(String xpath,String text,String elementName) throws Exception{
		try {
			
			DX(xpath).clear();
			DX(xpath).sendKeys(text);
			
		} catch (Exception e) {
			
		}
	}
	public void clearNEnterTextN(String Name,String text,String elementName) throws Exception{
		try {
			
			DN(Name).clear();
			DN(Name).sendKeys(text);
			
		} catch (Exception e) {
			
		}
	}
	public void clearNEnterTextID(String ID,String text,String elementName) {
		try {
			
			DI(ID).clear();
			DI(ID).sendKeys(text);
			
		} catch (Exception e) {
			
		}
	}
	public  WebDriverWait invisibleElement(String Name, int sec){
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Name)));
		return wait;
	}	
	public void enterValueN(String Name, String enterValue, String elementName) throws Exception{

		try {					
			DN(Name).sendKeys(enterValue);
			} catch (Exception e) {
					}
	}

	public void enterValueDX(String Xapth, String enterValue, String elementName) throws Exception{

		try {
						
			DX(Xapth).sendKeys(enterValue);
			
		} catch (Exception e) {
			
		}
	}
	public void clickDC(String ClassName, String elementName) throws Exception{

		try {
			DC(ClassName).click();

		} catch (Exception e) {

		}
	}
	public void clickDX(String Xpath, String elementName) throws Exception  {

		try {

			DX(Xpath).click();

		} catch (Exception e) {

		}
	}
	public void wifidisconnect() {

		try {
			Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","ipconfig /release"});
			sleeper(driver, 5);
			
		} catch (Exception e) {
			
		}			
	}

	public void wificonnect()  {            
		try {
			Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","ipconfig /renew"});
			sleeper(driver,5);
			} catch (Exception e) {
			
		}
	}



	public WebElement DC(String classkey){
		return driver.findElement(By.className(classkey));
	}

	public void displayCheckDN(String Name, String elementName) throws Exception{
		try {			
			DN(Name).isDisplayed();			
		} catch (Exception e) {

		}
	}	
	public  void sleeper (WebDriver driver,int seconds)throws Exception
	{
		Thread.sleep(seconds*1000);
	}
	public void displayCheckDI(String ID, String elementName) throws Exception{

		try {

			DI(ID).isDisplayed();

		} catch (Exception e) {

		}

	}

	public void launching () throws Exception{

		try {		
			Thread.sleep(500);
			r = new Robot();
			DesktopOptions	options	= new DesktopOptions();			
			options.setApplicationPath(guidingcare);			
			drivePath = new File(winiumDriverPath);
			WiniumDriverService	services = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
			services.start(); 
			/*WiniumDriver driver=new WiniumDriver(services,options);
			act=new Actions(driver);	
			DN(typehere).sendKeys("Mobile");	
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);*/	
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}

	}		
	public void signout() throws Exception{	

		sleeper(driver,6);
		displayCheckDI(menulayoutID, "Menu layout");
		clickDI(menulayoutID, "Menu layout");
		sleeper(driver,2);
		clickDN(singoutN, "Signout");
		sleeper(driver,5);
		displayCheckDN(UserNameN, "login portal displayed");

	}

}