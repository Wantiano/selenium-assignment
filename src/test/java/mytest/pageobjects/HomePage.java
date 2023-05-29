package mytest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    protected By hamburgerMenuButtonLocator = By.xpath("//button[@id='react-burger-menu-btn']");
    protected By logoutButtonLocator = By.xpath("//a[@id='logout_sidebar_link']");
    By addToCartButtonLocator = By.xpath("//button[ancestor::div[child::node()[child::node()[child::node()[child::node()[@class='inventory_item_name'][text()='Sauce Labs Bike Light']]]]]]");
    By cartButtonLocator = By.xpath("//a[@class='shopping_cart_link']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        clickElementByLocator(hamburgerMenuButtonLocator);
        WebElement logoutButton = waitAndReturnElement(logoutButtonLocator);
        return "Logout".equals(logoutButton.getText());
    }

    public void logout() {
        clickElementByLocator(hamburgerMenuButtonLocator);
        clickElementByLocator(logoutButtonLocator);
    }

    public void addProductToCart() {
        clickElementByLocator(addToCartButtonLocator);
    }

    public void goToCart() {
        clickElementByLocator(cartButtonLocator);
    }
}
