package select;

import org.testng.annotations.Test;
import utilities.BaseDriver;

public class SelectDemo extends BaseDriver {

    @Test
    public void selectTest(){

        driver.get("https://sqengineer.com/practice-sites/basic-web-elements/");
    }
}
