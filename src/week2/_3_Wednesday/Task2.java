package week2._3_Wednesday;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.time.Duration;

/*

Example:2:
1) Go to the "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver"
2) Click to the alert button
3) Wait until alert is displayed
4) Switch to the alert and accept it

 */
public class Task2  extends BaseDriver {

    public static void main(String[] args) {

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        MyFunctions.waitFunc(2);

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());


        MyFunctions.waitFunc(4);

        // I want to go to the alert and accept it

        Alert alert = driver.switchTo().alert();
        alert.accept();








    }


}
