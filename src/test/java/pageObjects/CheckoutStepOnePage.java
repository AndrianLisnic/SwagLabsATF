package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CheckoutStepOnePage {
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By postalCode = By.name("postalCode");
    By continueButton = By.xpath("//input[@type='submit']");

    public WebDriver driver;

    public CheckoutStepOnePage(WebDriver driver){
        this.driver = driver;
    }

    public void completeCheckoutInformation(){
        List<List<String>> csvCheckoutDetails = GenericUtils.csvToListOfStringsConverter();
        int numberOfRecordsInCsv = csvCheckoutDetails.size();
        int usedRecordNumber = ThreadLocalRandom.current().nextInt(0, numberOfRecordsInCsv);

        driver.findElement(firstName).sendKeys(csvCheckoutDetails.get(usedRecordNumber).get(0));
        driver.findElement(lastName).sendKeys(csvCheckoutDetails.get(usedRecordNumber).get(1));
        driver.findElement(postalCode).sendKeys(csvCheckoutDetails.get(usedRecordNumber).get(2));
    }

    public void pressContinueButton(){
        driver.findElement(continueButton).click();
    }
}
