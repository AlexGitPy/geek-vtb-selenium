package lesson5.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OzonMarketTest {

    private static final String MAIN_URL = "https://www.ozon.ru/";

    private static WebDriver driver;

    private static OzonMarketMainPage ozonMarketMainPage;

    private static OzonMarketRefrigeratorsPage ozonMarketRefrigeratorsPage;

    @BeforeAll
     public static void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(MAIN_URL);

        ozonMarketMainPage = new OzonMarketMainPage(driver);

        ozonMarketRefrigeratorsPage = new OzonMarketRefrigeratorsPage(driver);

    }

    @Test
    public void mainPageTest() {
        ozonMarketMainPage.goToTheCatalogWithRefrigerators();
//        ozonMarketRefrigeratorsPage.filterFunctionalCheck();
        String heading = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Холодильники", heading);
    }

    @Test
    public void goToOrders() {
        By orders = By.xpath("//span[text()='Заказы']");
        driver.findElement(orders).click();
        By warningXpath = By.xpath("//*[@id='__ozon']/div/div[1]/div[3]/div/div[2]");
        String warning = driver.findElement(warningXpath).getText();
        Assert.assertEquals("Есть промокод?\n" +
                "Введите промокод\n" +
                "Все акции и купоны\n" +
                "Вход\n" +
                "Войдите, чтобы отслеживать заказы\n" +
                "Вход или регистрация", warning);
    }

    @Test
    public void goToFavorites() {
        By favorites = By.xpath("//span[text()='Избранное']");
        driver.findElement(favorites).click();
        By headerXpath = By.xpath("//*[@id='__ozon']/div/div[1]/div[3]/div[4]/div[1]/div/a");
        String header = driver.findElement(headerXpath).getText();
        Assert.assertEquals("Товары, которые чаще всего добавляют в Избранное", header);
    }

    @Test
    public void goToBasket() {
        By basket = By.xpath("//span[text()='Корзина']");
        driver.findElement(basket).click();
        By warningXpath = By.xpath("//div[@class='b4k9']");
        String warning = driver.findElement(warningXpath).getText();
        Assert.assertEquals("Воспользуйтесь поиском, чтобы найти всё что нужно.\n" +
                "Если в корзине были товары –\n" +
                "войдите\n" +
                ", чтобы посмотреть список.", warning);
    }


    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
