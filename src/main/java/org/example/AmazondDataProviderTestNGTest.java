package org.example;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.time.Duration;

public class AmazondDataProviderTestNGTest {
    public WebDriver driver;

    @DataProvider(name = "searchData")
    public Object[][] searchDataa() {
        return new Object[][]{
                {"Iphone 14", "Amazon.com : Iphone 14"},
                {"Samsung Galaxy S23", "Amazon.com : Samsung Galaxy S23"},
                {"Google Pixel 7", "Amazon.com : Google Pixel 7"},
                {"OnePlus 11", "Amazon.com : OnePlus 11"},
                {"Sony Xperia 1 IV", "Amazon.com : Sony Xperia 1 IV"},
        };
    }

    @BeforeMethod
    public void openBrowserAndNavigateToAmazon() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"twotabsearchtextbox\"]")));
    }
    @Test(dataProvider ="searchData")
    public void searchDataTest(String searchTerm, String expectedTitle) {
        TakesScreenshot screenShotHome = ((TakesScreenshot) driver);
        File tempShot = screenShotHome.getScreenshotAs(OutputType.FILE);
        File homeScreenShot = new File("D:\\ScreenShots\\" + searchTerm + "homeScreenShot.png");
        try {
            FileHandler.copy(tempShot, homeScreenShot);
        } catch (Exception e) {
            System.out.println("Sorry");
        }
        WebElement searchButtonClick = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchButtonClick.sendKeys(searchTerm);
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
        Assert.assertEquals(actualTabTitle, expectedTitle);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
