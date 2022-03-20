package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    By confirmationMessage = By.cssSelector(".complete-header");

    public WebDriver driver;

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }
}
