package hw.unit11part3.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public static final String herokuappUrl = "https://the-internet.herokuapp.com/dynamic_loading/1";

    @FindBy(how = How.XPATH, using = "//h3[.='Dynamically Loaded Page Elements']")
    WebElement header;
    @FindBy(how = How.XPATH, using = "//h4[.='Hello World!']")
    WebElement helloWorldField;

    @FindBy(how = How.XPATH, using = "//button[.='Start']")
    WebElement startButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
