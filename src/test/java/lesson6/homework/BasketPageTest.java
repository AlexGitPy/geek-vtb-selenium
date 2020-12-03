package lesson6.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BasketPageTest {


    private static final String MAIN_URL = "https://www.ozon.ru/";

    private static WebDriver driver;

    private static MainPage mainPage;




    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        mainPage = new MainPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(MAIN_URL);


        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies -> " + cookies);

        driver.manage().deleteAllCookies();

    }


    @Test
    public void basketPageWarning() {
        BasketPage basketPage = mainPage.goToBasket();
        String warning = basketPage.getWarningText();
        Assert.assertEquals("Воспользуйтесь поиском, чтобы найти всё что нужно.\n" +
                "Если в корзине были товары –\n" +
                "войдите\n" +
                ", чтобы посмотреть список.", warning);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies -> " + cookies);
        Cookie nlbi_1101384 = driver.manage().getCookieNamed("nlbi_1101384");
        System.out.println("nlbi_1101384 -> " + nlbi_1101384);
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

