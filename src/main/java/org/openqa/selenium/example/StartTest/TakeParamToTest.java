package org.openqa.selenium.example.StartTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ppuser on 16.11.2015.
 */
public class TakeParamToTest
{
    public static final String USERNAME = "propellerads";
    public static final String ACCESS_KEY = "26afe3cc-980b-4fd5-ad37-81f748f10b5c";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public WebDriver SetParam (String platform, DesiredCapabilities cap) throws MalformedURLException
    {
        if (cap.getBrowserName().equals("firefox"))
            cap.setVersion("42.0");
        if (cap.getBrowserName().equals("chrome"))
            cap.setVersion("46.0");
        if (cap.getBrowserName().equals("safari"))
            cap.setVersion("9.0");

        cap.setCapability("platform", platform);
        cap.setCapability("name", "Java the test failed");
        System.out.println();
        WebDriver driver = new RemoteWebDriver(new URL(URL), cap);
        return driver;
    }
}
