package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.AbstractPage;

public class CartPage extends AbstractPage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
    public CartPage open(WebDriver webDriver){
        if (!webDriver.getCurrentUrl().contains(URL)) webDriver.get(URL);
        return new CartPage(webDriver);
    }
    public static String URL = "http://3.122.51.38/litecart/checkout";
    By removeButton = By.xpath("//button[@name='remove_cart_item']");
    By itemList = By.xpath("//div[@class='cart wrapper']//tbody//tr");

    public CartPage removeItem(){
        webDriver.findElement(removeButton).click();
        return this;
    }

    public int itemsInCart(){
        return webDriver.findElements(itemList).size();
    }

    public CartPage removeAllItems(){
        int itemsInCart = itemsInCart();
        while (itemsInCart > 0){

            removeItem();// press remoweitem

            do {
                try{Thread.sleep(100);}
                catch(InterruptedException e){e.printStackTrace();}
            }while(itemsInCart() < itemsInCart); //wait till number of items in cart decrease

            itemsInCart = itemsInCart();
        }
        return this;
    }
}
