package CandyMapperMKlos.ControllCore.Helper;

import CandyMapperMKlos.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumHelper extends BaseTest {

    private static WebDriverWait wait;

    static void HelperMethods(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Contract("_ -> new")
    private @NotNull WebDriverWait HelperMethod(WebDriver driver) {
        return  new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --------------- Dodatkowe metody pomocnicze ----------------------- //
    protected void waitForElementVisibleShort(WebDriver driver, WebElement elementToWait) {
        HelperMethod(driver).until(ExpectedConditions.visibilityOf(elementToWait));
//        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }
    protected void waitForElementVisible(WebDriver driver, WebElement elementToWait) {
//        HelperMethod(driver).until(ExpectedConditions.visibilityOf(elementToWait));
        HelperMethods(driver);
        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }
    protected void clickElement(WebDriver driver, WebElement elementToClick) {
        HelperMethods(driver);
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();

    }
    public void setInputField(WebDriver driver, WebElement element, String text) {

        waitForElementVisible(driver, element);
        element.clear();
        element.sendKeys(text);
    }
    public  void wairForElementToExist(WebDriver driver, By locator) {
        HelperMethods(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public  void wairForElementToVisible(WebDriver driver, WebElement element) {
        HelperMethods(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected  void waitForNotEmptyList(WebDriver driver, By locator) {
        HelperMethods(driver);
        wait.until(browser -> browser.findElements(locator).size() > 0);
    }

    protected  void waitForNotEmptyList(WebDriver driver, List<WebElement> webElementsList) {
        HelperMethods(driver);
        wait.until(browser -> webElementsList.size() > 0);
    }

    public static Media getScreenshot(WebDriver driver) throws IOException {
        String path = takeScreenShot(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    private static String takeScreenShot(WebDriver driver) throws IOException {
        int randomNumber = (int) (Math.random() * 1000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/TestScreebShot" + randomNumber + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

    protected List<String> informationList(WebDriver driver, List<WebElement> errorsList) {
        waitForNotEmptyList(driver, errorsList);
        List<String> errors = errorsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return errors;
    }

}
