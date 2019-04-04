package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends MainPage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    public static WebElement nameField;

    @FindBy(id = "email")
    public static WebElement emailField;

    @FindBy(id = "password")
    public static WebElement passwordField;

    @FindBy(id = "signup")
    public static WebElement signupButton;
}
