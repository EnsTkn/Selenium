package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com", "https:// westelm.com/");



        for(String each: urls) {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);
            String title = driver.getTitle().replace(" ", "").toLowerCase();
            System.out.println(each+" Url contains the title "+each.toLowerCase().contains(title));

            driver.quit();

        }




    }
}
