package tools;

import org.openqa.selenium.By;

import objectRepository.landingPage;
import objectRepository.loginPage;
import objectRepository.mainPage;

public class jobbox {
	private AndroidDevice pvAndroid;
	
	
	
	public jobbox(AndroidDevice AndroidDriver) {
		this.pvAndroid=AndroidDriver;
	}
	
	
	//Modules
	public void login(String strAccount,String strUser,String strPwd) {
		//Object Repositories
		landingPage jobboxLandinPage = new landingPage();
		loginPage jobboxLoginPage = new loginPage();
		mainPage jobboxMainPage= new mainPage();
		System.out.println("Starting Login Module\n"+"Account: "+strAccount+"\nUserName: "+strUser);
		
		//check if welcome page
		if(pvAndroid.MobileElement_Exists(By.xpath(jobboxLandinPage.getXpath("txtAccount")))) {
			pvAndroid.MobileTextField_EnterText(By.xpath(jobboxLandinPage.getXpath("txtAccount")), strAccount);
			pvAndroid.MobileButton_Click(By.xpath(jobboxLandinPage.getXpath("btnNext")));
		}
		
		pvAndroid.MobileTextField_EnterText(By.xpath(jobboxLoginPage.getXpath("txtUserName")), strUser);
		pvAndroid.MobileTextField_EnterText(By.xpath(jobboxLoginPage.getXpath("txtPwd")), strPwd);
		pvAndroid.MobileButton_Click(By.xpath(jobboxLoginPage.getXpath("btnLogin")));
		
		if(pvAndroid.MobileElement_Exists(By.xpath(jobboxMainPage.getXpath("btnInbox")))){
			System.out.println("User: "+strUser+" is able to log in to jobbox mobile App");
		}else {
			System.out.println("An Error occurr while User: "+strUser+" trying to log in to jobbox mobile App");
		}
		
		
	}
	
	

}
