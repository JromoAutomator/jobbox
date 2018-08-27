using System;
using AppiumTest.tools;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace AppiumTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            string deviceName = "Nexus_5X_API_25";
            string strPlatfformVersion = "7.1.1";

            AndroidDevice Android = new AndroidDevice();
            Android.setCapabilities(strPlatfformVersion, deviceName);
            Android.startApp();

            //Login
            jobbox jobboxApp = new jobbox(Android);
            jobboxApp.login("jb", "Jesus", "Jobbox1!");
        }
    }
}
