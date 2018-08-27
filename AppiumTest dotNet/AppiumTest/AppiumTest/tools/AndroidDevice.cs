using OpenQA.Selenium;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Android;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace AppiumTest
{
    class AndroidDevice
    {
        DesiredCapabilities cap = null;
        string strdeviceName = "";
        private AppiumDriver<IWebElement> Mobiledriver;
        string strOS = Environment.OSVersion.ToString();

        Uri testServerAddress = new Uri("http://127.0.0.1:4723/wd/hub"); // If Appium is running locally
        TimeSpan INIT_TIMEOUT_SEC = TimeSpan.FromSeconds(180); /* Change this to a more reasonable value */
        TimeSpan IMPLICIT_TIMEOUT_SEC = TimeSpan.FromSeconds(10); /* Change this to a more reasonable value */

        public void setCapabilities(String strPlatfformVersion, String deviceName)
        {

            strdeviceName = deviceName;
            Console.WriteLine("Script Running on " + this.strOS);
            cap = new DesiredCapabilities();
            cap.SetCapability("appPackage", "com.jobboxsoft.serviceboxmobile");
            cap.SetCapability("appActivity", "md5c4bbbd90917fb7db4dcd4062ad25989b.SplashActivity");
            cap.SetCapability("platformName", "Android");
            cap.SetCapability("platformVersion", strPlatfformVersion);
            cap.SetCapability("deviceName", deviceName);
            cap.SetCapability("autoGrantPermissions", true);

        }

        public void startApp()
        {
            //check if appium and emulator are running OS
            //if (this.strOS.Equals("Mac OS X"))
            //{
            //    if (!this.AppiumRunning())
            //    {
            //        Console.WriteLine("Appium Server is not running, ending test.....");
            //        Environment.Exit(0);
            //    }

            //                if (!this.EmulatorRunning())
            //    {
            //        Console.WriteLine("No Emulator found, ending test.....");
            //        Environment.Exit(0);
            //     }
            //}

            try
            {
                Console.WriteLine("Open Application...");
                Mobiledriver = new AndroidDriver<IWebElement>(testServerAddress, cap, INIT_TIMEOUT_SEC);
                Mobiledriver.Manage().Timeouts().ImplicitWait = IMPLICIT_TIMEOUT_SEC;
                Console.WriteLine("Android dirver running on: " + this.strdeviceName);
            }
            catch (Exception e)
            {
                
            }
        }


        public void MobileTextField_EnterText(By oName, String strTextvalue)
        {
            try
            {
                var wait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
                IWebElement myDynamicElement = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
                this.Mobiledriver.FindElement(oName).Click();
                this.Mobiledriver.FindElement(oName).Clear();
                this.Mobiledriver.FindElement(oName).SendKeys(strTextvalue);
            }
            catch (Exception e)
            {
                //need to enable recovery scenario
                //throw new UncheckedSeleniumException(e);
            }
        }

        public void MobileButton_Click(By oName)
        {
            try
            {
                var wait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
                IWebElement myDynamicElement = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
                this.Mobiledriver.FindElement(oName).Click();
            }
            catch (Exception e)
            {
                //throw new UncheckedSeleniumException(e);
            }

        }

        public Boolean MobileScreen_Validate(By oName, String oValue)
        {
            var wait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
            IWebElement myDynamicElement = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
            myDynamicElement.GetType();
            Boolean present = false;
            WebDriverWait swait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
            for (int i = 1; i <= 6; i++)
            {
                swait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
                IWebElement h1Element = this.Mobiledriver.FindElement(oName);
                String StrScreen = h1Element.Text;
                if (StrScreen.Equals(oValue))
                {
                    present = true;
                    Console.WriteLine("Current Screen is: " + StrScreen);
                    break;
                }
                else
                {
                    present = false;
                    try
                    {
                        Thread.Sleep(20000);
                    }
                    catch (Exception e)
                    {
                        //throw new UncheckedGeneralException(e);
                    }
                }
            }
            return present;
        }

        public string MobileStaticText_GetText(By oName)
        {
            string value = "";
            var wait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
            IWebElement myDynamicElement = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
            myDynamicElement.GetType();
            try
            {
                value = this.Mobiledriver.FindElement(oName).GetProperty("text");
            }
            catch (Exception e)
            {
                //throw new UncheckedSeleniumException(e);
            }
            return value;
        }

        public Boolean MobileElement_Exists(By oName)
        {
            Boolean present;
            var wait = new WebDriverWait(this.Mobiledriver, IMPLICIT_TIMEOUT_SEC);
            IWebElement myDynamicElement = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(oName));
            myDynamicElement.GetType();
            try
            {
                this.Mobiledriver.FindElement(oName);
                present = true;
            }
            catch (Exception e)
            {
                present = false;
                //throw new UncheckedSeleniumException(e);
            }
            return present;
        }

        public void MobileFunction_SelectSideMenu(By oName)
        {
            //need to update
            Boolean blnHomeScreen = MobileElement_Exists(By.Name("Menu"));
            if (blnHomeScreen)
            {
                MobileButton_Click(By.Name("Home"));
            }
            MobileButton_Click(By.XPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/UIAButton[1]"));
            MobileButton_Click(oName);
        }




    }
}
