package AppiumTests;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class iOS_Test {

	@Test
	public void test() {
		System.out.println("still working");
		String deviceName="iPhone 7 Plus";
		String strPlatfformVersion="10.3";
		
		
		AppiumServer Appiumserver = new AppiumServer();
		Appiumserver.startServer("iPhone",deviceName);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("bundleId", "com.imurchie.SafariLauncher");
		cap.setCapability("platformName","iOS");
		cap.setCapability("platformVersion",strPlatfformVersion);
		cap.setCapability("deviceName", "iPhone 7 Plus");
		cap.setCapability("showIOSLog","true");
		
		try {
			AppiumDriver<WebElement> Mobiledriver = new IOSDriver<WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"),cap);
			Mobiledriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Ios dirver running on: "+deviceName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}

}
