package org.openqa.selenium.example.StartTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StartTest  {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        int count = 0;
        driver.get("http://putlocker.is");
        String startPage = driver.getWindowHandle();
        driver.switchTo().activeElement().click();
        if (driver.getWindowHandles().size() > 1)
        {
            System.out.println(driver.getWindowHandles().size());
            for (String handle : driver.getWindowHandles())
            {
                driver.switchTo().window(handle);

                if (startPage != handle)
                {
                    System.out.println(driver.getTitle());
                    driver.switchTo().window(handle).close();
                    count++;
                }
            }

        }
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Check the title of the page
        System.out.println("Count: " + count);

        //Close the browser
//        driver.quit();
    }
}