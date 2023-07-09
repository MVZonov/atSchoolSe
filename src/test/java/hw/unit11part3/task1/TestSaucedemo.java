package hw.unit11part3.task1;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class TestSaucedemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LoginPage.saucedemoUrl);
//        String text = driver.findElement(By.ByXPath.xpath("//div/div/div")).getText();
//        Assert.isTrue(text.contains("Swag1 Labs"), "Заголовок не совпадает.");
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(driver, loginPage);
        Assert.isTrue(loginPage.siteHeader.getText().contains("Swag Labs"), "Заголовок не совпадает.");
        driver.quit();
    }
}
