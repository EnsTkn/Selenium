package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        String actual1 = driver.getTitle();
        String url1 = driver.getCurrentUrl();

        driver.get("http://practice.cybertekschool.com/dropdown");
        String actual2 = driver.getTitle();
        String url2 = driver.getCurrentUrl();

        driver.get("http://practice.cybertekschool.com/login");
        String actual3 = driver.getTitle();
        String url3 = driver.getCurrentUrl();

        System.out.println( actual1.equalsIgnoreCase(actual2) && actual1.equalsIgnoreCase(actual3) ? "The Titles Are Same !"
                : "The Titles Are Not Same !" + "\n"+ "actual1: "+actual1 + " " + "actual2: "+actual2+" "+"actual3: "+actual3 );

        if(url1.startsWith("http://practice.cybertekschool.com")) {
            System.out.println("Passed");
            System.out.println("url1: "+url1);
        }else{
            System.out.println("Failed");
            System.out.println("url1: "+url1);
        }

        if(url2.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Passed");
            System.out.println("url2: "+url2);
        }else {
            System.out.println("Failed");
            System.out.println("url2: "+url2);

        }

        if(url3.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Passed");
            System.out.println("url3: "+url3);

        }else {
            System.out.println("Failed");
            System.out.println("url3: "+url3);

        }

        driver.quit();

    }
}
