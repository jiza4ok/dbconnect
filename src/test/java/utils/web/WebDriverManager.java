package utils.web;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverManager {

    public static WebDriver getWebDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            default:
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
                String chromeBinary = "src/main/resources/chromedriver" + (os.equals("win") ? ".exe" : "");
                System.setProperty("webdriver.chrome.driver", chromeBinary);
                driver = new ChromeDriver(options);
                return driver;
            }
        }
    }
    public static WebDriver getWebDriver(String localization, String os, String os_version, String browser, String version) {
        switch (localization) {
            default:
            case "local": {
                return getWebDriver(browser);
            }
            case "browserstack": {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("os", os);
                caps.setCapability("os_version", os_version);
                caps.setCapability("browser", browser);
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
                RemoteWebDriver bsDriver = null;
                try {
                    bsDriver = new RemoteWebDriver(new URL("https://USERNAME:ACCESS_KEY@hub-cloud.browserstack.com/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return bsDriver;
            }
            case "grid": {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setPlatform(Platform.valueOf(os));
                caps.setBrowserName(browser);
                caps.setVersion(version);
                RemoteWebDriver gDriver = null;
                try {
                    gDriver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return gDriver;
            }
            case "selenoid": {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                capabilities.setVersion(version);
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", false);

                RemoteWebDriver sDriver = null;
                try {
                    sDriver = new RemoteWebDriver(new URL("https://localhost:4444/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return sDriver;
            }
        }
    }

}