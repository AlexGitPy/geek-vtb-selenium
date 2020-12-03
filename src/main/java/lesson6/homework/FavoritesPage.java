package lesson6.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritesPage {
//
    private final WebDriver driver;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By header = By.xpath("//*[@id='__ozon']/div/div[1]/div[3]/div[4]/div[1]/div/a");

    public String getWarningText() {
        return driver.findElement(header).getText();
    }


}

//lesson6