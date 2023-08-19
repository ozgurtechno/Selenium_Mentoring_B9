package week2._4_Thursday;

 /*
        1) Go to the website "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target" and get the title
        2) Handle the accept button and click it
        3) Get windowhandle of the current window
        4) Switch to iframe and click visitw3 link ( a new window will get opened)
        5) Switch driver to new window
        6) Get the title of new page
        7) Print each window title
        8) Try Close the driver/ Quit Driver
        9) Switch driver to main page again
        10) Assert that driver in main page again

         */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.util.Set;

public class Task1 extends BaseDriver {

    public static void main(String[] args) {


        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        String mainPageTitle = driver.getTitle();
        System.out.println(mainPageTitle);

        MyFunctions.waitFunc(2);

        WebElement acceptButton = driver.findElement(By.id("accept-choices"));
        acceptButton.click();
        MyFunctions.waitFunc(2);


        String mainPageWindowHandle = driver.getWindowHandle();
        System.out.println(mainPageWindowHandle);


        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);

        MyFunctions.waitFunc(2);


        WebElement visitW3SchoolsLink = driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']"));
        visitW3SchoolsLink.click();

        // I will swithc to new tab( window)

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each: windowHandles) {

            if (!each.equals(mainPageWindowHandle)) {
                driver.switchTo().window(each);
            }

        }

        MyFunctions.waitFunc(2);

        String newPageTitle = driver.getTitle();
        System.out.println(newPageTitle);


        // I want to print titles together (both of them)


        for (String every: windowHandles) {
            driver.switchTo().window(every);
            System.out.println(driver.getTitle());
        }


       driver.switchTo().window(mainPageWindowHandle);

        // How can I make sure I am in home page again



        if (driver.getTitle().equals(mainPageTitle)) {
            System.out.println("Test Passed We are home page again");

        }

        

        driver.quit();


    }

}
