package week2._3_Wednesday;

/*
Example:1:
1) Go to the "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver"
2) Click to the "Change Text to Selenium WebDriver Button"
3) Wait until "Selenium Webdriver" text is available
4) Assert that texts match

 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.time.Duration;

public class Task1 extends BaseDriver {

    public static void main(String[] args) {

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        MyFunctions.waitFunc(2);
        // I located the weblement
        WebElement changeTextToSeleniumWebDriver = driver.findElement(By.id("populate-text"));

        // I will click this
        changeTextToSeleniumWebDriver.click();

        // Creating explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[.='Selenium Webdriver']")));


        MyFunctions.waitFunc(2);

        // This is my last step I want to assert I have "Selenium Webdriver" text
        WebElement seleniumWebdriverText = driver.findElement(By.xpath("//h2[.='Selenium Webdriver']"));

        String expectedText = "Selenium Webdriver";

        if (seleniumWebdriverText.getText().equals(expectedText)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }














    }

}
