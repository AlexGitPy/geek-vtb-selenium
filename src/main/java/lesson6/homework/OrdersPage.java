package lesson6.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
//
    private final WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By warning = By.xpath("//*[@id='__ozon']/div/div[1]/div[3]/div/div[2]");

    public String getWarningText() {
        return driver.findElement(warning).getText();
    }


}

//lesson6