package mytest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {
    By finishButtonLocator = By.xpath("//button[@id='finish']");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void finishOrder() {
        clickElementByLocator(finishButtonLocator);
    }

    public boolean wasOrderSuccessful() {
        By orderCompleteLocator = By.xpath("//h2[@class='complete-header']");
        WebElement element = waitAndReturnElement(orderCompleteLocator);

        return "Thank you for your order!".equals(element.getText());
    }
}
