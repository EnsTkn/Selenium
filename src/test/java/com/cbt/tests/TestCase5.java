package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase5 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        //System.out.println(a);

        driver.findElement(By.xpath("//input[@data-bv-field='lastname']")).sendKeys("123");

        String a = driver.findElement(By.xpath("//small[@data-bv-validator=\'regexp\' and @data-bv-for=\'lastname\']")).getText();
        String b = "The last name can only consist of alphabetical letters and dash";


                if(a.equals(b)){
                    System.out.println("Passed");
                }else{
                    System.out.println("Failed");
                }

    driver.quit();
    }
}
