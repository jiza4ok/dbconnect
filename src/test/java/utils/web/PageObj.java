package utils.web;

import org.openqa.selenium.WebDriver;

public interface PageObj<T> {
    public PageObj< T > get(WebDriver webDriver);
}
