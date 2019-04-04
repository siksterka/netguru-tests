package steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignUpSteps {

    public WebDriver driver;

    public SignUpSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(this.driver, SignUpPage.class);
    }

    @When("^user fills in name as \"([^\"]*)\"$")
    public void fillUsernameWithText(String username) {
        SignUpPage.nameField.sendKeys(username);
    }

    @When("^user fills in email as \"([^\"]*)\"$")
    public void fillEmailWithText(String email) {
        SignUpPage.emailField.sendKeys(email);
    }

    @When("^user fills in password as \"([^\"]*)\"$")
    public void fillInPasswordWithText(String password) {
        SignUpPage.passwordField.sendKeys(password);
    }

    @When("^user clicks on Sign Up button$")
    public void clickSubmitButton() {
        SignUpPage.signupButton.click();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
