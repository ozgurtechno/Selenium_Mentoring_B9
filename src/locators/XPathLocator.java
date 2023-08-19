package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;

public class XPathLocator extends BaseDriver {

    public static void main(String[] args) {

        driver.get("https://accounts.lambdatest.com/login");

        //tagname[@attribute = 'value']
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        //tagname[contains(@attribute, ‘partial value of attribute’)]
        WebElement emailInput2 = driver.findElement(By.xpath("//input[contains(@class,'form-control')]"));

        //input[@id='login_1' OR @name='login’]
        WebElement emailInput3 = driver.findElement(By.xpath("//input[@type='email' AND @name='email']"));
        WebElement emailInput4 = driver.findElement(By.xpath("//input[@type='email' OR @name='email']"));

        //tagname[starts-with(@attribute,'starting name of the attribute value')]
        WebElement passwordInput = driver.findElement(By.xpath("//input[starts-with(@name,'pass')]"));

        emailInput.sendKeys("Hello");
        Bekle(3);

        driver.navigate().to("https://accounts.lambdatest.com/register");
        Bekle(1);

        //div[text()='Logged In']
        WebElement signUp = driver.findElement(By.xpath("//button[text()='FREE SIGN UP']"));
        signUp.click();

        // ----------------------------- child - sibling --------------------------------------------------------------

        WebElement fullNameInput = driver.findElement(By.xpath("(//button[text()='FREE SIGN UP']/../..//div//input)[1]"));
        fullNameInput.sendKeys("Merhaba");
        BekleKapat();
        //  ->     //button[text()='FREE SIGN UP']/../..//input
        //  ->     //button[text()='FREE SIGN UP']/../../following-sibling::div
        //  ->     //button[text()='FREE SIGN UP']/../..//following-sibling::div

    }


    public void locatorTest(){

    }
}
