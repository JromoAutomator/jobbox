package AppiumTests;

import java.io.IOException;

class StartEmulator implements Runnable { 
	   public void run() { 
	       while ( true ) { 
	    	   try {
				Runtime.getRuntime().exec("/Users/jesusromo/Library/Android/sdk/tools/emulator -avd Nexus_5X_API_25");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       } 
	   } 

}
