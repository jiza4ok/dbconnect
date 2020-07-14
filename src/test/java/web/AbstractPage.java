package web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.web.WebHelpers;

import java.util.List;

@Slf4j
public class AbstractPage {

    public final WebDriver webDriver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    public WebElement find(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public List<WebElement>findList(By by){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return webDriver.findElements(by);
    }

    public String getPageTitle(){
        return webDriver.getTitle();
    }

    public boolean isOpeningInNewTab(WebElement element){
        int windowsCountBefore = WebHelpers.getWindowsList(webDriver).size();
        element.click();
        int windowsCountAfter = WebHelpers.getWindowsList(webDriver).size();
        return windowsCountAfter == windowsCountBefore+1;
    }
}

