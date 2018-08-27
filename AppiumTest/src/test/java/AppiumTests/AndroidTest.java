package AppiumTests;

import org.junit.Test;
import tools.AndroidDevice;
import tools.jobbox;

public class AndroidTest {

	@Test
	public void test() {
		String deviceName="Nexus_5X_API_25";
		String strPlatfformVersion="7.1.1";
		
		AndroidDevice Android = new AndroidDevice();
		Android.setCapabilities(strPlatfformVersion, deviceName);
		Android.startApp();
		
		//Login
		jobbox jobboxApp= new jobbox(Android);
		jobboxApp.login("jb","Jesus","Jobbox1!");

		
		
		
	}

}
