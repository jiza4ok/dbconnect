package tests;

import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;
import org.testng.Assert;

@Slf4j
public class ShopTest extends AbstractWebTest {

    @Test
    public void addItemsAndCleanCart(){
        app.openMainPage()
                .openFirstProductPage()
                .addItemToCartAndReturnToMain()
                    .openFirstProductPage()
                    .addItemToCartAndReturnToMain()
                        .openFirstProductPage()
                        .addItemToCartAndReturnToMain()
                .openCart()
                .removeAllFromCart();
        Assert.assertTrue(app.isCartEmpty());
    }
}
