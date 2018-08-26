package AppiumTests;

import java.io.IOException;

public class AppiumServer {
	public void startServer(String Platform,String DeviceName) {
		 
		
		try {
			if(Platform.equals("no")) {
				StartEmulator Emulator = new StartEmulator(); 
				Thread ThEmulator = new Thread(Emulator);
				ThEmulator.setDaemon(true); // important, otherwise JVM does not exit at end of main()
				ThEmulator.start(); 
				
				StartAppium Appium = new StartAppium(); 
				Thread ThAppium = new Thread(Appium);
				ThAppium.setDaemon(true); // important, otherwise JVM does not exit at end of main()
				ThAppium.start(); 
				
			}else {
				Runtime.getRuntime().exec("/usr/local/bin/node /usr/local/bin/appium --address 127.0.0.1");
				Thread.sleep(5000);
			}
						
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
