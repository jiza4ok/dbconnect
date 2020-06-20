package utils.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    public static synchronized WebDriver getWebDriver() {
        return getWebDriver(PropertyReader.get().readValue("browser"));
    }

    public static WebDriver getWebDriver(String browser) {
        switch (browser) {
            default:
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
                String chromeBinary = "src/main/resources/chromedriver" + (os.equals("win") ? ".exe" : "");
                System.setProperty("webdriver.chrome.driver", chromeBinary);
                WebDriver chromeWebDriver = new ChromeDriver(options);

                chromeWebDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

                chromeWebDriver.manage().window().maximize();
                return chromeWebDriver;
            case "chrome_remote_selenoid":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("81.0");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", false);

                RemoteWebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(
                            URI.create("http://localhost:4444/wd/hub").toURL(),
                            capabilities
                    );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
                driver.manage().window().maximize();
                return driver;
            case "chrome_remote_selenium":
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                RemoteWebDriver wdriver = null;
                try {
                    wdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                wdriver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
                wdriver.manage().window().maximize();
                return wdriver;
        }
    }

}