package hw.unit11part3.task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    public static final String saucedemoUrl = "https://www.saucedemo.com/";

    @FindBy(how = How.XPATH, using = "//div[.='Swag Labs']")
    WebElement siteHeader;

    @FindBy(how = How.XPATH, using = "//input[@id='user-name']")
    WebElement usernameField;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement passField;
    @FindBy(how = How.XPATH, using = "//input[@id='login-button']")
    WebElement loginButton;
}