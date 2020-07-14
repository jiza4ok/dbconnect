package utils.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public abstract class AbstractWebDriver {
    public static WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public void openDriver() {
        webDriver = WebDriverManager.getWebDriver("chrome");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        webDriver.quit();
    }

}