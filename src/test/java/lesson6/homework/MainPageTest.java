package lesson6.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private static final String MAIN_URL = "https://www.ozon.ru/";

    private static WebDriver driver;

    private static MainPage mainPage;

    private static RefrigeratorsPage refrigeratorsPage;

    @BeforeAll
     public static void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(MAIN_URL);

        mainPage = new MainPage(driver);

        refrigeratorsPage = new RefrigeratorsPage(driver);

    }

    @Test
    public void mainPageTest() {
        mainPage.goToTheCatalogWithRefrigerators();
//        refrigeratorsPage.filterFunctionalCheck();
        String heading = mainPage.getHeadingText();
        Assert.assertEquals("Холодильники", heading);
    }

    @Test
    public void emptyPhoneFieldError() {
        mainPage.goToSecondFrame();
        mainPage.clickTheGetCodeButton();
        String error = mainPage.getEmptyPhoneFieldError();
        Assert.assertEquals("Заполните телефон", error);

    }

    @Test
    public void incorrectFormatPhoneError() {
        mainPage.goToSecondFrame();
        mainPage.sendPhoneNumber("888 888 88 88");
        mainPage.clickTheGetCodeButton();
        String error = mainPage.getIncorrectFormatPhoneError();
        Assert.assertEquals("Некорректный формат телефона", error);
    }

    @Test
    public void emptyMailFieldError() {
        mainPage.goToSecondFrame();
        mainPage.clickTheLogInByMailButton();
        By mailField = By.xpath("//input[@name='email']");
        if (driver.findElement(mailField).isDisplayed()) {
            mainPage.clickTheGetCodeButton();
        }
        String error = mainPage.getEmptyMailFieldError();
        Assert.assertEquals("Заполните почту", error);
    }

    @Test
    public void incorrectFormatMailError() {
        mainPage.goToSecondFrame();
        mainPage.clickTheLogInByMailButton();
        mainPage.sendMail("kek");
        mainPage.clickTheGetCodeButton();
        String error = mainPage.getIncorrectFormatMailError();
        Assert.assertEquals("Некорректный формат почты", error);
        mainPage.clickBackToTheMainPageButton();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}


//lesson6