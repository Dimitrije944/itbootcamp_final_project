package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForPopUpDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error')]")));
    }

    public void waitForPopUpAddNewCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getElementsWithVisibleMessagesForCities() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }

    public WebElement getCloseDialogTextMessage() {
        return driver.findElement(By.xpath("//li[contains(text(), 'User does not exists')]"));
    }

    public WebElement getCloseDialogTextMessageForEmail() {
        return driver.findElement(By.xpath("//li[contains(text(), 'E-mail already exists')]"));
    }

    public WebElement getWrongDialogTextMessage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__content')]//li"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[contains(@role, 'status')]/button"));
    }

    public void waitForVerifyYourAccountDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog--active')]")));
    }

    public WebElement getHeaderVerifyYourAccountDialogText() {
        return driver.findElement(By.xpath("//div[contains(@class, 'grey')]"));
    }

    public WebElement getCloseDialogButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')]/button"));
    }

    public void waitForPopUpDeleteCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));
    }
}
