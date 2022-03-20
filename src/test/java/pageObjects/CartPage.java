package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    By cartProductName = By.cssSelector(".inventory_item_name");
    By checkoutButton = By.name("checkout");

    public WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateCartProductName(String productName){
        Assert.assertEquals(driver.findElement(cartProductName).getText(), productName);
    }

    public void pressCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
