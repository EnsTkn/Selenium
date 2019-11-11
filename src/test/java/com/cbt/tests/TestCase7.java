package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase7 {
    public static void main(String[] args) {


    WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.name("email")).sendKeys("testers@email");

        String b = "email address is not a valid";
        String d = "Email format is not correct";

        String a = driver.findElement(By.xpath("//small[@data-bv-validator='emailAddress' and @data-bv-for='email']")).getText();
        String c = driver.findElement(By.xpath("//small[@data-bv-validator='regexp' and @data-bv-for='email']")).getText();

        if(b.equals(a) && d.equals(c)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }




        driver.quit();

}

}
