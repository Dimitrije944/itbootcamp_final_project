package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {
    @Test(priority = 10)
    public void visitsTheSignupPage() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getSignUpButton().click();
        Assert.assertEquals(
                signUpPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Email input does not have valid type");
        Assert.assertEquals(
                signUpPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Password input does not have valid type");
        Assert.assertEquals(
                signUpPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Confirm password input does not have valid type");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists() {
        navPage.getSignUpButton().click();
        signUpPage.waitForSignUpButtonToBeVisible();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");
        signUpPage.getFirstNameInput().sendKeys("Another User");
        signUpPage.getEmailInput().sendKeys("admin@admin.com");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpDialogToBeVisible();
        Assert.assertTrue(messagePopUpPage.getCloseDialogTextMessageForEmail().getText().contains("E-mail already exists"),
                "[ERROR] The dialog does not contain this text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain this text");
    }

    @Test(priority = 40)
    public void signup() {
        navPage.getSignUpButton().click();
        signUpPage.waitForSignUpButtonToBeVisible();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Page url does not contain /signup");
        signUpPage.getFirstNameInput().sendKeys("Ime i prezime polaznika");
        signUpPage.getEmailInput().sendKeys("ime.prezime@itbootcamp.rs");
        signUpPage.getPasswordInput().sendKeys("12345");
        signUpPage.getConfirmPasswordInput().sendKeys("12345");
        signUpPage.getSignMeUpButton().click();

        driver.get(baseUrl + "/home");

        messagePopUpPage.waitForVerifyYourAccountDialogToBeVisible();
        Assert.assertTrue(messagePopUpPage.getHeaderVerifyYourAccountDialogText().getText().contains("IMPORTANT: Verify your account"),
                "[ERROR] The dialog does not contain this text");
        messagePopUpPage.getCloseDialogButton().click();
        navPage.getLogoutButton().click();
    }


}
