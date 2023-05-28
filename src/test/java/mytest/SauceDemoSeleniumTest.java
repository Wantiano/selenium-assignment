package mytest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SauceDemoSeleniumTest {

    public WebDriver driver;
    private WebDriverWait wait;

    By bodyLocator = By.tagName("body");

    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    @Test
    public void openUpPage() {
        this.driver.get("https://www.saucedemo.com/");

        WebElement bodyElement = waitAndReturnElement(bodyLocator);
        Assert.assertTrue(bodyElement.getText().contains("Swag Labs"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
