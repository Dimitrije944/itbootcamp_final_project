package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {

        this.driver = driver;
    }
    public WebElement getHomeLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a"));
    }
    public void waitForHomeLinkToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a")));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.linkText("/profile"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }
    public WebElement getCitiesLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-sheet')]/a[contains(@class, 'btnAdminCities')]"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-sheet')]/a[contains(@class, 'btnAdminUsers')]"));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[3]"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }
    public WebElement getENLanguageButton(){

        return driver.findElement(By.xpath("//div[contains(@class, 'ml-3')]"));
    }
    public WebElement getESLanguageButton(){

        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[2]"));
    }
    public WebElement getFRLanguageButton(){

        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[3]"));
    }
    public WebElement getCNLanguageButton(){

        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu')]/div/div[4]"));
    }
    public WebElement getHeaderFromChangedLanguage(){
        return driver.findElement(By.xpath("//div[contains(@class, 'container')]/div/div/h1"));
    }
}
