package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AmazonTests2 {
    @Test
    public void catogoryButtonTest()
    {
        AmazonTests callingMainClass=new AmazonTests();
        WebElement searchButtonClick=callingMainClass.searchTest();
        callingMainClass.searchTest2(searchButtonClick);
        WebDriverWait wait=new WebDriverWait(callingMainClass.cDrive, java.time.Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"a-link-normal s-navigation-item\"]")));
        List<WebElement> categoryButtonList=callingMainClass.cDrive.findElements(By.xpath("//a[@class=\"a-link-normal s-navigation-item\"]"));
    System.out.println(categoryButtonList.size());
    for(WebElement filterElement:categoryButtonList)
    {
        System.out.println(filterElement.getText());
        System.out.println(filterElement.getAttribute("href"));
    }
    }
}
