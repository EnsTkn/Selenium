package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        int numberOfListedExamples = driver.findElements(By.className("list-group-item")).size();

        System.out.println((48==numberOfListedExamples) ? "Passed" : "Failed");

        driver.quit();

    }
}
