using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AppiumTest.objectRepo
{
    class mainPage
    {
        public string xpathPrefix1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/";
        public string xpathPrefix2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/";
        public string xpathPrefix3 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/";


        public string getXpath(string ObjectName)
        {
            string strFullxpath = "";
            switch (ObjectName)
            {

                case "tabAll":
                    strFullxpath = xpathPrefix1 + "android.support.v7.app.ActionBar.Tab[1]";
                    break;

                case "tabWorkOrders":
                    strFullxpath = xpathPrefix1 + "android.support.v7.app.ActionBar.Tab[2]";
                    break;

                case "tabToDo":
                    strFullxpath = xpathPrefix1 + "android.support.v7.app.ActionBar.Tab[3]";
                    break;

                case "lblPageName":
                    strFullxpath = xpathPrefix2 + "android.view.ViewGroup[1]/android.widget.TextView";
                    break;

                case "btnInbox":
                    strFullxpath = xpathPrefix3 + "android.widget.FrameLayout[1]";
                    break;

                case "btnServiceBox":
                    strFullxpath = xpathPrefix3 + "android.widget.FrameLayout[2]";
                    break;

                case "btnSettings":
                    strFullxpath = xpathPrefix3 + "android.widget.FrameLayout[3]";
                    break;

                default:
                    strFullxpath = "Object not found on Page Repo";
                    break;

            }
            return strFullxpath;
        }

    }
}
