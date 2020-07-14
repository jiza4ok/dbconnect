package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.AbstractPage;

public class ProductPage extends AbstractPage {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    By addToCartButton = By.xpath("//button[@name='add_cart_product']");
    By productCounter = By.xpath("//div[@class='badge quantity']");

    public int productCounterValue(){
        String counter = webDriver.findElement(productCounter).getText();
        if(counter.length()>0){return new Integer(counter);}
        else{return 0;}
    }

    public ProductPage addToCart() {
        int numberInCart = productCounterValue();
        webDriver.findElement(addToCartButton).click();
        while(!(productCounterValue()>numberInCart)) {
            try{Thread.sleep(100);}
            catch (InterruptedException e){e.printStackTrace();}
        }
        return this;
    }


}
