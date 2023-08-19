package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class BaseDriver {
    public static WebDriver driver;
    static {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("incognito");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void BekleKapat()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void Bekle(int saniye)
    {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
