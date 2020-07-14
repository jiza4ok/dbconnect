package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.web.WebHelpers;
import web.AbstractPage;

import java.util.List;

public class CountryPage extends AbstractPage {

    public CountryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CountryPage open(){
        if (!webDriver.getCurrentUrl().contains(URL)) webDriver.get(URL);
        return this;
    }
    public static String URL = "http://3.122.51.38/litecart/admin/?app=countries&doc=edit_country&country_code=";
    By externalLink = By.cssSelector("fa fa-external-link");

    public List<WebElement> findExternalLinks(){
        return webDriver.findElements(externalLink);
    }

    public boolean ifOpensInNewWindow(WebElement link){
        return isOpeningInNewTab(link);
    }
}
