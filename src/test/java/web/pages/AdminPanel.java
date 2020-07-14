package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.web.PageObj;
import web.AbstractPage;

import java.util.List;

public class AdminPanel extends AbstractPage {

    public AdminPanel(WebDriver webDriver) {
        super(webDriver);
    }

    public AdminPanel open(){
        if (!webDriver.getCurrentUrl().contains(URL)) webDriver.get(URL);
        return this;
    }

    String URL = "http://3.122.51.38/litecart/admin/";
    By panelHeading = By.cssSelector(".panel-heading");
    By sideMenuList = By.cssSelector(".app");
    By submenuList = By.cssSelector(".doc");
    By countryList = By.xpath("//a[@href='http://3.122.51.38/litecart/admin/?app=countries&doc=countries']");
    By countryLink = By.xpath("//tbody//tr[1]//td/a");
    By catalog = By.xpath("//a[@href='http://3.122.51.38/litecart/admin/?app=catalog&doc=catalog']");
    By addNewItem = By.xpath("//a[contains(text(),'Add New Product')]");



    public boolean checkHeading(){
            return webDriver.findElements(panelHeading).size() > 0;
    }

    public List<WebElement> getSideMenu(){
        return webDriver.findElements(sideMenuList);
    }

    public boolean hasSubmenu(){
        return webDriver.findElements(submenuList).size() > 0;
    }

    public List<WebElement> getSubmenu(){
        return webDriver.findElements(submenuList);
    }

    public void openCatalog(){
       find(catalog).click();
    }

    public NewProduct addNewProduct(){
        find(addNewItem).click();
        return new NewProduct(webDriver);
    }


    public CountryPage openFirstCountry(){
        find(countryList).click();
        find(countryLink).click();
        return new CountryPage(webDriver);
    }
}
