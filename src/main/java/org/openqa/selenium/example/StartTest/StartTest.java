package org.openqa.selenium.example.StartTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Scanner;

public class StartTest  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String url = "http://";
        System.out.print("Enter site to test: ");
        url += in.nextLine();
        WebDriver driver = new FirefoxDriver();
        boolean isOnclick = false;
        driver.get(url);
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
                isOnclick = true;
            }

        }
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Check the title of the page
        System.out.println("Onclick is: " + isOnclick);

        //Close the browser
            driver.quit();
    }
}