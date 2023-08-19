package week2._2_tuesday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseDriver;

public class TaskActions extends BaseDriver {
    public static void main(String[] args) {

        // Create an object for the Actions class
        // Click function
        // Send keys function
        // MoveToElement
        // Double click
        // Right Click
        //Drag and drop
        driver.get("https://www.google.com/");

        //cookies click function
        WebElement cookies = driver.findElement(By.xpath("//div[text()=\"Reject all\"]"));
        Actions action = new Actions(driver);
        action.click(cookies).build().perform();

        //search box  send keys function
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        action.sendKeys(searchBox, "Iphone").build().perform();

        // MoveToElement
        driver.navigate().to("https://testsigma.com/");

        WebElement resources = driver.findElement(By.xpath("//a[normalize-space()='Resources']"));
        action.moveToElement(resources).build().perform();

        WebElement blog = driver.findElement(By.xpath("//i[@class='fa fa-blogger-b']"));
        action.click(blog).build().perform();


        driver.navigate().to("https://demoqa.com/buttons");
        // Right Click
        WebElement rightClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        action.contextClick(rightClick).build().perform();

        // Double click
        WebElement doubleClick = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        action.doubleClick(doubleClick).build().perform();

        //Drag and drop
        driver.navigate().to("https://demoqa.com/droppable/");

        WebElement from = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement to = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        action.dragAndDrop(from, to).build().perform();


        driver.quit();
    }

}
