package lesson6.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By catalog = By.xpath("//*[text()='Каталог']");
    private final By appliances = By.xpath("//a[@href='/category/bytovaya-tehnika-10500/']");
    private final By refrigerators = By.xpath("//span[text()='Холодильники']");
    private final By header = By.xpath("//h1");

    private final By orders = By.xpath("//span[text()='Заказы']");

    private final By favorites = By.xpath("//span[text()='Избранное']");

    private final By basket = By.xpath("//span[text()='Корзина']");

    private final By loginOrRegisterButton = By.xpath("//*[text()='Вход или регистрация']");
    private final String idFrame = "authFrame";
    private final By getCodeButton = By.xpath("//*[text()='Получить код']");
    private final By emptyPhoneField = By.xpath("//*[text()='Заполните телефон']");
    private final By phoneField = By.xpath("//input[@name='phone']");
    private final By incorrectFormatPhone = By.xpath("//*[text()='Некорректный формат телефона']");

    private final By logInByMailButton = By.xpath("//*[text()='Войти по почте']");
    private final By emptyMailField = By.xpath("//*[text()='Заполните почту']");
    private final By mailField = By.xpath("//input[@name='email']");
    private final By incorrectFormatMail = By.xpath("//*[text()='Некорректный формат почты']");
    private final By backToTheMainPageButton = By.xpath("//*[text()='Вернуться на главный экран']");

    public void clickCatalog() {
        driver.findElement(catalog).click();
    }

    public void moveToAppliances() {
        Actions actions = new Actions(driver);
        WebElement appliance = driver.findElement(appliances);
        actions.moveToElement(appliance).build().perform();
    }

    public void clickRefrigerators() {
        driver.findElement(refrigerators).click();
    }

    public void goToTheCatalogWithRefrigerators() {
        this.clickCatalog();
        this.moveToAppliances();
        this.clickRefrigerators();
        new MainPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(header).getText();
    }

    public OrdersPage goToOrders() {
        driver.findElement(orders).click();
        return new OrdersPage(driver);
    }

    public FavoritesPage goToFavorites() {
        driver.findElement(favorites).click();
        return new FavoritesPage(driver);
    }

    public BasketPage goToBasket() {
        driver.findElement(basket).click();
        return new BasketPage(driver);
    }

    public void goToLoginOrRegisterFrame() {
        driver.findElement(loginOrRegisterButton).click();
    }

    public void goToSecondFrame() {
        goToLoginOrRegisterFrame();
        driver.switchTo().frame(idFrame);
    }


    public void clickTheGetCodeButton() {
        driver.findElement(getCodeButton).click();
    }

    public void sendPhoneNumber(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }


    public void clickTheLogInByMailButton() {
        driver.findElement(logInByMailButton).click();
    }

    public void sendMail(String mail) {
        driver.findElement(mailField).sendKeys(mail);
    }

    public void clickBackToTheMainPageButton() {
        driver.findElement(backToTheMainPageButton).click();
    }


    public String getIncorrectFormatPhoneError() {
        return driver.findElement(incorrectFormatPhone).getText();
    }

    public String getEmptyPhoneFieldError() {
        return driver.findElement(emptyPhoneField).getText();
    }

    public String getEmptyMailFieldError() {
        return driver.findElement(emptyMailField).getText();
    }

    public String getIncorrectFormatMailError() {
        return driver.findElement(incorrectFormatMail).getText();
    }
}
