package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InventoryPage {
    By cartBadge = By.cssSelector(".shopping_cart_badge");
    By cartIcon = By.cssSelector(".shopping_cart_link");
    By productsNamesOnThePage = By.cssSelector(".inventory_item_name");

    public WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void addProductToCart(String productName){
        List<WebElement> listOfProductsOnThePage = driver.findElements(productsNamesOnThePage);
        List<String> listOfProductsNamesOnThePage = new ArrayList<>();

        for (WebElement element : listOfProductsOnThePage){
            listOfProductsNamesOnThePage.add(element.getText());
        }

        Assert.assertTrue(listOfProductsNamesOnThePage.contains(productName));

        String buttonName = String.format("add-to-cart-%s", productName.toLowerCase(Locale.ROOT).replace(" ","-"));
        driver.findElement(By.name(buttonName)).click();
    }

    public int validateTheNumberOfProductsInCart(){
        String numberOfProducts = driver.findElement(cartBadge).getText();
         return Integer.parseInt(numberOfProducts);
    }

    public void enterShoppingCart(){
        driver.findElement(cartIcon).click();
    }
}
