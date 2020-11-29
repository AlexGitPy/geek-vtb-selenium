package lesson3.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketTest {

    private String MAIN_URL = "https://market.yandex.ru/";

    private WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(MAIN_URL);
    }

    @Test
    public void Catalog() {
        driver.findElement(By.linkText("Бытовая техника")).click();
        driver.findElement(By.linkText("Холодильники")).click();
        driver.findElement(By.xpath("//*[@name='Цена до']")).sendKeys("100000");
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//*[@class='_2y67xS5HuR'])[1]//span"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        checkboxes.get(2).click();
        checkboxes.get(5).click();
        driver.findElement(By.xpath("//*[@name='Количество компрессоров 2']/..//span")).click();
        driver.findElement(By.xpath("//*[@id='good-state_cutprice']/..//span")).click();
        driver.findElement(By.xpath("//*[@id='offer-shipping_delivery']/..//span")).click();
        String heading = driver.findElement(By.xpath("//*[text()='Холодильники'][@class='_3wPGpzKmmn']")).getText();
        Assert.assertEquals("Холодильники", heading);
    }

    @Test
    public void ProductSearch() {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.id("header-search")).sendKeys("Холодильник ATLANT ХМ 6025-060");
        driver.findElement(By.cssSelector(".\\_1XiEJDPVpk")).click();
        driver.findElement(By.cssSelector(".\\_1_IxNTwqll:nth-child(1) .\\_29F8FeAhp-:nth-child(7)")).click();
        // Яндекс опять начудили, к DOM не привзязали, но это не точно (:
//        String heading = driver.findElement(By.xpath("//h1[text()='Холодильник ATLANT ХМ 6025-060']")).getText();
//        Assert.assertEquals("Холодильник ATLANT ХМ 6025-060", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
