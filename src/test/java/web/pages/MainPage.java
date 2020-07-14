package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.AbstractPage;

import java.util.List;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public static MainPage open(WebDriver webDriver){
        if (!webDriver.getCurrentUrl().contains(URL)) webDriver.get(URL);
        return new MainPage(webDriver);
    }
    public static String URL = "http://3.122.51.38/litecart/";
    By products = By.xpath("//section//article");
    By cartButton = By.xpath("//div[@id='cart']");


    public List< WebElement > findProducts() {
       return webDriver.findElements(products);
    }

    public ProductPage openFirstProductPage(){
        findProducts().get(0).click();
        return new ProductPage(webDriver);
    }

    public CartPage openCart(){
        webDriver.findElement(cartButton).click();
        return new CartPage(webDriver);
    }
}
