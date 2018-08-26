package AppiumTests;

import java.io.IOException;

public class StartAppium implements Runnable { 
	   public void run() { 
	    	   try {
	    		   Runtime.getRuntime().exec("/usr/local/bin/node /usr/local/bin/appium --address 127.0.0.1");
	    		   Thread.sleep(15000);
	    	   } catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   } 
}
