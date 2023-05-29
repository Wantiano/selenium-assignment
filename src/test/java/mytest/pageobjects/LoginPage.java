package mytest.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By loginButtonLocator = By.xpath("//input[@id='login-button']");
    By errorMessageLocator = By.xpath("//h3");

    String username = "standard_user";
    String password = "secret_sauce";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.saucedemo.com/");

        WebElement bodyElement = waitAndReturnElement(bodyLocator);
        Assert.assertTrue(bodyElement.getText().contains("Swag Labs"));
    }

    public void login() {
        login(username);
    }

    public void lockedOutUserLogin() {
        login("locked_out_user");
    }

    public void login(String username) {
        WebElement usernameInput = waitAndReturnElement(By.xpath("//input[@id='user-name']"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = waitAndReturnElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton = waitAndReturnElement(loginButtonLocator);
        loginButton.click();
    }

    public boolean isUserLoggedOut() {
        WebElement loginButtonElement = waitAndReturnElement(loginButtonLocator);
        return "Login".equals(loginButtonElement.getAttribute("value"));
    }

    public boolean isUserLockedOut() {
        WebElement errorElement = waitAndReturnElement(errorMessageLocator);
        return "Epic sadface: Sorry, this user has been locked out.".equals(errorElement.getText());
    }
}
