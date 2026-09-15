package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WindowsHandlesTest {
    WebDriver driver;
    @Test
    public void windowsHandlesTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"twotabsearchtextbox\"]")));
        WebElement searchButtonClick = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchButtonClick.sendKeys("Iphone 14");
        driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cy=\"title-recipe\"]")));
        List<WebElement> phoneClick = driver.findElements(By.xpath("//div[@data-cy=\"title-recipe\"]"));
        phoneClick.get(0).click();
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println(allWindowHandles);
            for (String handle : allWindowHandles) {
                if (!allWindowHandles.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                }
            }
        }
        catch (Exception e) {
            System.out.println("No windows found");
        }
    }}