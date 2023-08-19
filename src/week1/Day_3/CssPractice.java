package week1.Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyFunctions;

public class CssPractice extends BaseDriver {

    public static void main(String[] args) {

        driver.get("https://www.amazon.com");

        MyFunctions.waitFunc(3);

        // Gift Card with CSS Selector
        WebElement giftCard = driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']"));
        System.out.println(giftCard.getText());

        // Registry Button with CSS Selector
        WebElement registryButton = driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_registry']"));
        System.out.println(registryButton.getText());

        // Sell Button with CSS Selector
        WebElement sellButton = driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_sell']"));
        System.out.println(sellButton.getText());

    }


}
