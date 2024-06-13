package CandyMapperMKlos.Pages;

import CandyMapperMKlos.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBarPage extends BaseTest {
    @FindBy(xpath = "//a[text()='Home' and @data-ux='NavLinkActive']")
    private WebElement home ;
    @FindBy(id = "")
    private WebElement joinUs;
    @FindBy(id = "")
    private WebElement halloweenParty;
    @FindBy(id = "2")
    private WebElement more;
    @FindBy(id = "6")
    private WebElement memebrShipIcon;

    private static final Logger logger = LogManager.getLogger();

//    private WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public TopBarPage(WebDriver driver) {
        logger.info("Initializing driver.");
        PageFactory.initElements(driver, this);
        logger.info("Driver initialized");
        this.driver = driver;
    }
}
