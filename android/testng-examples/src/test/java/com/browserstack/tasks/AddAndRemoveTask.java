package com.browserstack.tasks;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Todo_s;
import pages.UserDetails;
import pages.Users;
import utility.TouchActions;
import utility.Utils;

public class AddAndRemoveTask extends BrowserStackTestNGTest {

    String userNameToSelectOfTheList = "Ervin Howell";
    String resourceId = "es.jaimesuarez.rindustest:id/fab_add_item";
    String labelToAddNewTask = "CREATE";
    String newDataRecord = "doctor appointment";

    int Xcoordinates;
    int Ycoordinates;

    @Test
    public void navigateThroughTheAppAddingNewTaskAndDeleteIt() throws Exception {
        Utils utils = new Utils(driver);
        UserDetails userDetails = new UserDetails(driver);
        Todo_s todos = new Todo_s(driver);
        Users users = new Users(driver);

        utils.waitLabelWithText("Users");
        utils.waitLabelWithText("Leanne Graham");
        utils.tapOverAnyElementWithText(userNameToSelectOfTheList);

        utils.waitLabelWithText(userNameToSelectOfTheList);
        Assert.assertTrue(driver.findElement(By.xpath(utils.getElementFromInputText(userNameToSelectOfTheList))).isDisplayed());
        userDetails.tappingToChooseAnyOption();
        userDetails.tapOverSeeMore();
        utils.waitLabelWithresource_id(resourceId);

        todos.tapOverTheAddButton();
        utils.waitLabelWithText(labelToAddNewTask);
        Assert.assertTrue(driver.findElement(By.xpath(utils.getElementFromInputText(labelToAddNewTask))).isEnabled());
        todos.clearDataFillInformation();
        todos.inputNewRecord(newDataRecord);
        todos.tapOverCreateButton();
        String data = todos.getNewDataAdded();
        Assert.assertTrue(data.equals(newDataRecord));
        boolean checkCheck = todos.checkNewTaskAddedIsSelected();
        Assert.assertFalse(checkCheck);
        todos.tapsToMarkNewTaskAdded();

        int elementToBeRemoved = 1;

        TouchActions touchActions = new TouchActions(driver);
        Xcoordinates = todos.getCoordenatesIn_x(elementToBeRemoved);
        Ycoordinates = todos.getCoordenatesIn_y(elementToBeRemoved);
        touchActions.swipeAction(Xcoordinates, Ycoordinates, "Right");
        utils.waitLabelWithText("Todo deleted successfully");
        boolean deleteMessage = todos.checkIfDeleteTaskMessage();
        Assert.assertTrue(deleteMessage);

        todos.tapOverTheBackButton();
        userDetails.tapOverTheBackButton();
        utils.waitLabelWithText("Users");
        boolean checkUserLabel = users.checkUserLabel();
        Assert.assertTrue(checkUserLabel);
        utils.waitShortTimeToSeeAnyAction(2);
    }
}
