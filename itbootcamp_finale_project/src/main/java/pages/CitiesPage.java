package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
    }

    public WebElement getNameInput() {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }

    public WebElement getSearchCitiesInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitForNewEditItemDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }

    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }

    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog--active')]")));
    }

    public WebElement getSaveButtonFromTheEditDialog() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }

    public WebElement getDeleteButtonFromDeleteDialog() {
        return driver.findElement(By.xpath("//div[contains(@class, 'rounded-0')]//button[2]"));
    }

    public void waitForNumberOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), rowNum));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver
                .findElement(By.xpath(
                        "//table/tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }

    public WebElement getEditButtonByRowIndex(int RowIndex) {
        return driver.findElements(By.id("edit")).get(RowIndex);
    }

    public WebElement getDeleteButtonByRowIndex(int row) {
        return driver.findElement(By.xpath("//button[contains(@id, 'delete')][" + row + "]"));
    }

    public WebElement getEditButton() {
        return driver.findElement(By.id("edit"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.id("delete"));
    }

    public WebElement getEditNameFieldInDialog() {
        return driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
    }

}
