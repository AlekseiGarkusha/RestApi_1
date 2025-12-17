package tests.registration.registrationClassic.steps.step_3;

import org.openqa.selenium.By;

public class Locators {
  public static final By EDUCATION_DOCUMENT_CODE_CONTAINER = By.id("select2-educationdocument-code-container");
  public static final By EDUCATION_DOCUMENT_CODE_OPTION = By.xpath("//li[contains(@class, 'select2-results__option') and contains(text(), 'Аттестат об основном общем образовании')]");
  public static final By EDUCATION_DOCUMENT_ISSUED = By.id("educationdocument-issued");
  public static final By EDUCATION_DOCUMENT_SERIES = By.id("educationdocument-series");
  public static final By EDUCATION_DOCUMENT_NUMBER = By.id("educationdocument-number");
  public static final By EDUCATION_DOCUMENT_ISSUE_DATE = By.id("educationdocument-issue_date");
  public static final By EDUCATION_DOCUMENT_WITH_DIFFERENCE = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/fieldset/div[6]/div/div[1]/div/div/span[2]");
  public static final By EDUCATION_DOCUMENT_RECEIVING_SPO_FIRST_TIME = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/fieldset/div[7]/div/div[1]/div/div/span[2]");
  public static final By EDUCATION_DOCUMENT_NUMBER_FIVES = By.id("educationdocument-number_fives");
  public static final By EDUCATION_DOCUMENT_NUMBER_FOURS = By.id("educationdocument-number_fours");
  public static final By EDUCATION_DOCUMENT_NUMBER_THREES = By.id("educationdocument-number_threes");
  public static final By NEXT_BUTTON_STEP_3 = By.xpath("//button[@type='submit' and text()='Далее']");
}
