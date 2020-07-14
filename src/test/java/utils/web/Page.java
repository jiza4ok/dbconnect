package utils.web;

import org.openqa.selenium.WebDriver;
import web.AbstractPage;

public class Page <T> {
    public T get(WebDriver webDriver){

        return (T) new AbstractPage(webDriver);
    }
}
