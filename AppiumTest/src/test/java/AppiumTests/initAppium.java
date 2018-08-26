package AppiumTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class initAppium {

	@Test
	public void test() {
		try {
 		   //Runtime.getRuntime().exec("/usr/local/bin/node /usr/local/bin/appium --address 127.0.0.1");
 		   //Runtime.getRuntime().exec("/Users/jesusromo/Documents/Appium");
 		   Process proc = Runtime.getRuntime().exec("/Users/jesusromo/Documents/Appium");
 	       proc.waitFor();
 	       StringBuffer output = new StringBuffer();
 	       BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
 	       String line = "";
 	       while ((line = reader.readLine()) != null) {
 	            output.append(line + "\n");
 	       }
 	       System.out.println(output);
 		   Thread.sleep(15000);
 	   } catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
