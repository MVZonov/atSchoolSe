package hw.unit11part3.task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage {
    @FindBy(how = How.XPATH, using = "//span[.='Products']")
    WebElement headerProducts;

    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
    WebElement hamburgerField;
    @FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

}
