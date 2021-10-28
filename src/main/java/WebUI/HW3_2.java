package WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW3_2 {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);
        login();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a//span[.='Контрагенты']"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Контактные лица']"))).click().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Зенкова");
        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Дарья");
        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Тестировщик");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
    }

    public static void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
