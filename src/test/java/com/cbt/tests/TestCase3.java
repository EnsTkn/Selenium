package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");


        driver.findElement(By.linkText("Multiple Buttons")).click();

        BrowserUtills.wait(1);

        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        BrowserUtills.wait(1);


        WebElement a = driver.findElement(By.id("result"));
        String actualResult = a.getText();
        String resultMessage = "Clicked on button one!";

       System.out.println((actualResult.equals(resultMessage) ? "Test Passed" : "Test Failed"));


        driver.quit();

    }



}
