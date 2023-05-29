package mytest;

import mytest.pageobjects.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceDemoSeleniumTest {

    public WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @Test
    public void lockedOutUserLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.lockedOutUserLogin();

        Assert.assertTrue(loginPage.isUserLockedOut());
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.logout();

        Assert.assertTrue(loginPage.isUserLoggedOut());
    }

    @Test
    public void orderSomething() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart();
        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        YourInformationPage yourInformationPage = new YourInformationPage(driver);
        yourInformationPage.fillOutForm();
        yourInformationPage.continueOrder();

        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.finishOrder();

        Assert.assertTrue(overviewPage.wasOrderSuccessful());
    }
}
