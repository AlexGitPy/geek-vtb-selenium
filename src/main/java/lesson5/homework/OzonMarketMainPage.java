package lesson5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OzonMarketMainPage {

    private final WebDriver driver;

    public OzonMarketMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By catalog = By.xpath("//*[text()='Каталог']");
//    private final By appliances = By.xpath("//span[text()='Бытовая техника']");
    private final By appliances = By.xpath("//a[@href='/category/bytovaya-tehnika-10500/']");
    private final By refrigerators = By.xpath("//span[text()='Холодильники']");

    public void clickCatalog(){
        driver.findElement(catalog).click();
    }

    public void moveToAppliances() {
        Actions actions = new Actions(driver);
        WebElement appliance = driver.findElement(appliances);
        actions.moveToElement(appliance).build().perform();
    }

    public void clickRefrigerators(){
        driver.findElement(refrigerators).click();
    }

    public void goToTheCatalogWithRefrigerators(){
        this.clickCatalog();
        this.moveToAppliances();
        this.clickRefrigerators();
        new OzonMarketMainPage(driver);
    }
}
