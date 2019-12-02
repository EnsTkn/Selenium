package com.cbt.tests2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase6and13 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setDriver() {
        driver= BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);

    }


    @Test
    public void testcase6() {

        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        String email = driver.findElement(By.cssSelector("[id=\"email\"][class=\"animace\"]")).getText();
        //String email = "dravin.zakye@iiron.us";
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[starts-with(text(), 'Sign')]")).click();
        driver.findElement(By.cssSelector("[type=\"text\"][name=\"full_name\"]")).sendKeys("name");
        driver.findElement(By.xpath("//input[@type='email' and @name='email']")).sendKeys(email);
        BrowserUtills.wait(1);

        driver.findElement(By.cssSelector("[class=\"radius\"][type=\"submit\"]")).click();
        BrowserUtills.wait(1);
        WebElement message = driver.findElement(By.xpath("//*[text()='Thank you for signing up. Click the button below to return to the home page.']"));
        Assert.assertTrue(message.isDisplayed(), "Warning !");

        driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement receivedEmail = driver.findElement(By.xpath("//td[text()= 'do-not-reply@practice.cybertekschool.com']"));
        String actualEmail = receivedEmail.getText();
        actualEmail= actualEmail.trim();
        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(ExpectedEmail, actualEmail, "Not the same !");

        receivedEmail.click();
        WebElement Sender = driver.findElement(By.id("odesilatel"));
        String actualSender = Sender.getText();
        String expextedSender = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualSender, expextedSender, "Sender is not the same!");

        WebElement subject = driver.findElement(By.id("predmet"));
        String actualsubject = subject.getText();
        String expectedsubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualsubject, expectedsubject, "The subject is not the same!");



    }

    @Test
    public void testcase7() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("file-upload")).sendKeys("/Users/enestekin/Desktop/login.html");
        BrowserUtills.wait(1);
        driver.findElement(By.id("file-submit")).click();

        WebElement subject = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        String actualSubject = subject.getText();
        String excepctedSubject = "File Uploaded!";
        Assert.assertEquals(actualSubject, excepctedSubject, "None!");
        Assert.assertTrue(subject.isDisplayed(), "Not displayed!");

        WebElement filename = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(filename.isDisplayed(), "not displayed!");

    }

    @Test(description = "Test to verify if the message is displayed")
    public void testcase8() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
        BrowserUtills.wait(1);

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        BrowserUtills.wait(1);
        driver.findElement(By.cssSelector("[class=\"btn btn-primary\"]")).click();
        WebElement message = driver.findElement(By.id("result"));
        Assert.assertTrue(message.isDisplayed(), "Not displayed!");

    }

    @DataProvider(name = "data")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"200", "This page returned a 200 status code"},
                {"301", "This page returned a 301 status code"},
                {"404", "This page returned a 404 status code"},
                {"500", "This page returned a 500 status code"}

        };
    }

    @Test (dataProvider = "data")
    public void testcase9and13(String buttonName, String expectedResult) {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().fullscreen();

        WebElement statuscode = driver.findElement(By.cssSelector("[href=\"/status_codes\"]"));
        wait.until(ExpectedConditions.visibilityOf(statuscode));
        statuscode.click();

        WebElement button =  driver.findElement(By.linkText(buttonName));
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();

        WebElement result = driver.findElement(By.xpath("//p[contains(text(), 'status code.')]"));
        Assert.assertTrue(result.isDisplayed(), "not displayed!");
        wait.until(ExpectedConditions.visibilityOf(result));

        String actualResult = result.getText();
        int indexOfDot = actualResult.indexOf(".");
        actualResult = actualResult.substring(0,indexOfDot);
        Assert.assertEquals(actualResult, expectedResult, "Not same");
        System.out.println(actualResult);
        System.out.println(expectedResult);


    }





    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
