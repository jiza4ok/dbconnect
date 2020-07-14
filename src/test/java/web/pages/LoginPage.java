package web.pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.web.PageObj;
import web.AbstractPage;

@Slf4j
public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


   By loginInput = By.xpath("//input[@placeholder='Username']");
    By passwordInput = By.xpath("//input[@placeholder='Password']");
    @Getter
    By loginButton = By.xpath("//button[@name='login']");

    public void login(String login, String password){
        find(loginInput).sendKeys(login);
        find(passwordInput).sendKeys(password);
        find(loginButton).click();
    }
}
