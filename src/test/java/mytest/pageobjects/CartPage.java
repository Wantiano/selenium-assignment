package mytest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By checkoutButton = By.xpath("//button[@id='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        clickElementByLocator(checkoutButton);
    }
}
