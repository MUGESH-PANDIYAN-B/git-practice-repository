package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    List<String> randomTestList1=new ArrayList<>();
@Test
    public void AmazonRamTests(){
    randomTestList1.add("watch");
    randomTestList1.add("laptop");
    randomTestList1.add("mobile");
    randomTestList1.add("headphones");
    randomTestList1.add("shoes");
    randomTestList1.add("bag");
        for(int i=0;i<randomTestList1.size();i++){
            WebDriver cDrive=new ChromeDriver();
            cDrive.get("https://www.amazon.com/");
            WebDriverWait wait=new WebDriverWait(cDrive, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"twotabsearchtextbox\"]"))).sendKeys(randomTestList1.get(i));
            WebElement buttonTest=cDrive.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
            buttonTest.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"a-link-normal s-line-clamp-4 s-link-style a-text-normal\"]")));
            List<WebElement> searchElementList=cDrive.findElements(By.xpath("//a[@class=\"a-link-normal s-line-clamp-4 s-link-style a-text-normal\"]"));
            System.out.println(searchElementList.size());
            for (WebElement elementDetails:searchElementList){
                System.out.println(elementDetails.getText());
                System.out.println(elementDetails.getAttribute("href"));
            }
            cDrive.quit();
        }
    }
}
