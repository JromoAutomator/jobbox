package AppiumTests;

import java.io.IOException;

import org.junit.Test;

public class openEmulator {

	@Test
	public void test() {
		try {
			Runtime.getRuntime().exec("/Users/jesusromo/Library/Android/sdk/tools/emulator -avd Nexus_5X_API_25");
			Thread.sleep(15000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
