package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class MainSteps {

    public WebDriver driver;

    public MainSteps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(this.driver, MainPage.class);
    }

    @Given("^user navigates to \"([^\"]*)\"$")
    public void enterMainPage(String url) {
        this.driver.get(url);
    }

    @When("^user clicks login button$")
    public void clickLoginButton() {
        MainPage.loginButton.click();
    }

    @When("^user clicks Sign up button$")
    public void clickSignupButton() {
        MainPage.signupButton.click();
    }

    @Then("^user sees error popup$")
    public void verifyErrorMessage() {
        WebElement errorPopup = new WebDriverWait(this.driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error > p"))
        );
    }
}
