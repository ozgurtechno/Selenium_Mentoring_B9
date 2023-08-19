package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class MyFunctions {
    public static void waitFunc(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void waitAndQuitFunc(int second){
//        try {
//            Thread.sleep(second*1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//
//        }
//        driver.quit();
//    }

    public static void takeScreenShots(WebDriver driver,String fileName ){
        // cast the driver to screenshots
        TakesScreenshot screenshotDriver= (TakesScreenshot) driver;

        // Take screenshot as a file
        File screenShotsFile=screenshotDriver.getScreenshotAs(OutputType.FILE);

        // Define destination path
        String destinationPath="src/week4/_2_tuesday/takeScreenShots/ "+fileName+".png";

        try {
            FileHandler.copy(screenShotsFile,new File(destinationPath));
            System.out.println("Screenshots saved "+destinationPath);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
