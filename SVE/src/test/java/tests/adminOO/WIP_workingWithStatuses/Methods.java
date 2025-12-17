package tests.adminOO.WIP_workingWithStatuses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSteps;

import static tests.adminOO.WIP_workingWithStatuses.Locators.*;

public class Methods extends BaseSteps {

  public Methods(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void goToRegisterOfApplications () {
    wait.until(ExpectedConditions.elementToBeClickable(STATEMENTS_MENU)).click();
    wait.until(ExpectedConditions.elementToBeClickable(REGISTER_OF_APPLICATIONS)).click();
  }

  public void checkFilterStatusAccepted() {
    wait.until(ExpectedConditions.elementToBeClickable(FILTER_BY_STATUSES)).click();
    wait.until(ExpectedConditions.elementToBeClickable(FILL_STATUS_APPLICATION_ACCEPTED)).click();
  }

  public void goToApplicationCard() {
    wait.until(ExpectedConditions.elementToBeClickable(APPLICATION_CARD)).click();
  }

  public void changeStatusApplicant() {
    // Клик "Смена статуса"
    wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_BTN)).click();

    // Клик "Смена статуса на Заявление принято"
    wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_DEVIATION)).click();
  }

  public void clickBtnSave() {
    wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_BTN_SAVE)).click();
  }

  public void fillTextAreaComments() {
    wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_TEXTAREA)).sendKeys("Причина изменения статуса");
  }
}
