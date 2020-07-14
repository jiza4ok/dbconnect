package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import web.AbstractPage;

import java.io.File;

public class NewProduct extends AbstractPage {
    public NewProduct(WebDriver webDriver) {
        super(webDriver);
    }
    By general = By.xpath("//a[contains(text(),'General')]");
    By name = By.xpath("//input[@name='name[en]']");
    By code = By.xpath("//input[@name='code']");
    By ducksCheckBox = By.xpath("//div[@id='categories']//input[@data-name='Rubber Ducks']");
    By sku = By.xpath("//div[@class='input-group']//input[@name='sku']");
    By mpn = By.xpath("//input[@name='mpn']");
    By gtin = By.xpath("//input[@name='gtin']");
    By taric = By.xpath("//input[@name='taric']");
    By dateFrom = By.xpath("//input[@name='date_valid_from']");
    By dateTo = By.xpath("//input[@name='date_valid_to']");
    By manufacturer = By.xpath("//select[@name='manufacturer_id']");
    By image = By.xpath("//input[@type='file']");

    By information = By.xpath("//a[contains(text(),'Information')]");
    By shortDescription = By.xpath("//input[@name='short_description[en]']");
    By description = By.xpath("//textarea[@name='description[en]']");
    By techData = By.xpath("//textarea[@name='technical_data[en]']");
    By metaData = By.xpath("//input[@name='meta_description[en]']");

    By prices= By.xpath("//a[contains(text(),'Prices')]");
    By purchase = By.xpath("//input[@name='purchase_price']");
    By priceUSD= By.xpath("//input[@name='gross_prices[USD]']");
    By currency = By.xpath("//select[@name='purchase_price_currency_code']");

    By save = By.xpath("//button[@name='save']");

    public void fillGeneralValues(){
        find(general).click();
        find(name).sendKeys("Strange Duck");
        webDriver.findElement(code).sendKeys("12334567");
        webDriver.findElement(ducksCheckBox).click();
        webDriver.findElement(sku).sendKeys("123");
        webDriver.findElement(gtin).sendKeys("123");
        webDriver.findElement(taric).sendKeys("123");
        webDriver.findElement(dateFrom).sendKeys("10052020");
        webDriver.findElement(dateTo).sendKeys("10072020");
        Select mfcr = new Select(webDriver.findElement(manufacturer));
        mfcr.selectByIndex(0);
        WebElement imageField = webDriver.findElement(image);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("strangeDuck.jpg").getFile());
        imageField.sendKeys(file.getAbsolutePath());
    }
    public void fillInformationValues(){
        find(information).click();
        find(shortDescription).sendKeys("Strange Duck");
        webDriver.findElement(description).sendKeys("Nice Strange Duck");
        webDriver.findElement(techData).sendKeys("from rubber");
        webDriver.findElement(metaData).sendKeys("rubber, duck, toy");
    }
    public void fillPricesValues(){
        find(prices).click();
        find(purchase).sendKeys("120");
        Select currencySelect = new Select(webDriver.findElement(currency));
        currencySelect.selectByIndex(0);
        webDriver.findElement(priceUSD).sendKeys("120");
    }
    public void saveProduct(){
        webDriver.findElement(save).click();
    }
}
