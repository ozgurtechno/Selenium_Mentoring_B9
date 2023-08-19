package week1.Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyFunctions;

public class BookingTest extends BaseDriver {

    public static void main(String[] args) {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentBtn=driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password=driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        WebElement readmissionCheckBox=driver.findElement(By.id("chk_hospotal_readmission"));
        readmissionCheckBox.click();

        WebElement medicaId=driver.findElement(By.id("radio_program_medicaid"));
        medicaId.click();

        WebElement visitdate=driver.findElement(By.id("txt_visit_date"));
        visitdate.sendKeys("11/7/2023");

        WebElement comment=driver.findElement(By.id("txt_comment"));
        comment.click();
        MyFunctions.waitFunc(3);
        comment.sendKeys("Thank you!!!");

        WebElement bookingBtn=driver.findElement(By.id("btn-book-appointment"));
        bookingBtn.click();

        WebElement successMsg=driver.findElement(By.className("lead"));
        String text= successMsg.getText();
        System.out.println("text = " + text);

        if(text.contains("has been booked")){
            System.out.println("success");
            WebElement goToHomePage=driver.findElement(By.cssSelector("a[href='https://katalon-demo-cura.herokuapp.com/']"));
            goToHomePage.click();

        }
        else {
            System.out.println("failed");
        }
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.cssSelector("a[href='authenticate.php?logout']")).click();
        //authenticate.php?logout
        driver.quit();

    }

}
