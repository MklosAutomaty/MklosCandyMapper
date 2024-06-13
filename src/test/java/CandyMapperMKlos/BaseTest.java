package CandyMapperMKlos;

import CandyMapperMKlos.ControllCore.Helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setup() throws IOException {

        driver = DriverFactory.getDriver();
        System.out.println(driver);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://candymapper.com/");

    }
    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            System.out.println("tear down");
            driver.quit();

            DriverFactory.setDriver(null);
        }
    }

}
