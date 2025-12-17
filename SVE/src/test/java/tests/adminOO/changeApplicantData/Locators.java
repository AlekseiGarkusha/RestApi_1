package tests.adminOO.changeApplicantData;

import org.openqa.selenium.By;

public class Locators {
  public static final By OPEN_FIRST_APPLICATION_CARD = By.xpath("//tbody/tr[1]/td[last()]//a[@title='Просмотр' and @aria-label='Просмотр']");
  public static final By CLICK_CHANGE_DATA_BTN = By.xpath("//button[contains(@type, 'button') and @data-original-title='Редактировать']");
  public static final By NEW_APPLICANT_GENDER_DROPDOWN = By.xpath("//span[@id='select2-applicant-gender_id-container']/ancestor::span[@role='combobox']");
  public static final By APPLICANT_GENDER_MALE = By.xpath("//li[contains(@class, 'select2-results__option') and text()='мужской']");
  public static final By APPLICANT_GENDER_FEMALE = By.xpath("//li[contains(@class, 'select2-results__option') and text()='женский']");
  public static final By CLICK_BTN_CHANGES_SAVE = By.xpath("//button[@type='submit' and contains(@class, 'kv-btn-save') and @data-original-title='Сохранить']");

  public static final By ACTUAL_APPLICANT_SURNAME = By.xpath("//td[.//input[@id='applicant-surname']]");
  public static final By ACTUAL_APPLICANT_NAME = By.xpath("//td[.//input[@id='applicant-name']]");
  public static final By ACTUAL_APPLICANT_PATRONYMIC = By.xpath("//td[.//input[@id='applicant-patronymic']]");
  public static final By ACTUAL_APPLICANT_GENDER = By.xpath("//td[.//select[@id='applicant-gender_id']]");
  public static final By ACTUAL_APPLICANT_BIRTH_DATE = By.xpath("//td[.//input[@id='applicant-birthdate']]");
  public static final By NEW_ACTUAL_APPLICANT_BIRTH_PLACE = By.xpath("//td[.//input[@id='applicant-birthplace']]");
  public static final By ACTUAL_APPLICANT_INDEX = By.xpath("//td[.//input[@id='applicant-index']]");
  public static final By ACTUAL_APPLICANT_ADDRESS = By.xpath("//td[.//input[@id='applicant-address']]");
  public static final By ACTUAL_APPLICANT_SNILS = By.xpath("//td[.//input[@id='applicant-snils']]");
  public static final By ACTUAL_APPLICANT_EMAIL = By.xpath("//td[.//input[@id='applicant-email']]");
  public static final By ACTUAL_APPLICANT_PHONE = By.xpath("//td[.//input[@id='applicant-phone']]");
  public static final By ACTUAL_DATE_UPDATED = By.xpath("//td[.//input[@id='applicant-updated_at']]");
}
