package select;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseChromeTest;
import utilities.BaseDriver;

public class Omayo extends BaseDriver {

    public static void main(String[] args) {



            BaseDriver.driver.get("https://omayo.blogspot.com/");
        Select select = new Select(driver.findElement(By.id("multiselect1")));
        WebElement option1 = driver.findElement(By.cssSelector("option[value=volvox]"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value=Hyundaix]"));
        select.selectByVisibleText("Volvo");
        select.selectByValue("Hyundaix");

        Assertions.assertTrue(option1.isSelected());
        Assertions.assertTrue(option2.isSelected());



    }
}
