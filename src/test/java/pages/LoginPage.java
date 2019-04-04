package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user")
    public static WebElement userField;

    @FindBy(id = "password")
    public static WebElement passwordField;

    @FindBy(id = "login")
    public static WebElement loginButton;
}
