package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {

    protected WebDriver driver;

    // Constructor
    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method to wait for any label on the current screen when the xpath element have text
     *
     * @param label
     */
    public void waitLabelWithText(String label) {
        String baseSelector = "//*[@text=";
        String dataLabel = "'" + label + "']";
        String baseSelectorAndDataLabel = baseSelector + dataLabel;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseSelectorAndDataLabel)));
    }

    /**
     * method to wait for any label on the current screen when the xpath element have resource-id
     *
     * @param labelResourceId
     */
    public void waitLabelWithresource_id(String labelResourceId) {
        String baseSelectorId = "//*[@resource-id=";
        String dataLabelId = "'" + labelResourceId + "']";
        String baseSelectorAndDataLabelId = baseSelectorId + dataLabelId;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseSelectorAndDataLabelId)));
    }

    /**
     * method to tap over any element when it has a xpath with text
     *
     * @param label
     */
    public void tapOverAnyElementWithText(String label) {
        String baseSelector = "//*[@text=";
        String dataLabel = "'" + label + "']";
        String baseSelectorAndDataLabel = baseSelector + dataLabel;
        driver.findElement(By.xpath(baseSelectorAndDataLabel)).click();
    }

    /**
     * method to get a string from text to use this en assertions when the xpath has a text
     *
     * @param label
     * @return
     */
    public String getElementFromInputText(String label) {
        String baseSelector = "//*[@text=";
        String dataLabel = "'" + label + "']";
        String baseSelectorAndDataLabel = baseSelector + dataLabel;
        return baseSelectorAndDataLabel;
    }

    /**
     * Method to get the value text for any label
     *
     * @param label
     * @return
     */
    public String getLabelValueFromInputText(String label) {
        String baseSelector = "//*[@text=";
        String dataLabel = "'" + label + "']";
        String baseSelectorAndDataLabel = baseSelector + dataLabel;
        String dataResult = driver.findElement(By.xpath(baseSelectorAndDataLabel)).getText();
        return dataResult;
    }

    /**
     * it is for testing purposes in order to see with more time any action
     *
     * @throws InterruptedException
     */
    public void waitShortTimeToSeeAnyAction(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
