package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest {
    @Test(priority = 10)
    public void visitsTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getENLanguageButton().click();
        navPage.getLoginButton().click();
        loginPage.waitForLoginButtonToBeVisible();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page url does not contain /login");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(
                loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Email input does not have valid type"
        );
        Assert.assertEquals(
                loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Password input does not have valid type"
        );
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpDialogToBeVisible();
        Assert.assertTrue(messagePopUpPage.getCloseDialogTextMessage().getText().contains("User does not exists"),
                "[ERROR] The dialog does not contain this text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] The url does not contain this text");
    }

    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpDialogToBeVisible();
        Assert.assertTrue(messagePopUpPage.getWrongDialogTextMessage().getText().contains("Wrong password"),
                "[ERROR] The dialog does not contain this text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] The url does not contain this text");
    }

    @Test(priority = 50)
    public void login() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        loginPage.waitForHomeUrlToBeVisible();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "[ERROR] Page url does not contain /home");
    }

    @Test(priority = 60)
    public void logout() {
        loginPage.waitForLogoutButtonToBeVisible();
        navPage.getLogoutButton().click();

    }

}
