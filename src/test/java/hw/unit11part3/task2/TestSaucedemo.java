package hw.unit11part3.task2;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

public class TestSaucedemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.get(LoginPage.saucedemoUrl);

        //Действия на главной странице
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(driver, loginPage);
        Assert.isTrue(loginPage.siteHeader.getText().contains("Swag Labs"), "Заголовок \"Swag Labs\" не совпадает.");
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passField.sendKeys("secret_sauce");
        loginPage.loginButton.click();

        //Действия на странице продуктов
        ProductsPage productsPage = new ProductsPage();
        PageFactory.initElements(driver, productsPage);
        Assert.isTrue(productsPage.headerProducts.getText().contains("Products"), "Заголовок \"Products\" не совпадает.");
        boolean humburgerIsDisplayed = productsPage.hamburgerField.isDisplayed();
        Assert.isTrue(humburgerIsDisplayed, "Поле \"Гамбургер\" не отображается.");
        productsPage.hamburgerField.click();
        boolean logoutIsDisplayed = productsPage.logoutLink.isDisplayed();
        Assert.isTrue(logoutIsDisplayed, "Кнопка \"Logout\" не отображается.");
        productsPage.logoutLink.click();

        //Завершающие действия на главной странице
        LoginPage loginPage1 = new LoginPage();
        PageFactory.initElements(driver, loginPage1);
        Assert.isTrue(loginPage1.siteHeader.getText().contains("Swag Labs"), "Заголовок \"Swag Labs\" не совпадает.");

        //Выход из драйвера
        driver.quit();
    }
}
