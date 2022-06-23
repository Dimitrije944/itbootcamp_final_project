package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForSignUpButtonToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]")));
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'flex text-xs-center mt-5')]/button"));
    }
}
