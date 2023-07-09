package hw.unit11part3.task4;

import dev.failsafe.internal.util.Assert;
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
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "/drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote=allow-origins=* ");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        driver.get(HomePage.herokuappUrl);

        //Действия на главной странице
        HomePage homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        Assert.isTrue(homePage.header.getText().contains("Dynamically Loaded Page Elements"), "Заголовок \"Dynamically Loaded Page Elements\" не совпадает.");

        //Поиск Hello World на странице
        String pageText = driver.findElement(By.tagName("body")).getText();
        Assert.isTrue(!pageText.contains("Hello world"), "Текст \"Hello world\" найден до нажатия кнопки \"Start\".");

        //Поиск Hello World после нажатия кнопки Start
        homePage.startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.visibilityOf(homePage.helloWorldField));

        //Выход
        driver.quit();
    }
}
