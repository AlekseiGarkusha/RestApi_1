package tests.registration.registrationComparisonFields.steps.step_2;

import org.openqa.selenium.By;

public class Locators {
  public static final By APPLICANT_TYPE_DOCUMENT_FIELD  = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[1]");
  public static final By APPLICANT_SERIES_DOCUMENT_FIELD  = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[2]");
  public static final By APPLICANT_NUMBER_DOCUMENT_FIELD  = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[3]");
  public static final By APPLICANT_DOCUMENT_ISSUED_FIELD  = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[4]");
  public static final By APPLICANT_DOCUMENT_ISSUE_DATE = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[5]");
  public static final By APPLICANT_DOCUMENT_DEPARTMENT_CODE = By.xpath("//*[@id=\"document-index-container\"]/table/tbody/tr/td[6]");
}
