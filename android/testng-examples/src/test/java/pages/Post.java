package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Post {

    protected WebDriver driver;

    private String backButton = "//*[@content-desc= 'Navigate up']";

    // Constructor
    public Post(WebDriver driver) {
        this.driver = driver;
    }


    public void tapOverTheBackButton() {
        driver.findElement(By.xpath(backButton)).click();
    }
}
