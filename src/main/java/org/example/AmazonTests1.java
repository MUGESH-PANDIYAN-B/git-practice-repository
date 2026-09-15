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

public class AmazonTests1{
@Test
    public void searchElementTests() {
        AmazonTests amazonTest1 = new AmazonTests();
        WebElement searchButtonClick = amazonTest1.searchTest();
        amazonTest1.searchTest2(searchButtonClick);
        WebDriverWait wait=new WebDriverWait(amazonTest1.cDrive, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal\"]")));
        List<WebElement> searchElementList=amazonTest1.cDrive.findElements(By.xpath("//a[@class=\"a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal\"]"));
        System.out.println(searchElementList.size());
        for (WebElement elementDetails:searchElementList){
            System.out.println(elementDetails.getText());
            System.out.println(elementDetails.getAttribute("href"));
        }
    }
}
