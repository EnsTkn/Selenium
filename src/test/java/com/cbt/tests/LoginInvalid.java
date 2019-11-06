package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginInvalid {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login\n");

        driver.manage().window().fullscreen();

        //(WebElement User = ) ?
        driver.findElement(By.id("prependedInput")).sendKeys("User189");

        BrowserUtills.wait(2);

        WebElement password = driver.findElement(By.id("prependedInput2"));

        password.sendKeys("1234");

        BrowserUtills.wait(2);

        driver.findElement(By.id("_submit")).click();


        String expResult = "Invalid user name or password.";
        WebElement rslt = driver.findElement(By.xpath("//div[contains(@class,'alert alert-error')]"));
        String result = rslt.getText();
        System.out.println(result);


        if (expResult.equals(result)) {
            System.out.println("Test Passed ! Yey");
        }else {
            System.out.println("Test Failed ! Loser");
            System.out.println("expResult: "+expResult);
            System.out.println("result: "+result);
        }

        driver.close();





    }


}
