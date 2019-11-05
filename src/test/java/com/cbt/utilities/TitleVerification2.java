package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https:// westelm.com/");


        WebDriver driver = BrowserFactory.getDriver("chrome");


        driver.get("https://lulugandgeorgia.com");
        String url1 = driver.getCurrentUrl();
        String title1 = driver.getTitle().replace(" ", "").toLowerCase();


        driver.get("https://wayfair.com/");
        String url2 = driver.getCurrentUrl();
        String title2 = driver.getTitle().replace(" ", "").toLowerCase();


        driver.get("https://walmart.com");
        String url3 = driver.getCurrentUrl();
        String title3 = driver.getTitle().replace(" ", "").toLowerCase();


        driver.get("https:// westelm.com/");
        String url4 = driver.getCurrentUrl();
        String title4 = driver.getTitle().replace(" ", "").toLowerCase();

        System.out.println((url1.contains(title1)) ? "Passed" : "Failed");

        System.out.println((url2.contains(title2)) ? "Passed" : "Failed");

        System.out.println((url3.contains(title3)) ? "Passed" : "Failed");

        System.out.println((url4.contains(title4)) ? "Passed" : "Failed");

        driver.quit();

    }
}
