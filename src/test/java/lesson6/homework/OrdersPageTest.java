package lesson6.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrdersPageTest {

    private static final String MAIN_URL = "https://www.ozon.ru/";
//
    private static WebDriver driver;

    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(MAIN_URL);

        mainPage = new MainPage(driver);

    }


    @Test
    public void ordersPageWarning() {
        OrdersPage ordersPage = mainPage.goToOrders();
        String warning = ordersPage.getWarningText();
        Assert.assertEquals("Есть промокод?\n" +
                "Введите промокод\n" +
                "Все акции и купоны\n" +
                "Вход\n" +
                "Войдите, чтобы отслеживать заказы\n" +
                "Вход или регистрация", warning);
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}


//lesson7