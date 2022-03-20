package stepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.CartPage;
import utils.TestContextSetup;

public class CartPageStepDefinition {
    TestContextSetup testContextSetup;
    CartPage cartPage;

    public CartPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @When("Validated the details in Shopping cart")
    public void validated_the_details_in_shopping_cart() {
        cartPage.validateCartProductName(testContextSetup.inventoryPageProductName);
        cartPage.pressCheckoutButton();
    }
}
