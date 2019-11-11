package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase6 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("username")).sendKeys("user");

        String a = driver.findElement(By.xpath("//small[@data-bv-validator='stringLength'and @data-bv-for='username']")).getText();

        String b = "The username must be more than 6 and less than 30 characters long";

        System.out.println(a.equals(b) ? "Passed" : "Failed");
        System.out.println(a);

        driver.quit();
    }
}
