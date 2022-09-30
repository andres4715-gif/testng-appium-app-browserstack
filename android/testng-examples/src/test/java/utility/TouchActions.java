package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class TouchActions {

    protected WebDriver driver;

    // Constructor
    public TouchActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method to scroll up on the screen based on coordinates
     */
    public void scrollUp() {
        Dimension dimention = driver.manage().window().getSize();
        int start_x = (int) (dimention.width * 0.5);
        int start_y = (int) (dimention.height * 0.8);

        int end_x = (int) (dimention.width * 0.5);
        int end_y = (int) (dimention.height * 0.2);

        TouchAction touch = new TouchAction((PerformsTouchActions) driver);
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

    /**
     * method to scroll down on the screen based on coordinates
     */
    public void scrollDown() {
        Dimension dimention = driver.manage().window().getSize();
        int start_x = (int) (dimention.width * 0.5);
        int start_y = (int) (dimention.height * 0.2);

        int end_x = (int) (dimention.width * 0.5);
        int end_y = (int) (dimention.height * 0.8);

        TouchAction touch = new TouchAction((PerformsTouchActions) driver);
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

    /**
     * method to left and right swipe on the screen based on coordinates and direction could be Left or Right
     *
     * @param Xcoordinate
     * @param Ycoordinate
     * @param direction
     */
    public void swipeAction(int Xcoordinate, int Ycoordinate, String direction) {
        //get device width and height
        Dimension dimension = driver.manage().window().getSize();
        int deviceHeight = dimension.getHeight();
        int deviceWidth = dimension.getWidth();
        System.out.println("Height x Width of device is: " + deviceHeight + " x " + deviceWidth);

        switch (direction) {
            case "Left":
                System.out.println("Swipe Right to Left");
                //define starting and ending X and Y coordinates
                int startX = deviceWidth - Xcoordinate;
                int startY = Ycoordinate; // (int) (height * 0.2);
                int endX = Xcoordinate;
                int endY = Ycoordinate;
                //perform swipe from right to left
                new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
                break;

            case "Right":
                System.out.println("Swipe Left to Right");
                //define starting X and Y coordinates
                startX = Xcoordinate;
                startY = Ycoordinate;
                endX = deviceWidth - Xcoordinate;
                endY = Ycoordinate;
                //perform swipe from left to right
                new TouchAction((AppiumDriver) driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
                break;
        }
    }
}
