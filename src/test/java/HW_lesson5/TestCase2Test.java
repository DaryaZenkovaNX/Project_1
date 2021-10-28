package HW_lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2Test {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
        login();
    }

    @Test
    public void createContactPersonTest() throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a//span[.='Контрагенты']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Контактные лица']"))).click().build().perform();

        Thread.sleep(5000);

        WebElement buttonText = driver.findElement(By.xpath("//a[text()='Создать контактное лицо']"));
        Assertions.assertEquals("Создать контактное лицо",buttonText.getText());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        WebElement information = driver.findElement(By.xpath("//a[text()='Основная информация']"));
        Assertions.assertEquals("Основная информация", information.getText());

        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Зенкова");
        WebElement lastName = driver.findElement(By.name("crm_contact[lastName]"));
        Assertions.assertEquals("Зенкова", lastName.getText());

        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Дарья");
        WebElement firstName = driver.findElement(By.name("crm_contact[firstName]"));
        Assertions.assertEquals("Дарья", firstName.getText());

        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Тестировщик");
        WebElement jobTitle = driver.findElement(By.name("crm_contact[jobTitle]"));
        Assertions.assertEquals("Тестировщик", jobTitle.getText());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();
        WebElement organization = driver.findElement(By.xpath("//div[text()='«Все организации»']"));
        Assertions.assertEquals("«Все организации»", organization.getText());

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        String message = driver.findElement(By.xpath("//div[@class=’message’]")).getText();
        Assertions.assertTrue(message == "Контактное лицо сохранено");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
