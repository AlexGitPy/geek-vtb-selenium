package lesson6.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FavoritesPageTest {

    private static final String MAIN_URL = "https://www.ozon.ru/";

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
    public void checkFavoritesPageHeader() {
        FavoritesPage favoritesPage = mainPage.goToFavorites();
        String header = favoritesPage.getWarningText();
        Assert.assertEquals("Товары, которые чаще всего добавляют в Избранное", header);
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}


//lesson6