package tests.registration.registrationClassic.steps.step_3;

import data.GeneratedTestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static tests.registration.registrationClassic.steps.step_3.Locators.*;

public class MethodsStep_3 {

  private final WebDriver driver;
  private final WebDriverWait wait;

  public MethodsStep_3(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void fillEducationDocumentCodeOption() {
    wait.until(ExpectedConditions.elementToBeClickable(EDUCATION_DOCUMENT_CODE_CONTAINER)).click();
    wait.until(ExpectedConditions.elementToBeClickable(EDUCATION_DOCUMENT_CODE_OPTION)).click();
  }

  public void fillEducationIssued(String issued) {
    driver.findElement(EDUCATION_DOCUMENT_ISSUED).sendKeys(issued);
  }

  public void fillEducationSeries(String series) {
    driver.findElement(EDUCATION_DOCUMENT_SERIES).sendKeys(series);
  }

  public void filEducationNumber(String number) {
    driver.findElement(EDUCATION_DOCUMENT_NUMBER).sendKeys(number);
  }

  public void fillEducationIssueDate(String issueDate) {
    wait.until(ExpectedConditions.elementToBeClickable(EDUCATION_DOCUMENT_ISSUE_DATE)).sendKeys(issueDate + Keys.ENTER);
  }

  public void clickEducationWithDifference() {
    driver.findElement(EDUCATION_DOCUMENT_WITH_DIFFERENCE).click();
  }

  public void clickBinaryReceivingSPOFirstTime() {
    driver.findElement(EDUCATION_DOCUMENT_RECEIVING_SPO_FIRST_TIME).click();
  }

  public void fillEducationNumberFives(String fives) {
    if (fives == null || fives.isEmpty()) {
      throw new IllegalArgumentException("Поле оценка не должно быть пустым");
    }
    driver.findElement(EDUCATION_DOCUMENT_NUMBER_FIVES).sendKeys(GeneratedTestData.gradeFives);
  }

  public void fillEducationNumberFours(String fours) {
    if (fours == null || fours.isEmpty()) {
      throw new IllegalArgumentException("Поле оценка не должно быть пустым");
    }
    driver.findElement(EDUCATION_DOCUMENT_NUMBER_FOURS).sendKeys(GeneratedTestData.gradeFours);
  }

  public void fillEducationNumberThrees(String threes) {
    if (threes == null || threes.isEmpty()) {
      throw new IllegalArgumentException("Поле оценка не должно быть пустым");
    }
    driver.findElement(EDUCATION_DOCUMENT_NUMBER_THREES).sendKeys(GeneratedTestData.gradeThrees);
  }

  public void clickNext() {
    driver.findElement(NEXT_BUTTON_STEP_3).click();
  }
}
