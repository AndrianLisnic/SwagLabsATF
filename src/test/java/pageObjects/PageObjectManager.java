package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;
    public WebDriver webDriver;

    public PageObjectManager(WebDriver driver){
        this.webDriver = driver;
    }

    public LoginPage getLoginPage(){
        loginPage = new LoginPage(webDriver);
        return loginPage;
    }

    public InventoryPage getInventoryPage(){
        inventoryPage = new InventoryPage(webDriver);
        return inventoryPage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(webDriver);
        return cartPage;
    }

    public CheckoutStepOnePage getCheckoutStepOnePage(){
        checkoutStepOnePage = new CheckoutStepOnePage(webDriver);
        return checkoutStepOnePage;
    }

    public CheckoutStepTwoPage getCheckoutStepTwoPage(){
        checkoutStepTwoPage = new CheckoutStepTwoPage(webDriver);
        return checkoutStepTwoPage;
    }

    public CheckoutCompletePage getCheckoutCompletePage(){
        checkoutCompletePage = new CheckoutCompletePage(webDriver);
        return checkoutCompletePage;
    }
}
