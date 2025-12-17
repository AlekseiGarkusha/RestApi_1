package tests.registration.registrationClassic.steps.step_1;

import org.openqa.selenium.By;
public class Locators {
  public static final By APPLICANT_LASTNAME = By.id("applicant-surname");
  public static final By APPLICANT_NAME = By.id("applicant-name");
  public static final By APPLICANT_PATRONYMIC = By.id("applicant-patronymic");
  public static final By APPLICANT_BIRTH_DATE = By.id("applicant-birthdate");
  public static final By APPLICANT_GENDER_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection--single') and .//span[contains(text(), 'Выберите пол')]]");
  public static final By APPLICANT_GENDER = By.xpath("//li[@role='option' and text()='мужской']");
  public static final By APPLICANT_EMAIL = By.id("applicant-email");
  public static final By APPLICANT_BIRTH_PLACE = By.id("applicant-birthplace");
  public static final By APPLICANT_BIRTH_ADDRESS = By.id("applicant-address");
  public static final By APPLICANT_ADDRESS = By.id("applicant-address");
  public static final By APPLICANT_INDEX = By.id("applicant-index");
  public static final By APPLICANT_SNILS = By.id("applicant-snils");
  public static final By APPLICANT_PHONE = By.id("applicant-phone");
  public static final By NEXT_BUTTON_STEP_1 = By.xpath("//button[@type='submit' and text()='Далее']");
}
