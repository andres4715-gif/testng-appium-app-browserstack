package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Todo_s {

    protected WebDriver driver;

    private String addButton = "//*[@resource-id='es.jaimesuarez.rindustest:id/fab_add_item']";
    private String dataFillInformation = "//*[@text='Type your todo here…']";
    private String createButton = "//*[@text='CREATE']";
    private String newRecordAdded = "(//*[@resource-id='es.jaimesuarez.rindustest:id/tv_todo_title'])[1]";
    private String newTaskAdded = "(//*[@resource-id='es.jaimesuarez.rindustest:id/tv_todo_title'])[1]";
    private String selectNewTask = "(//*[@class='android.widget.CheckBox'])[1]";
    private String unSelectNewTask = "(//*[@class='android.widget.CheckBox'])[2]";
    private String task = "//*[@resource-id= 'es.jaimesuarez.rindustest:id/tv_todo_title']";
    private String backButton = "//*[@content-desc= 'Navigate up']";

    // Constructor
    public Todo_s(WebDriver driver) {
        this.driver = driver;
    }

    public void tapOverTheAddButton() {
        driver.findElement(By.xpath(addButton)).click();
    }

    public void clearDataFillInformation() {
        driver.findElement(By.xpath(dataFillInformation)).clear();
    }

    public void inputNewRecord(String newRecord) {
        driver.findElement(By.xpath(dataFillInformation)).sendKeys(newRecord);
    }

    public void tapOverCreateButton() {
        driver.findElement(By.xpath(createButton)).click();
    }

    public String getNewDataAdded() {
        String gettingData = driver.findElement(By.xpath(newRecordAdded)).getText();
        return gettingData;
    }

    public boolean checkNewTaskAddedIsSelected() {
        boolean newTaskSelected = driver.findElement(By.xpath(newTaskAdded)).isSelected();
        return newTaskSelected;
    }

    public void tapsToMarkNewTaskAdded() {
        driver.findElement(By.xpath(selectNewTask)).click();
    }

    public void tapsToUnselectTaskAdded() {
        driver.findElement(By.xpath(unSelectNewTask)).click();
    }

    public int getCoordenatesIn_x(int dataToBeRemoved) {
        List<MobileElement> list = driver.findElements(By.xpath(task));
        int coordenatesIn_x = list.get(dataToBeRemoved - 1).getLocation().getX();
        return coordenatesIn_x;
    }

    public int getCoordenatesIn_y(int dataToBeRemoved) {
        List<MobileElement> list = driver.findElements(By.xpath(task));
        int coordenatesIn_y = list.get(dataToBeRemoved - 1).getLocation().getY();
        return coordenatesIn_y;
    }

    public boolean checkIfDeleteTaskMessage() {
        boolean deleteTaskDisplayed = driver.findElement(By.xpath(newTaskAdded)).isDisplayed();
        return deleteTaskDisplayed;
    }

    public void tapOverTheBackButton() {
        driver.findElement(By.xpath(backButton)).click();
    }
}
