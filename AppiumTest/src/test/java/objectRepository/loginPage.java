package objectRepository;

public class loginPage {
	public String xpathPrefix="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/";
	
	public String getXpath(String ObjectName) {
		String strFullxpath="";
		switch(ObjectName) {
		
			case "imgPadlock":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[1]/android.widget.ImageView";
				break;
					
			case "lblDomain":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView";
				break;
				
			case "btnBacktoLanding":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView";
				break;
				
			case "txtUserName":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[3]/android.widget.EditText";
				break;
				
			case "txtPwd":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[4]/android.widget.EditText";
				break;
			
			case "btnLogin":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[5]/android.widget.Button";
				break;
				
			case "lblRememberme":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.widget.TextView";
				break;
				
			case "btnRememberme":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.widget.Switch";
				break;
				
			default:
				strFullxpath="Object not found on Page Repo";
		
		}
		return strFullxpath;
	}

}
