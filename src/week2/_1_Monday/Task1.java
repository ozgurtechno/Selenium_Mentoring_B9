package week2._1_Monday;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.util.List;
//TODO PATLADI
public class Task1 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://itera-qa.azurewebsites.net/");
        // Login Test
        WebElement login= driver.findElement(By.xpath("//a[@href=\"/Login\"]"));
        login.click();
        WebElement userName= driver.findElement(By.cssSelector("input[id='Username']"));
        userName.sendKeys("1qaz");

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("1qaz");

        WebElement loginBtn= driver.findElement(By.xpath("//input[@name='login']"));
        loginBtn.click();

        //Navigate to auto test

        WebElement autoPractice=driver.findElement(By.xpath("//a[normalize-space()='Test Automation']"));
        autoPractice.click();

        // Select gender
        WebElement genderFemale=driver.findElement(By.cssSelector("input#female"));
        System.out.println("genderFemale.isSelected() = " + genderFemale.isSelected());// false
        System.out.println("genderFemale.isDisplayed() = " + genderFemale.isDisplayed());// true
        System.out.println("genderFemale.isEnabled() = " + genderFemale.isEnabled()); // true
        genderFemale.click();
        System.out.println("genderFemale.isSelected() = " + genderFemale.isSelected()); //true

        WebElement otherRadioBtn=driver.findElement(By.cssSelector("input#other"));
        System.out.println("otherRadioBtn.isEnabled() = " + otherRadioBtn.isEnabled());//  false
        System.out.println("otherRadioBtn.isDisabled = " + otherRadioBtn.isDisplayed());// true

        // Select functions

        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@class='custom-select']"));
        Select select = new Select(dropDownMenu);
        select.selectByIndex(2);

        MyFunctions.waitFunc(2);

        select.selectByValue("5");
        MyFunctions.waitFunc(2);
        select.selectByVisibleText("Norway");

        List<WebElement>optionList=driver.findElements(By.cssSelector(".custom-select>option"));
        for (int i = 0; i < optionList.size(); i++) {
            select.selectByIndex(i);
            System.out.println(optionList.get(i).getText()+" is selected ?= "+ optionList.get(i).isSelected());
            MyFunctions.waitFunc(2);

        }

        MyFunctions.waitFunc(3);
        driver.quit();

    }
}
