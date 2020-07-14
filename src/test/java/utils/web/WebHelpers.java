package utils.web;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class WebHelpers {

    public static void switchWindowTab(WebDriver driver, int windowInQueue) {
        List<String> listWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listWindows.get(windowInQueue));
    }

    public static List<String> getWindowsList(WebDriver driver){
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToLastOpenedTab(WebDriver driver) {
        ArrayList<String> allTab = new ArrayList<>(driver.getWindowHandles());
        int lastTab = (allTab.size()) - 1;
        driver.switchTo().window(allTab.get(lastTab));
    }
    public static void goBack(WebDriver driver){
        driver.navigate().back();
    }

}
