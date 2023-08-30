package robot;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseChromeTest;
import utilities.BaseDriver;
import utilities.MyFunctions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Set;

public class FileUploadSimulator extends BaseDriver {
    @Test
    public void robotClassTest1() throws AWTException {
        driver.get("https://demo.guru99.com/test/upload/");
        MyFunctions.waitFunc(2);

        WebElement chooseFileButton = driver.findElement(By.id("uploadfile_0"));

        Actions actions = new Actions(driver);
        actions.click(chooseFileButton).perform();

        //Buradan asagisini kopyala

        File file = new File("/Users/ozgurtechno/Downloads/TestCases.xlsx");
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        Robot robot = new Robot();
        // Window change is needed since it launches a Java app and the browser looses focus

        // Get the window handles (IDs) of all open windows/tabs
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch back to the original Chrome window
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Upload")) { // Adjust the condition based on the title of your Chrome window
                break; // Switched back to the original Chrome window
            }
        }

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);//command
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        //Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        //Press Enter key to close the Goto window and Upload window


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement checkBox = driver.findElement(By.id("terms"));
        checkBox.click();

        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        submitButton.click();

        WebElement message = driver.findElement(By.id("res"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(message));

        Assert.assertTrue(message.getText().contains("successfully uploaded"));

    }

}

