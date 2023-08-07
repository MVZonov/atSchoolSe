package hw.unit11part3.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class TestHerokuapp {
    @DisplayName("Задание 4")
    @Test
    public void testHerokuapp() {
        browserInit();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.get(HomePage.herokuappUrl);

        //Действия на главной странице
        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        Assertions.assertEquals(true, homePage.header.getText().contains("Dynamically Loaded Page Elements"), "Заголовок \"Dynamically Loaded Page Elements\" не совпадает.");

        //Поиск Hello World на странице
        String pageText = driver.findElement(By.tagName("body")).getText();
        Assertions.assertEquals(true, !pageText.contains("Hello world"), "Текст \"Hello world\" найден до нажатия кнопки \"Start\".");

        //Поиск Hello World после нажатия кнопки Start
        homePage.startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.visibilityOf(homePage.helloWorldField));

        //Выход
        driver.quit();
    }

    public static void browserInit() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
    }
}
