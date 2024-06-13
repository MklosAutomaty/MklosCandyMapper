package CandyMapperMKlos.Pages;

import CandyMapperMKlos.ControllCore.Helper.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends SeleniumHelper {
    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    @FindBy (id = "popup-widget111379-close-icon")
    protected WebElement popUpMainPageClose ;

    @FindBy (id = "popup-widget111379-cta")
    protected WebElement popUpMainPageFMC ;

    protected static final Logger logger = LogManager.getLogger();

//    protected WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public MainPage(WebDriver driver) {
        logger.info("Initializing driver.");
        PageFactory.initElements(driver, this);
        logger.info("Driver initialized");
        this.driver = driver;
    }

//    public void closePopUp (){
//        clickElement(driver, popUpMainPageClose);
//        Assert.assertTrue(popUpMainPageClose.isDisplayed());
//        logger.info("closePopUp PASS");
//    }
//    public void closePopUpFMC (){
//        clickElement(driver, popUpMainPageFMC);
//        Assert.assertTrue(popUpMainPageFMC.isDisplayed());
//        logger.info("closePopUp by 'FIND MY CANDY' button, PASS");
//    }


}
