package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getEmailInput() {

        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {

        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'secondary')]"));
    }

    public void waitForLoginButtonToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[3]")));
    }

    public void waitForLogoutButtonToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));
    }

    public void waitForHomeUrlToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    public void waitForAdminCitiesUrlToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/admin/cities"));
    }

}
