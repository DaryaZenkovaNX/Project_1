package WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.*;

public class HW3 {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        
        driver.get(CRM_URL);
        login();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a//span[.='Проекты']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Мои проекты']"))).click().build().perform();

        Thread.sleep(5000);
        //без данной паузы не находил кнопку "Создать проект". Думала, что установленное ожидание
        //в начале метода поможет этого избежать.
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("Новый тест");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='select2-container select2']/a/span[@class='select2-chosen']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='&&& Ольга']")).click();

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Thread.sleep(5000);
        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Караев Сергей");

        Thread.sleep(5000);
        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Исаева Анастасия");

        Thread.sleep(5000);
        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Козлов Илья");

        Thread.sleep(5000);
        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Амелин Владимир");

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
    }

    public static void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
