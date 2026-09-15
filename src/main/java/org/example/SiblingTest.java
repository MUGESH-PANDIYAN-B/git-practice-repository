package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SiblingTest {
    public static WebDriver driver;

    @Test
    public static void sibblingTest()

    {
        driver = new ChromeDriver();
        By elementTowait=By.xpath("//a[@class=\"a-link-normal\"]");
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
       String masterXpath="//a|//script|//style|//meta|//link|//span|//li|//div";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementTowait));
       List<WebElement> findAllclickable=driver.findElements(By.xpath(masterXpath));
       System.out.println(findAllclickable.size());
       for(WebElement el:findAllclickable)
       {
           System.out.println(el.getText());
       }
    }
}

