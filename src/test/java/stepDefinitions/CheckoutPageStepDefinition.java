package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutStepOnePage;
import pageObjects.CheckoutStepTwoPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutCompletePage checkoutCompletePage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.checkoutStepOnePage = testContextSetup.pageObjectManager.getCheckoutStepOnePage();
        this.checkoutStepTwoPage = testContextSetup.pageObjectManager.getCheckoutStepTwoPage();
        this.checkoutCompletePage = testContextSetup.pageObjectManager.getCheckoutCompletePage();
    }

    @When("Entered the delivery information and confirmed the order")
    public void entered_the_delivery_information_and_confirmed_the_order() {
        checkoutStepOnePage.completeCheckoutInformation();
        checkoutStepOnePage.pressContinueButton();

        Assert.assertEquals(checkoutStepTwoPage.getAddedProductName(),testContextSetup.inventoryPageProductName);

        checkoutStepTwoPage.pressFinishButton();
    }

    @Then("The Thank You confirmation message is displayed")
    public void the_thank_you_confirmation_message_is_displayed() {
        Assert.assertEquals(checkoutCompletePage.getConfirmationMessage(),"THANK YOU FOR YOUR ORDER");
    }

}
