using AppiumTest.objectRepo;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppiumTest.tools
{
    class jobbox
    {
        private AndroidDevice pvAndroid;

        public jobbox(AndroidDevice AndroidDriver)
        {
            this.pvAndroid = AndroidDriver;
        }


        //Modules
        public void login(String strAccount, String strUser, String strPwd)
        {
            //Object Repositories
            landingPage jobboxLandinPage = new landingPage();
            loginPage jobboxLoginPage = new loginPage();
            mainPage jobboxMainPage = new mainPage();
            Console.WriteLine("Starting Login Module\n" + "Account: " + strAccount + "\nUserName: " + strUser);

            //check if welcome page
            if (pvAndroid.MobileElement_Exists(By.XPath(jobboxLandinPage.getXpath("txtAccount"))))
            {
                pvAndroid.MobileTextField_EnterText(By.XPath(jobboxLandinPage.getXpath("txtAccount")), strAccount);
                pvAndroid.MobileButton_Click(By.XPath(jobboxLandinPage.getXpath("btnNext")));
            }

            pvAndroid.MobileTextField_EnterText(By.XPath(jobboxLoginPage.getXpath("txtUserName")), strUser);
            pvAndroid.MobileTextField_EnterText(By.XPath(jobboxLoginPage.getXpath("txtPwd")), strPwd);
            pvAndroid.MobileButton_Click(By.XPath(jobboxLoginPage.getXpath("btnLogin")));

            if (pvAndroid.MobileElement_Exists(By.XPath(jobboxMainPage.getXpath("btnInbox"))))
            {
                Console.WriteLine("User: " + strUser + " is able to log in to jobbox mobile App");
            }
            else
            {
                Console.WriteLine("An Error occurr while User: " + strUser + " trying to log in to jobbox mobile App");
            }
        }
    }
}
