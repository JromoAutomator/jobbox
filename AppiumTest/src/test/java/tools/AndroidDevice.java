package tools;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidDevice {
	
	public DesiredCapabilities cap =null;
	public String strdeviceName="";
	public AppiumDriver<WebElement> Mobiledriver;
	
	public void setCapabilities (String strPlatfformVersion,String deviceName){
		
		this.strdeviceName=deviceName;
		
		this.cap = new DesiredCapabilities();
		this.cap.setCapability("appPackage", "com.jobboxsoft.serviceboxmobile");
		this.cap.setCapability("appActivity", "md5c4bbbd90917fb7db4dcd4062ad25989b.SplashActivity");
		this.cap.setCapability("platformName","Android");
		this.cap.setCapability("platformVersion",strPlatfformVersion);
		this.cap.setCapability("deviceName", deviceName);
		this.cap.setCapability("enablePerformanceLogging", true);
		this.cap.setCapability("autoGrantPermissions", true);
			
		}
	
	public void startApp() {
		//check if appium and emulator are running
	    if(!this.AppiumRunning()) {
			System.out.println("Appium Server is not running, ending test.....");
			System.exit(0);
		}
		
	    if(!this.EmulatorRunning()) {
			System.out.println("No Emulator found, ending test.....");
			System.exit(0);
		}
	    
		try {
			System.out.println("Open Application...");
			this.Mobiledriver = new AndroidDriver<WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"),this.cap);
			Mobiledriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Android dirver running on: "+this.strdeviceName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}
	
	public boolean AppiumRunning() {
		boolean AppiumRunning=false;
		boolean noError=false;
		//Create a 2D Array
		String[][] Process= new String [100][100];
		for (int c = 0; c < 100; c++) {
			for (int r = 0; r < 100; r++) {
				Process[c][r]="Empty";
			}
		}
		
		//Check Running Process
	    try {
			Runtime rt = Runtime.getRuntime();
			String commands = "/usr/sbin/lsof -c node";
			Process proc = rt.exec(commands);
			//Terminal Output
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			//Error if Any
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			// read the output from the command and load the 2d Array
			String s = null;
			int x=0;
			while ((s = stdInput.readLine()) != null) {
				noError=true;
				int i=0;
			    String[] ArrPR= s.split(" ");
			    for (String strValue : ArrPR) {
					if (strValue.equals("")) {
					}else {
						Process[i][x]=strValue;
						i++;
					}
				}
			    x++;
			}
			//get only the process Name in a single Array
			ArrayList<String> ArrProcessName = new ArrayList<String>(20);
			for (int y = 0; y < 100; y++) {
				if(Process[8][y].equals("Empty")) {
				}else {
					ArrProcessName.add(Process[8][y]);
				}
			}
			//Check if Appium Process is running
			for (String ProcNam : ArrProcessName) {
				if(ProcNam.equals("localhost:4723")) {
					System.out.println("Appium Server running on: "+ProcNam);
					AppiumRunning=true;
				}
			}
			
			if(!noError) {
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
			    System.out.println(s);
			}
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return AppiumRunning;
	}
	
	public boolean EmulatorRunning() {
		boolean EmulatorRunning=false;
		boolean noError=false;
		ArrayList<String> Emulators = new ArrayList<String>();
		
		//Check Running Process
	    try {
			Runtime rt = Runtime.getRuntime();
			String commands = "/Users/jesusromo/Library/Android/sdk/platform-tools/adb devices";
			Process proc = rt.exec(commands);
			//Terminal Output
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			//Error if Any
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			// read the output from the command and load the 2d Array
			String s = null;
			int x=0;
			while ((s = stdInput.readLine()) != null) {
				noError=true;
				if(x!=0) {
					Emulators.add(s);
				}
			    x++;
			}
			
			//Check if Emulator Process is running
			for (String ProcNam : Emulators) {
				if(ProcNam.contains("emulator")) {
					System.out.println("the following emulator is running : "+ProcNam);
					EmulatorRunning=true;
				}
			}
			
			if(!noError) {
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
			    System.out.println(s);
			}
			}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return EmulatorRunning;
	}

	public void MobileTextField_EnterText(By oName,String strTextvalue){
		try {
			@SuppressWarnings("unused")
			WebElement myDynamicElement = (new WebDriverWait(this.Mobiledriver, 100)).until(ExpectedConditions.presenceOfElementLocated(oName));
			this.Mobiledriver.findElement(oName).click();
			this.Mobiledriver.findElement(oName).clear();
			this.Mobiledriver.findElement(oName).sendKeys(strTextvalue);
			}
		catch (Exception e){
			//need to enable recovery scenario
			//throw new UncheckedSeleniumException(e);
			}
	}
	
	public void MobileButton_Click(By oName){
		try{
			@SuppressWarnings("unused")
			WebElement myDynamicElement = (new WebDriverWait(this.Mobiledriver, 100)).until(ExpectedConditions.presenceOfElementLocated(oName));
			this.Mobiledriver.findElement(oName).click();
		}catch (Exception e){
			//throw new UncheckedSeleniumException(e);
		}
		
	}
	
	public boolean MobileScreen_Validate(By oName,String oValue){
		WebElement myDynamicElement = (new WebDriverWait(this.Mobiledriver, 100))
				  .until(ExpectedConditions.presenceOfElementLocated(oName));
		myDynamicElement.getClass();
		boolean present=false;
		WebDriverWait wait = new WebDriverWait(this.Mobiledriver,20);
		for(int i=1;i<=6;i++){
			wait.until(ExpectedConditions.visibilityOfElementLocated(oName));
			WebElement h1Element = this.Mobiledriver.findElement(oName);
			String StrScreen = h1Element.getText();
			if (StrScreen.equals(oValue)){
				present = true;
				System.out.println("Current Screen is: "+StrScreen);
				break;
			}else{
				 present = false;
				 try{
				 Thread.sleep(20000);
				 }catch(Exception e){
					 //throw new UncheckedGeneralException(e);
				 }
			}
		}
		return present;
	}
	
	public String MobileStaticText_GetText(By oName){
		String value="";
		WebElement myDynamicElement = (new WebDriverWait(this.Mobiledriver, 100))
				  .until(ExpectedConditions.presenceOfElementLocated(oName));
		myDynamicElement.getClass();
		try {
			value =this.Mobiledriver.findElement(oName).getText();
		} catch (Exception e){
			//throw new UncheckedSeleniumException(e);
		}
		return value;
	}
	
	public boolean MobileElement_Exists(By oName){
		boolean present;
		WebElement myDynamicElement = (new WebDriverWait(this.Mobiledriver, 100))
				  .until(ExpectedConditions.presenceOfElementLocated(oName));
		myDynamicElement.getClass();
		try {
			this.Mobiledriver.findElement(oName);
			present = true;
		} catch (Exception e){
			present = false;
			//throw new UncheckedSeleniumException(e);
		}
		return present;
	}
	
	public void MobileFunction_SelectSideMenu(By oName){
		//need to update
		boolean blnHomeScreen=MobileElement_Exists(By.name("Menu"));
		if(blnHomeScreen){
			MobileButton_Click(By.name("Home"));
		}
		MobileButton_Click(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIAButton[1]"));
		MobileButton_Click(oName);
	}
	
	
	
	
}
