package stepDefinitions;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.InventoryPage;
import utils.TestContextSetup;

public class InventoryPageStepDefinition {
    TestContextSetup testContextSetup;
    InventoryPage inventoryPage;

    public InventoryPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.inventoryPage = testContextSetup.pageObjectManager.getInventoryPage();
    }

    @When("^User added to cart the product (.+)$")
    public void user_added_to_cart_the_product(String productName) {
        inventoryPage.addProductToCart(productName);
        testContextSetup.inventoryPageProductName = productName;

        Assert.assertEquals(inventoryPage.validateTheNumberOfProductsInCart(),1);
        inventoryPage.enterShoppingCart();
    }
}
