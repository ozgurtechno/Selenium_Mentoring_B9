package week3._1_monday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass extends BaseDriver {
    public static void main(String[] args) throws AWTException {
        driver.get("https://www.guvi.in");
        WebElement el= driver.findElement(By.xpath("//a[.='Courses'][@class='nav-link dropdown-toggle down-icon evtCourses']"));
        el.click();

        Robot robot=new Robot();
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            MyFunctions.waitFunc(1);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyPress(KeyEvent.VK_TAB);

        robot.delay(3000);

        robot.mouseMove(30,-30);

        robot.mouseWheel(30);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_CAPS_LOCK);

        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            MyFunctions.waitFunc(1);
            robot.keyRelease(KeyEvent.VK_TAB);
        }




    }


}

