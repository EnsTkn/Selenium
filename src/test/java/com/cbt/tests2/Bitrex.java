package com.cbt.tests2;


import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Bitrex {
    public static void main(String[] args) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://login1.nextbasecrm.com/");
            //enter email
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk65@cybertekschool.com");
            BrowserUtills.wait(2);
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
            BrowserUtills.wait(2);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            BrowserUtills.wait(2);
            driver.findElement(By.className("feed-add-post-micro-title")).click();
            BrowserUtills.wait(2);
            driver.findElement(By.xpath("//input[@type='hidden' and @value='jlhhlhl']")).sendKeys("Hello everyone");
           BrowserUtills.wait(2);
           // driver.findElement(By.xpath("//div[@onclick='showUserMenu()']")).click();
          //  BrowserUtills.wait(2);
         //   driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]")).click();
        //    BrowserUtills.wait(2);
            driver.quit();
        }
    }

