package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PostDetails {

    protected WebDriver driver;

    private String commentsLabel = "//*[@text= 'Comments']";
    private String backButton = "//*[@content-desc= 'Navigate up']";

    // Constructor
    public PostDetails(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkCommentLabel() {
        boolean commentLabel = driver.findElement(By.xpath(commentsLabel)).isDisplayed();
        return commentLabel;
    }

    public void tapOverTheBackButton() {
        driver.findElement(By.xpath(backButton)).click();
    }
}
