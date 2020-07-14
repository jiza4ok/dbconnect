package tests;

import Aplication.Application;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import utils.BrowserEventListener;
import utils.TestNgListener;
import utils.web.WebDriverManager;


@Listeners({TestNgListener.class})
public abstract class AbstractWebTest {

    public static WebDriver webDriver;
    public static Application app;

    @BeforeClass
    public void setup1() {
        webDriver = WebDriverManager.getWebDriver("chrome");
        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(webDriver);
        BrowserEventListener eventListener = new BrowserEventListener();
        eventFiringDriver.register(eventListener);
        app = new Application(webDriver);
    }
    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }

}
