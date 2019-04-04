package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SignUpPage;

import java.util.List;
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

    @Then("^user sees error popup for email with message$")
    public void verifyErrorMessage(DataTable dataTable) {
        WebElement errorPopup = new WebDriverWait(this.driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error > p"))
        );

        List<String> list = dataTable.asList(String.class);
        String message = list.get(0);
        String text = errorPopup.getText();
        Assert.assertEquals(text, message);
        String userClass = SignUpPage.emailField.getAttribute("class");
        Assert.assertEquals(userClass, "error");
    }

    @When("^user clicks on Sign Up button$")
    public void clickSubmitButton() {
        SignUpPage.signupButton.click();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
