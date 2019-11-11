package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase8 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("phone")).sendKeys("5711234354”");

        String a = driver.findElement(By.xpath("//small[@data-bv-validator='regexp' and @data-bv-for='phone']")).getText();

        String b = "Phone format is not correct";

        System.out.println((a.equals(b) ? "passed" : "failed"));


        driver.quit();
    }
}
