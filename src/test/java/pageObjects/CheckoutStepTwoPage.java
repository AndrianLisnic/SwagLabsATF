package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {
    By addedProductName = By.cssSelector(".inventory_item_name");
    By finishButton = By.name("finish");

    public WebDriver driver;

    public CheckoutStepTwoPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAddedProductName(){
        return driver.findElement(addedProductName).getText();
    }

    public void pressFinishButton(){
        driver.findElement(finishButton).click();
    }
}
