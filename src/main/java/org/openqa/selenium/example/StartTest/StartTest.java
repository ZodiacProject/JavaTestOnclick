package org.openqa.selenium.example.StartTest;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;


public class StartTest  {

    public static final String USERNAME = "propellerads";
    public static final String ACCESS_KEY = "26afe3cc-980b-4fd5-ad37-81f748f10b5c";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static void main(String[] args) throws MalformedURLException {

        Scanner in = new Scanner(System.in);
        String url = "http:" + "//";
        boolean isOnclick = false;
        System.out.print("Enter site to test: ");
        url += in.nextLine();


        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "41.0");
        caps.setCapability("name", "Java simple test");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
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
                    System.out.println(driver.getTitle());
                    driver.close();
                }
            }
            isOnclick = true;
        }

        // Check the title of the page
        System.out.println("Onclick is: " + isOnclick);

        //Close the browser
        driver.quit();
    }
}