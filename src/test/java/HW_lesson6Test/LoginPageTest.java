package HW_lesson6Test;

import HW_lesson6.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @Test
    public void loginTest() {
        new LoginPage(webDriver).login("Applanatest1", "Student2020!");
    }
}
