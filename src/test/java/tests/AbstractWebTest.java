package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.BrowserEventListener;
import utils.TestNgListener;
import utils.web.WebDriverManager;


@Listeners(TestNgListener.class)
public abstract class AbstractWebTest {
    public static WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public void openDriver() {
        webDriver = WebDriverManager.getWebDriver("chrome");
        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(webDriver);
        BrowserEventListener eventListener = new BrowserEventListener();
        eventFiringDriver.register(eventListener);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }

}
