package week1.Day_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyFunctions;

public class XpathPractice  extends BaseDriver {

    /*
    1) Go to the amazon webpage--> www.amazon.com
    2) Get the title of the page
    3) Test 1: Verify that the title is "Amazon.com. Spend less. Smile more."
    4) Locate the Sing In button with CSS selector
    5) Get Text of the sing in button
    6) Click to the Sing In Button a
    7) Get the title of the page
    8) Test 2 : Verify that the title is "Amazon Sign-In"
    9) Navigate back to the previous page
    10) Test 3: Get the title verify that you are in home page again

     */


    public static void main(String[] args) {


        driver.get("https://www.amazon.com");
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Amazon.com. Spend less. Smile more.";

       // System.out.println(actualTitle1);

        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
        }

        WebElement signInButton = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
        String textOfsingInButton = signInButton.getText();

        System.out.println(textOfsingInButton);

        MyFunctions.waitFunc(3);

        signInButton.click();

        String actualTitle2 = driver.getTitle();  // Amazon Sign-In
        System.out.println(actualTitle2);

        // contains (String method)

        // Verify that title "contains" Sign

        MyFunctions.waitFunc(2);


        if (actualTitle2.contains("Sign")) {
            System.out.println("Test 2 passed, I am ins Sign in page");
        } else {
            System.out.println("Test 2 failed");
        }

        MyFunctions.waitFunc(2);
        driver.navigate().back();

        String actualTitle3 = driver.getTitle();

       if (actualTitle3.contains("Amazon.com")) {
           System.out.println("Test 3 passed, I am in the home page");
       } else {
           System.out.println("Test failed");
       }













    }





}
