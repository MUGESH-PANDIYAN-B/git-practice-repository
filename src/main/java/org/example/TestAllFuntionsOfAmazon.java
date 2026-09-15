package org.example;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;
public class TestAllFuntionsOfAmazon {
    public static WebDriver driver;
    public static Scanner scanner = new Scanner(System.in);
    public static void openBrowser() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void navigateToAmazon() {
        System.out.println("Enter the URL");
        String http="https://";
        driver.get(http+scanner.nextLine());
    }
    public static void gettingElementTimeOut()
    {
        System.out.println("Enter the xpath of the element to wait for:");
        String giveElement=scanner.nextLine();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(giveElement)));
    }
   public static WebElement gettingElementType()
    {
        System.out.println("Enter the type of element are you goona give:");
        System.out.println("Press one:1 for Input Box Element");
        System.out.println("Press two:2 for Button Element");
        System.out.println("Press three:3 for Product Element");
        int givenElement=scanner.nextInt();
        if (givenElement==1)
        {
            System.out.println("Enter the Input Box Element");
            String inputBoxElementText=scanner.nextLine();
            WebElement inputBoxElement=driver.findElement(By.xpath(inputBoxElementText));
            inputBoxElement.click();
            inputBoxElement.sendKeys("Mobile");
            inputBoxElement.sendKeys(Keys.ENTER);
            System.out.println("Give The Element To Click");
            String getting=scanner.nextLine();
            WebElement gettingElement=driver.findElement(By.xpath(getting));
            return gettingElement;
            
        }

        return gettingElementType();
    }
    public static void main(String[] args) {
        openBrowser();
        navigateToAmazon();
        gettingElementTimeOut();
        WebElement element = gettingElementType();
    }

}
