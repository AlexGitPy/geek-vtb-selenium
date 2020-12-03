package lesson6.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
//
    private final WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By warning = By.xpath("//div[@class='b4k9']");

    public String getWarningText() {
        return driver.findElement(warning).getText();
    }


}

//lesson6
