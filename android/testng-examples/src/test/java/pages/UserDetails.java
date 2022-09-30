package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserDetails {

    protected WebDriver driver;

    private String todosElement = "(//*[@class='android.widget.CheckBox'])[1]";
    private String todoCta = "//*[contains(@text, 'Todo')]";
    private String backButton = "//*[@content-desc= 'Navigate up']";

    // Constructor
    public UserDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void tappingToChooseAnyOption() {
        driver.findElement(By.xpath(todosElement)).click();
    }

    public void tapOverSeeMore() {
        driver.findElement(By.xpath(todoCta)).click();
    }

    public void tapOverTheBackButton() {
        driver.findElement(By.xpath(backButton)).click();
    }
}
