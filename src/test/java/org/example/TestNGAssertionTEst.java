package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class TestNGAssertionTEst {
    WebDriver driver;
    @Test
    public void testAssertion() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"twotabsearchtextbox\"]")));
        TakesScreenshot screenShotHome = ((TakesScreenshot) driver);
        File tempShot = screenShotHome.getScreenshotAs(OutputType.FILE);
        File homeScreenShot = new File("D:\\ScreenShots\\homeScreenShot.png");
        try {
            FileHandler.copy(tempShot, homeScreenShot);
        } catch (Exception e) {
            System.out.println("Sorry");
        }
        WebElement searchButtonClick = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchButtonClick.sendKeys("Iphone 14");
        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
        screenShotHome.getScreenshotAs(OutputType.FILE);
        File tempShot1 = screenShotHome.getScreenshotAs(OutputType.FILE);
        File searchScreenShot = new File("D:\\ScreenShots\\aftersearchScreenShot.png");
        try {
            FileHandler.copy(tempShot1, searchScreenShot);
        } catch (Exception e) {
            System.out.println("Sorry cant take Result ScreenShot");
        }
        String actualTabTitle = driver.getTitle();
        Assert.assertEquals(actualTabTitle, "Amazon.com : Iphone 14");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
