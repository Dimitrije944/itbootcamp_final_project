package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        loginPage.waitForAdminCitiesUrlToBeVisible();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Page url does not contain /admin/cities");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getNameInput().getAttribute("type"),
                "text",
                "[ERROR] Name input does not have valid type");
    }

    @Test(priority = 30)
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemDialogToBeVisible();
        citiesPage.getNameInput().sendKeys("Nis");
        citiesPage.getSaveButtonFromTheEditDialog().click();
        messagePopUpPage.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City is not saved");

    }

    @Test(priority = 40)
    public void editCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchCitiesInput().sendKeys("Nis");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonByRowIndex(1).click();
        citiesPage.getEditNameFieldInDialog().click();
        citiesPage.waitForEditDialogToBeVisible();
        citiesPage.getEditNameFieldInDialog().sendKeys(Keys.CONTROL, "a");
        citiesPage.getEditNameFieldInDialog().sendKeys("Beograd");
        citiesPage.getSaveButtonFromTheEditDialog().click();
        messagePopUpPage.waitForPopUpAddNewCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Saved"),
                "[ERROR] City is not saved");
    }

    @Test(priority = 50)
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchCitiesInput().sendKeys("Beograd");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(citiesPage.getTableCell(1, 2).getText().contains("Beograd"),
                "[ERROR] The city does not exist in the search");
    }

    @Test(priority = 60)
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchCitiesInput().sendKeys("Beograd");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(citiesPage.getTableCell(1, 2).getText().contains("Beograd"),
                "[ERROR] There is no such text on this page");
        citiesPage.getDeleteButtonByRowIndex(1).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getDeleteButtonFromDeleteDialog().click();
        messagePopUpPage.waitForPopUpDeleteCityToBeVisible();
        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City is not deleted");
    }
}

