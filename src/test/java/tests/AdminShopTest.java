package tests;

import Aplication.Application;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserEventListener;
import utils.TestNgListener;
import utils.web.WebDriverManager;

import java.util.List;

@Slf4j
@Listeners({TestNgListener.class})
public class AdminShopTest {

    @Factory (dataProvider="dataProviderMethod")
    public AdminShopTest(String localization, String os, String os_version, String browser, String version){
        this.webDriver=WebDriverManager.getWebDriver(localization, os, os_version, browser, version);
        this.eventFiringDriver = new EventFiringWebDriver(webDriver);
        this.eventListener = new BrowserEventListener();
        this.eventFiringDriver.register(eventListener);
        this.app = new Application(webDriver);
    }

    @DataProvider
    public static Object[][] dataProviderMethod() {
        return new Object[][] { {"local", " ", " ", "chrome", " "} };

    }
    public WebDriver webDriver;
    public Application app;
    public EventFiringWebDriver eventFiringDriver;
    public BrowserEventListener eventListener;

    @BeforeClass
    public void setup(){
        app.login("admin", "gl_admin");
    }

    @Test
    public void checkHeadings(){
        for (int i = 0; i < app.getSideMenu().size(); i++){
            app.getSideMenu().get(i).click();
            if(app.hasSubmenu()){
                for(int j = 0; j<app.getSubmenu().size(); j++){
                    app.getSubmenu().get(j).click();
                    Assert.assertTrue(app.checkHeading());
                }
            }
            else Assert.assertTrue(app.checkHeading());
        }
    }

    @Test
    public void checkExternalLinks(){
        List< WebElement > externalLinks = app.openFirstCountry().getExternalLinks();
        for (int i=0; i<externalLinks.size(); i++){
            Assert.assertTrue(app.checkOpeningInNewTab(externalLinks.get(i)), "link opens in new window");
            app.switchAndCloseTab();
        }
    }

    @Test
    public void createNewItem(){
        app.openCatalog()
        .addNewProduct()
        .fillAndSaveProduct();
    }

    @AfterClass
    public void end(){
        webDriver.quit();
    }
}
