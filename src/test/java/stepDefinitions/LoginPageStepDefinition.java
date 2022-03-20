package stepDefinitions;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginPageStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage;

    public LoginPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @Given("User is on SwagLabs Login page")
    public void user_is_on_swag_labs_login_page() {
        Assert.assertTrue(loginPage.getTitleLoginPage().contains("Swag Labs"));
    }

    @Given("User logged in with valid credentials")
    public void user_logged_in_with_valid_credentials() {
        loginPage.insertUsernameAndPassword();
        loginPage.pressLoginButton();
    }

}
