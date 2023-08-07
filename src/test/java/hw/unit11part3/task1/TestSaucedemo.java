package hw.unit11part3.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TestSaucedemo {
    @DisplayName("Задание 1")
    @Test
    public void testSaucedemo() {
        browserInit();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LoginPage.saucedemoUrl);
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        Assertions.assertEquals("Swag Labs", loginPage.siteHeader.getText(), "Заголовок не совпадает.");
        driver.quit();
    }

    public static void browserInit() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
    }
}
