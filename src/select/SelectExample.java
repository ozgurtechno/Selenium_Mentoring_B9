package select;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseDriver;

public class SelectExample extends BaseDriver {

    @Test
    public void selectTest() throws InterruptedException {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        Select selectBox = new Select(driver.findElement(By.name("my-select")));
        selectBox.selectByIndex(0);
        selectBox.getOptions().forEach(opt -> System.out.println(opt.getText()));

        System.out.println("-----------------------------------------------------");
        Bekle(3);

        selectBox.selectByValue("2");
        System.out.println("get first : "+selectBox.getFirstSelectedOption().getText());

        System.out.println("-----------------------------------------------------");
        Bekle(3);

        selectBox.selectByVisibleText("Three");
        System.out.println("get first : "+selectBox.getFirstSelectedOption().getText());

        System.out.println("-----------------------------------------------------");

        selectBox.getAllSelectedOptions().forEach(opt -> System.out.println(opt.getText()));

        Assert.assertEquals(selectBox.getFirstSelectedOption().getText(), "Three");

        driver.quit();
    }

    @Test
    public void multiSelect(){
        driver.get("https://omayo.blogspot.com/");

        Select multiSelectBox = new Select(driver.findElement(By.id("multiselect1")));
        multiSelectBox.isMultiple();

        multiSelectBox.selectByIndex(0);
        multiSelectBox.selectByIndex(2);

        multiSelectBox.getAllSelectedOptions().forEach(opt -> System.out.println(opt.getText()));
        driver.quit();
    }


}