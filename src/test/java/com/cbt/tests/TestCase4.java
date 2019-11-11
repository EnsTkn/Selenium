package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase4 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        //System.out.println(a);

        driver.findElement(By.name("firstname")).sendKeys("123");

        String a = driver.findElement(By.xpath("//small[@data-bv-validator='regexp']")).getText();
        System.out.println(a);

        String b = "first name can only consist of alphabetical letters";

        if(a.equals(b)) {
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


        driver.quit();
    }
}
