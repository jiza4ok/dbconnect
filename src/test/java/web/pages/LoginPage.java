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

    public static LoginPage open(WebDriver webDriver){
        if (!webDriver.getCurrentUrl().contains(URL)) webDriver.get(URL);
        return new LoginPage(webDriver);
    }
    final static String URL = "http://3.122.51.38/litecart/admin/login.php";
    By loginInput = By.xpath("//input[@placeholder='Username']");
    By passwordInput = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[@name='login']");



    public AdminPanel login(String login, String password){
        webDriver.findElement(loginInput).sendKeys(login);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(loginButton).click();
        return new AdminPanel(webDriver);
    }
}
