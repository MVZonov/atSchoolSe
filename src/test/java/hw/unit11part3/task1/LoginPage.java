package hw.unit11part3.task1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    public static final String saucedemoUrl = "https://www.saucedemo.com/";

    @FindBy(how = How.XPATH, using = "//div[.='Swag Labs']")
    WebElement siteHeader;

}