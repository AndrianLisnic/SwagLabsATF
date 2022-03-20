package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By username = By.name("user-name");
    By password = By.name("password");
    By loginButton = By.name("login-button");

    public WebDriver webDriver;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
    }

    public void insertUsernameAndPassword(){
        webDriver.findElement(username).sendKeys("standard_user");
        webDriver.findElement(password).sendKeys("secret_sauce");
    }

    public void pressLoginButton(){
        webDriver.findElement(loginButton).click();
    }

    public String getTitleLoginPage(){
        return webDriver.getTitle();
    }

}
