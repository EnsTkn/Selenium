    package com.cbt.tests2;

    import com.cbt.utilities.BrowserFactory;
    import com.cbt.utilities.BrowserUtills;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.Select;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

    public class TestCase1and5 {

        private WebDriver driver;

        @BeforeMethod
        public void driver() {

            driver = BrowserFactory.getDriver("chrome");
        }


        @Test
        public void testcase1() {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
            driver.findElement(By.cssSelector("[class=\"form-control\"][placeholder=\"MM/DD/YYYY\"]")).sendKeys("wrong_dob");
            WebElement actual = driver.findElement(By.cssSelector("small[data-bv-for=\"birthday\"][data-bv-validator=\"date\"]"));
            Assert.assertTrue(actual.isDisplayed(), "Warning message is not displayed !");
        }


        @Test
        public void testcase2() {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
            WebElement o1 = driver.findElement(By.cssSelector("[class=\"form-check-label\"][for=\"inlineCheckbox1\"]"));
            WebElement o2 = driver.findElement(By.cssSelector("[class=\"form-check-label\"][for=\"inlineCheckbox2\"]"));
            WebElement o3 = driver.findElement(By.cssSelector("[class=\"form-check-label\"][for=\"inlineCheckbox3\"]"));
            Assert.assertTrue(o1.isDisplayed(), "c++ is not displayed!");
            Assert.assertTrue(o2.isDisplayed(), "Java is not displayed");
            Assert.assertTrue(o3.isDisplayed(), "JavaScript is not displayed");
        }

        @Test
        public void testcase3() {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
            driver.findElement(By.cssSelector("[name=\"firstname\"][ placeholder=\"first name\"]")).sendKeys("a");
            WebElement message = driver.findElement(By.xpath("//*[text()='first name must be more than 2 and less than 64 characters long']"));
            Assert.assertTrue(message.isDisplayed(), "Warning message is not displayed");
        }


        @Test
        public void testcase4() {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
            driver.findElement((By.xpath("//input[@placeholder=\"last name\" and @data-bv-field=\"lastname\"]"))).sendKeys("b");
            WebElement message = driver.findElement(By.xpath("//*[text()='The last name must be more than 2 and less than 64 characters long']"));
            Assert.assertTrue(message.isDisplayed(), "Warning message is not displayed");
        }


        @Test
        public void testcase5() throws InterruptedException {
            driver.get("https://practice-cybertekschool.herokuapp.com");
            BrowserUtills.wait(1);
            driver.manage().window().fullscreen();
            driver.findElement(By.cssSelector("a[href=\"/registration_form\"]")).click();
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[name=\"firstname\"][ placeholder=\"first name\"]")).sendKeys("Mike");
            BrowserUtills.wait(1);
            driver.findElement((By.xpath("//input[@placeholder=\"last name\" and @data-bv-field=\"lastname\"]"))).sendKeys("adsfasd");
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[placeholder=\"username\"][data-bv-field=\"username\"]")).sendKeys("Username");
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[placeholder=\"email@email.com\"][data-bv-field=\"email\"]")).sendKeys("name@email.com");
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[name=\"password\"][data-bv-field=\"password\"]")).sendKeys("12345678910");
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[name=\"phone\"][data-bv-field=\"phone\"]")).sendKeys("201-900-2391");
            BrowserUtills.wait(1);
            driver.findElement(By.cssSelector("[name=\"gender\"][value=\"male\"]")).click();
            BrowserUtills.wait(1);
            driver.findElement(By.xpath("//input[@placeholder=\"MM/DD/YYYY\" and @data-bv-field=\"birthday\"]")).sendKeys("11/12/2000");
            BrowserUtills.wait(1);


            Select select = new Select(driver.findElement(By.name("department")));
            select.selectByValue("DE");
            Thread.sleep(1000);
            String expected = "Department of Engineering";
            String actual = select.getFirstSelectedOption().getText();
            System.out.println("expected: " + expected);
            System.out.println("actual: " + actual);

            Select select1 = new Select(driver.findElement(By.name("job_title")));
            select1.selectByIndex(4);
            BrowserUtills.wait(2);
            String expected1 = "SDET";
            String actual1 = select1.getFirstSelectedOption().getText();
            System.out.println("expected: " + expected1);
            System.out.println("actual: " + actual1);

            driver.findElement(By.id("inlineCheckbox2")).click();
            driver.findElement(By.id("wooden_spoon")).click();

            WebElement text = driver.findElement(By.xpath("//*[starts-with(text(),'You')]"));
            String actualResult = text.getText();
            String expectedResult = "You've successfully completed registration!";
            BrowserUtills.wait(2);
            Assert.assertEquals(actualResult, expectedResult);
            Assert.assertTrue(text.isDisplayed(), "None");
            System.out.println("actualResult: " + actualResult);


        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }


