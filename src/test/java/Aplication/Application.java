package Aplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.web.WebHelpers;
import web.pages.*;

import java.util.List;

public class Application {

    WebDriver webDriver;
    LoginPage loginPage;
    AdminPanel adminPanel;
    CartPage cartPage;
    CountryPage countryPage;
    MainPage mainPage;
    ProductPage productPage;
    NewProduct newProduct;

    public Application(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Application login(String login, String password){
        loginPage = LoginPage.open(webDriver);
        adminPanel = loginPage.login(login, password);
        return this;
    }
    public List< WebElement > getSideMenu(){
        return adminPanel.getSideMenu();
    }
    public boolean hasSubmenu(){
        return adminPanel.hasSubmenu();
    }
    public List <WebElement> getSubmenu(){
        return adminPanel.getSubmenu();
    }

    public boolean checkHeading(){
        return adminPanel.checkHeading();
    }
    public Application openFirstCountry(){
        countryPage = adminPanel.openFirstCountry();
        return this;
    }
    public List <WebElement> getExternalLinks(){
        return countryPage.findExternalLinks();
    }

    public boolean checkOpeningInNewTab(WebElement link){
        return countryPage.isOpeningInNewTab(link);
    }

    public Application switchAndCloseTab(){
        WebHelpers.switchToLastOpenedTab(webDriver);
        webDriver.close();
        WebHelpers.switchToLastOpenedTab(webDriver);
        return this;
    }

    public Application openMainPage(){
        mainPage = MainPage.open(webDriver);
        return this;
    }

    public Application openFirstProductPage(){
        productPage = mainPage.openFirstProductPage();
        return this;
    }

    public Application addItemToCartAndReturnToMain(){
        productPage.addToCart();
        WebHelpers.goBack(webDriver);
        return this;
    }

    public Application openCart(){
        cartPage = mainPage.openCart();
        return this;
    }

    public Application removeAllFromCart(){
        cartPage.removeAllItems();
        return this;
    }
    public boolean isCartEmpty(){
        return cartPage.itemsInCart() == 0;

    }

    public Application openCatalog(){
        adminPanel.openCatalog();
        return this;
    }

    public Application addNewProduct(){
        newProduct = adminPanel.addNewProduct();
        return this;
    }

    public Application fillAndSaveProduct(){
        newProduct.fillGeneralValues();
        newProduct.fillInformationValues();
        newProduct.fillPricesValues();
        newProduct.saveProduct();
        return this;
    }
}
