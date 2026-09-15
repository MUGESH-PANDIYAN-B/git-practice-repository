package com.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    public static WebDriver driver;

    public static WebDriver launchBrowser(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to launch browser: " + e.getMessage());

        }
        return driver;
    }

    protected static WebDriver launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to open URL: " + e.getMessage());
        }
        return driver;
    }

    public static void passInput(String element, String value) {
        try {
            WebElement element1=driver.findElement(By.xpath(element));
            element1.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to pass input: " + e.getMessage());
        }
    }

    public static void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to click element: " + e.getMessage());
        }
    }

    public static void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to quit browser: " + e.getMessage());
        }
    }

    public static void windowsHandling(int index) {
        try {
            List<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(allWindows.get(index));
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to switch window: " + e.getMessage());
        }

    }
    public static void selectDropDown(WebElement element,String type,String value){
        Select selectOptions=new Select(element);
        try{
            if(type.equalsIgnoreCase("value")){
                selectOptions.selectByValue(value);
            }
            else if(type.equalsIgnoreCase("index")){
                selectOptions.selectByIndex(Integer.parseInt(value));
            }
            else if(type.equalsIgnoreCase("visibletext")){
                selectOptions.selectByVisibleText(value);
            }
        }catch (Exception e){
            Assert.fail("ERROR:Failed to select dropdown: " + e.getMessage());
        }
    }
    public static void deselectSelectOptions(WebElement deElement,String deType,String deValue){
        Select selectOptions=new Select(deElement);
        try {
            if (deType.equalsIgnoreCase("value")) {
                selectOptions.deselectByValue(deValue);
            } else if (deType.equalsIgnoreCase("index")) {
                selectOptions.deselectByIndex(Integer.parseInt(deValue));
            } else if (deType.equalsIgnoreCase("visibletext")) {
                selectOptions.deselectByVisibleText(deValue);
            }
        }
            catch (Exception e){
                Assert.fail("ERROR:Failed to deselect dropdown: " + e.getMessage());
            }

    }
    public static void alertHandle(String action) {
        try {
            if(action.equalsIgnoreCase("accept")){
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
            else if(action.equalsIgnoreCase("dismiss")){
                Alert alert = driver.switchTo().alert();
                alert.dismiss();
            }
        } catch (Exception e) {
            Assert.fail("ERROR:Failed to handle alert: " + e.getMessage());
        }

    }
}


