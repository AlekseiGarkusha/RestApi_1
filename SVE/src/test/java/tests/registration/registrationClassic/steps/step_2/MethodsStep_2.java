package tests.registration.registrationClassic.steps.step_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static tests.registration.registrationClassic.steps.step_2.Locators.*;

public class MethodsStep_2 {
  private final WebDriver driver;
  private final WebDriverWait wait;

  public MethodsStep_2(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillTypeOfDocument() {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_TYPE_CONTAINER)).click();
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_TYPE)).click();
  }

  public void fillDocumentSeries(String series) {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_SERIES)).sendKeys(series);
  }

  public void fillDocumentNumber(String number) {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_NUMBER)).sendKeys(number);
  }

  public void fillDocumentIssued(String issued) {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_ISSUED)).sendKeys(issued);
  }

  public void fillDocumentIssueDate(String issueDate) {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_ISSUE_DATE)).sendKeys(issueDate);
  }

  public void fillDocumentDepartmentCode(String code) {
    wait.until(ExpectedConditions.elementToBeClickable(DOCUMENT_DEPARTMENT_CODE)).sendKeys(code);
  }

  public void clickNext() {
    wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON_STEP_2)).click();
  }
}
