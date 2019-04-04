package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/login']")
    public static WebElement loginButton;

    @FindBy(xpath = "//a[@href='/signup']")
    public static WebElement signupButton;
}
