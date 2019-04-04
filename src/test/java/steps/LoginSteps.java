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
import pages.LoginPage;

import java.util.List;

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

    @Then("^user sees error popup for username with message$")
    public void verifyErrorMessage(DataTable dataTable) {
        WebElement errorPopup = new WebDriverWait(this.driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error > p"))
        );

        List<String> list = dataTable.asList(String.class);
        String message = list.get(0);
        String text = errorPopup.getText();
        Assert.assertEquals(text, message);
        String userClass = LoginPage.userField.getAttribute("class");
        Assert.assertEquals(userClass, "error");
    }

    @When("^user clicks on Submit button$")
    public void clickSubmitButton() {
        LoginPage.loginButton.click();
    }
}
