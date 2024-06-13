package CandyMapperMKlos.Steps;

import CandyMapperMKlos.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPageSteps extends MainPage {
    public MainPageSteps(WebDriver driver) {
        super(driver);
    }
    public void closePopUp (){
        clickElement(driver, popUpMainPageClose);
        Assert.assertTrue(popUpMainPageClose.isDisplayed());
        logger.info("closePopUp PASS");
    }
    public void closePopUpFMC (){
        clickElement(driver, popUpMainPageFMC);
        Assert.assertTrue(popUpMainPageFMC.isDisplayed());
        logger.info("closePopUp by 'FIND MY CANDY' button, PASS");
    }
}
//*[@id ='nav-111270' and text() = 'Home']//li