package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AmazonTests {
    public WebDriver cDrive;

    public WebElement searchTest() {
        cDrive=new ChromeDriver();
        cDrive.get("https://www.amazon.com/");
        List <String> searchList=new ArrayList<String>();
        searchList.add("watch");
        searchList.add("laptop");
        searchList.add("mobile");
        searchList.add("headphones");
        searchList.add("shoes");
        searchList.add("bag");
        WebDriverWait wait=new WebDriverWait(cDrive, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@id=\"twotabsearchtextbox\"]")))).sendKeys("watch");
        WebElement buttonTest=cDrive.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
      // buttonTest.click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal\"]")));
        //List<WebElement> searchResults=cDrive.findElements(By.xpath("//a[@class=\"a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal\"]"));
//System.out.println("Search results size is:"+searchResults.size());

      // for (WebElement result:searchResults){
          //  System.out.println(result.getText());
         //  System.out.println(result.getAttribute("href"));

//}
       return buttonTest;
    }

    public void searchTest2(WebElement actionClick) {
        actionClick.click();

    }
    public static void main(String[] args) {
        AmazonTests amazonTest=new AmazonTests();
        WebElement buttonTest1=amazonTest.searchTest();
        amazonTest.searchTest2(buttonTest1);

     }



}

