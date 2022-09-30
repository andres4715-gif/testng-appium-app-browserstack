package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Users {

    protected WebDriver driver;

    private String usersLabel = "//*[@text='Users']";

    // Constructor
    public Users(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkUserLabel() {
        boolean userLabel = driver.findElement(By.xpath(usersLabel)).isDisplayed();
        return userLabel;
    }
}
