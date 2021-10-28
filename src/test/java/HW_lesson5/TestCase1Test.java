package HW_lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase1Test {
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
    public void createProjectTest() throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//a//span[.='Проекты']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Мои проекты']"))).click().build().perform();

        WebElement buttonText = driver.findElement(By.xpath("//a[text()='Создать проект']"));
        Thread.sleep(5000);
        Assertions.assertEquals("Создать проект", buttonText.getText());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        WebElement information = driver.findElement(By.xpath("//a[text()='Основная информация']"));
        Assertions.assertEquals("Основная информация", information.getText());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("Новый тест3");
        WebElement crmProjectName = driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]"));
        Assertions.assertEquals("Новый тест3", crmProjectName);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();
        WebElement organization = driver.findElement(By.xpath("//div[text()='«Все организации»']"));
        Assertions.assertEquals("«Все организации»", organization.getText());

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='select2-container select2']/a/span[@class='select2-chosen']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='&&& Ольга']")).click();
        WebElement contactPerson = driver.findElement(By.xpath("//div[text()='&&& Ольга']"));
        Assertions.assertEquals("&&& Ольга", contactPerson.getText());

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");
        WebElement businessUnit = driver.findElement(By.name("crm_project[businessUnit]"));
        Assertions.assertEquals("Research & Development", businessUnit.getText());

        Thread.sleep(5000);
        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Караев Сергей");

        Thread.sleep(5000);
        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Исаева Анастасия");
        WebElement administrator = (driver.findElement(By.name("crm_project[administrator]")));
        Assertions.assertEquals("Исаева Анастасия", administrator.getText());

        Thread.sleep(5000);
        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Козлов Илья");
        WebElement manager = driver.findElement(By.name("crm_project[manager]"));
        Assertions.assertEquals("Козлов Илья", manager.getText());

        Thread.sleep(5000);
        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Амелин Владимир");
        WebElement curator = driver.findElement(By.name("crm_project[curator]"));
        Assertions.assertEquals("Амелин Владимир", curator.getText());

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        String message = driver.findElement(By.xpath("//div[@class=’message’]")).getText();
        Assertions.assertTrue(message == "Проект сохранен");
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
