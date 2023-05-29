package mytest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInformationPage extends BasePage {

    By firstNameInputLocator = By.xpath("//input[@id='first-name']");
    By lastNameInputLocator = By.xpath("//input[@id='last-name']");
    By postalCodeInputLocator = By.xpath("//input[@id='postal-code']");
    By continueButtonLocator = By.xpath("//input[@id='continue']");

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillOutForm() {
        waitAndReturnElement(firstNameInputLocator).sendKeys("asd");
        waitAndReturnElement(lastNameInputLocator).sendKeys("beq");
        waitAndReturnElement(postalCodeInputLocator).sendKeys("123");
    }

    public void continueOrder() {
        clickElementByLocator(continueButtonLocator);
    }
}
