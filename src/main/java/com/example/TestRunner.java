package com.example;

public class TestRunner extends BaseClass {
    public static void main(String[] args) {
        // Launch the browser
        launchBrowser("chrome");

        // Launch the URL
        launchUrl("https://www.google.com");
        passInput("//textarea[@class='gLFyf']", "Selenium WebDriver");




        // Perform other test actions here...

        // Close the browser
        driver.quit();
    }
}
