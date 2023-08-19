package week1.Day_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public static void main(String[] args) {
        // how to create new selenium project?
        // How to define the selenium libraries?
        // How to create Webdriver ?
        // How to navigate to website to test?
        // How to inspect pages ?
        // How to locate elements ById
        // How to click on elements
        // How to send keys to specific element
        // how to define wait function?
        // How to quit driver?

        ChromeOptions options=new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver();
        // Navigated to website
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //maximize
        driver.manage().window().maximize();

        WebElement makeAppointmentBtn=driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();
        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        WebElement bookApp=driver.findElement(By.id("btn-book-appointment"));
        if (bookApp.getText().contains("Book")){
            System.out.println(bookApp.getText());
            System.out.println("You logged in");
        }else {
            System.out.println("attempt failed");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}