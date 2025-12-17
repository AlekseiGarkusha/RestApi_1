package tests.registration.registrationClassic.steps.step_2;

import org.openqa.selenium.By;

public class Locators {
  public static final By DOCUMENT_TYPE_CONTAINER = By.xpath("//span[@id='select2-document-code-container']");
  public static final By DOCUMENT_TYPE = By.xpath("//li[contains(text(),'Паспорт гражданина Российской Федерации')]");
  public static final By DOCUMENT_SERIES = By.id("document-series");
  public static final By DOCUMENT_NUMBER = By.id("document-number");
  public static final By DOCUMENT_ISSUED = By.id("document-issued");
  public static final By DOCUMENT_ISSUE_DATE = By.id("document-issue_date");
  public static final By DOCUMENT_DEPARTMENT_CODE = By.id("document-department_code");
  public static final By NEXT_BUTTON_STEP_2 = By.xpath("//button[@type='submit' and text()='Далее']");
}
