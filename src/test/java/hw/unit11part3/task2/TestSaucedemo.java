package hw.unit11part3.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

public class TestSaucedemo {
    @DisplayName("Задание 2")
    @Test
    public void testSaucedemo() {
        browserInit();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.get(LoginPage.saucedemoUrl);

        //Действия на главной странице
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        Assertions.assertEquals("Swag Labs", loginPage.siteHeader.getText(), "Заголовок \"Swag Labs\" не совпадает.");
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passField.sendKeys("secret_sauce");
        loginPage.loginButton.click();

        //Действия на странице продуктов
        ProductsPage productsPage = new ProductsPage();
        PageFactory.initElements(driver, productsPage);
        Assertions.assertEquals("Products", productsPage.headerProducts.getText(), "Заголовок \"Products\" не совпадает.");
        boolean humburgerIsDisplayed = productsPage.hamburgerField.isDisplayed();
        Assertions.assertEquals(true, humburgerIsDisplayed, "Поле \"Гамбургер\" не отображается.");
        productsPage.hamburgerField.click();
        boolean logoutIsDisplayed = productsPage.logoutLink.isDisplayed();
        Assertions.assertEquals(true, logoutIsDisplayed, "Кнопка \"Logout\" не отображается.");
        productsPage.logoutLink.click();

        //Завершающие действия на главной странице
        LoginPage loginPage1 = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage1);
        Assertions.assertEquals("Swag Labs", loginPage1.siteHeader.getText(), "Заголовок \"Swag Labs\" не совпадает.");

        //Выход из драйвера
        driver.quit();
    }

    public static void browserInit() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
    }
}
