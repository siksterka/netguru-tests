package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class LoginSteps {

    public WebDriver driver;

    public LoginSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(this.driver, LoginPage.class);
    }

    @When("^user enters username as \"([^\"]*)\"$")
    public void fillUsernameWithText(String username) {
        LoginPage.userField.sendKeys(username);

    }

    @When("^user enters password as \"([^\"]*)\"$")
    public void fillInPasswordWithText(String password) {
        LoginPage.passwordField.sendKeys(password);
    }

    @When("^user clicks on Submit button$")
    public void clickSubmitButton() {
        LoginPage.loginButton.click();
    }
}
