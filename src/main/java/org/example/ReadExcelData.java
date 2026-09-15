package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class ReadExcelData {

    public static void getParticularData(int rowValue,int colValue) {
        try {
            File filepath = new File("C:\\Users\\Mugesh Pandiyan B\\Downloads\\DataDriven_IPT.xlsx");
            Workbook workbook = new XSSFWorkbook(filepath);
            Sheet workSheet = workbook.getSheet("Sheet1");
            Row row=workSheet.getRow(rowValue);
            Cell cell=row.getCell(colValue);
            WebDriver chrome = new ChromeDriver();
            chrome.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
            chrome.get("https://www.youtube.com/");
            WebElement searchElement= chrome.findElement(By.xpath("//input[@name=\"search_query\"]"));
            String searchValue=cell.getStringCellValue();
            searchElement.sendKeys(searchValue);
           System.out.println(cell.getStringCellValue());
           WebElement searchButton= chrome.findElement(By.xpath("//button[@class=\"ytSearchboxComponentSearchButton\"]"));
            WebDriverWait wait = new WebDriverWait(chrome, java.time.Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
              searchButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        getParticularData(4, 0); // Example: Read data from row 1, column 1
    }
}
