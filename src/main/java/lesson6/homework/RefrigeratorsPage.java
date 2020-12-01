package lesson6.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class RefrigeratorsPage {

    /*
    Бесполезный класс, потому, что к дом ничего не прикреплено, не подходит для автоматизации
     */

    private final WebDriver driver;


    public RefrigeratorsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By maxPrice = By.xpath("(//input[@class='ui-av9 ui-av4 ui-c7'])[2]");
    private final By brandsViewAll = By.xpath("(//span[@class='cy4'])[1]");
    private final By brandsFind = By.xpath("(//input[@class='ui-av9 ui-av4'])[1]");
    private final By brandCheckBox = By.xpath("(//input[@class='ui-aj'])[3]");
    private final By withFreezer = By.xpath("((//*[@class='b7n filter-block'])[5]//input)[1]");
    private final By numberOfCameras = By.xpath("((//*[@class='b7n filter-block'])[8]//input)[1]");
    private final By numberOfCompressors = By.xpath("((//*[@class='b7n filter-block'])[24]//input)[2]");

    public void clickMaxPrice() {
        driver.findElement(maxPrice).click();
        driver.findElement(maxPrice).sendKeys("100000");
    }

    public void checkBrands() {
        driver.findElement(brandsViewAll).click();
        ArrayList<String> brands = new ArrayList<>(Arrays.asList("Atlant", "Beko", "Bosch", "LG"));
        for (String brand : brands) {
            driver.findElement(brandsFind).sendKeys(brand);
            driver.findElement(brandCheckBox).click();
            driver.findElement(brandsFind).clear();
        }
    }

    public void clickWithFreezer() {
        driver.findElement(withFreezer).click();
    }

    public void clickNumberOfCameras(){
        driver.findElement(numberOfCameras).click();
    }

    public void clickNumberOfCompressors(){
        driver.findElement(numberOfCompressors).click();
    }

    public RefrigeratorsPage filterFunctionalCheck(){
        this.clickMaxPrice();
        this.checkBrands();
        this.clickWithFreezer();
        this.clickNumberOfCameras();
        this.clickNumberOfCompressors();
        return new RefrigeratorsPage(driver);
    }
}
