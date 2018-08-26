package objectRepository;

public class landingPage {
	
	public String xpathPrefix="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/";

	public String getXpath(String ObjectName) {
		String strFullxpath="";
		switch(ObjectName) {
		
			case "txtAccount":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget.EditText";
				break;
					
			case "btnNext":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[5]/android.widget.Button";
				break;
				
			case "btnDontHaveAccount":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[6]/android.widget.Button";
				break;
				
			case "imgpadlock":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[1]/android.widget.ImageView";
				break;
				
			case "lblEnterYouraccount":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[3]/android.widget.TextView";
				break;
			
			case "lblDomain":
				strFullxpath=xpathPrefix+"android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.widget.TextView";
				break;
					
			
			default:
					strFullxpath="Object not found on Page Repo";
		
		}
		return strFullxpath;
	}
	
	
}
