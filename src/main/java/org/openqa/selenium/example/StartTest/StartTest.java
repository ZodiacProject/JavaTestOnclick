package org.openqa.selenium.example.StartTest;
import com.sun.glass.ui.View;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.reflect.Array;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import netscape.javascript.JSObject;


public class StartTest  {
    public static WebDriver driver;
    public static void main(String[] args) throws MalformedURLException
    {
        //Scanner in = new Scanner(System.in);
        String url = "http://putlocker.is";
        boolean isOnclick;
        ArrayList<String> Lplatform = new ArrayList<String>(Arrays.asList("Windows 7", "Windows 10", "OS X 10.11"));
        ArrayList<DesiredCapabilities> caps =  new ArrayList<DesiredCapabilities>();
        caps.add(DesiredCapabilities.firefox());
        caps.add(DesiredCapabilities.chrome());
        caps.add(DesiredCapabilities.safari());

        TakeParamToTest paramToTest = new TakeParamToTest();
        for (String platform : Lplatform)
        {
            for (DesiredCapabilities cap : caps)
            {
                isOnclick = false;
                if (cap.getBrowserName().equals("safari") && (platform.equals("Windows 7") || platform.equals("Windows 10")))
                    continue;
                if ((cap.getBrowserName().equals("chrome") || cap.getBrowserName().equals("firefox")) && platform.equals("OS X 10.11"))
                    continue;

                driver = paramToTest.SetParam(platform, cap);

        driver.navigate().to(url);
        String startPage = driver.getWindowHandle();
        driver.switchTo().activeElement().click();
        if (driver.getWindowHandles().size() > 1)
        {
            for (String handle : driver.getWindowHandles())
            {
                driver.switchTo().window(handle);
                if (!startPage.equals(handle))
                {
                    driver.close();
                    isOnclick = true;
                }
            }
        }
        // Check the title of the page
        System.out.println(platform + " " + cap.getBrowserName() + " Onclick is: " + isOnclick);
        // Set a status for test case
        SetStatus(isOnclick);
        //Close the browser
        driver.quit();
            }
        }
    }
    public static void SetStatus(boolean allStastus)
    {
        if (allStastus)
            ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
        else
            ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
    }
}