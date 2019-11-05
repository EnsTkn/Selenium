package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        testChrome();
        testSafari();
        //testFirefox();

    }


        public static void testChrome() {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://google.com");
            String expected1 = driver.getTitle();

            driver.get("https://etsy.com");
            String expected2 = driver.getTitle();

            driver.navigate().back();

            String actual1 = driver.getTitle();
            StringUtility.verifyEquals(expected1, actual1);

            driver.navigate().forward();

            String actual2 = driver.getTitle();
            StringUtility.verifyEquals(expected2, actual2);

            driver.quit();

        }

    public static void testSafari() {

        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        String expected1 = driver.getTitle();

        driver.get("https://etsy.com");
        String expected2 = driver.getTitle();

        driver.navigate().back();

        String actual1 = driver.getTitle();
        StringUtility.verifyEquals(expected1, actual1);

        driver.navigate().forward();

        String actual2 = driver.getTitle();
        StringUtility.verifyEquals(expected2, actual2);

        driver.quit();

    }
/*
    public static void testFirefox() {

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String expected1 = driver.getTitle();

        driver.get("https://etsy.com");
        String expected2 = driver.getTitle();

        driver.navigate().back();

        String actual1 = driver.getTitle();
        StringUtility.verifyEquals(expected1, actual1);

        driver.navigate().forward();

        String actual2 = driver.getTitle();
        StringUtility.verifyEquals(expected2, actual2);

        driver.quit();

    }
*/
}
