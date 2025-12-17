package tests.checkDuplicate.specialities;

import org.openqa.selenium.By;

public class LocatorsCheckDuplicateSpecialities {

  //Переход к созданию специальности
  public static final By MENU_RECEPTION_PLAN = By.xpath("//aside//nav//ul/li[4]/a");
  public static final By SUBMENU_ADD_SPECIALTIES = By.xpath("//aside//nav//ul/li[4]//ul/li[1]");

  public static final By SELECT_ORGANIZATION_DROPDOWN = By.xpath("//*[@id='w0']/div[1]/div/span/span[1]/span");
  public static final By CLICK_DROPDOWN_SPECIALTY = By.xpath("//*[@id='w0']/div[2]/div/span/span[1]/span");
  public static final By SPECIALTY_NAME = By.xpath("//li[contains(text(), 'Радиомеханик')]");
  public static final By APPLICATION_START_DATE = By.id("spospecialties-start_date_time");
  public static final By APPLICATION_END_DATE = By.id("spospecialties-end_date_time");
  public static final By APPLICATION_END_DATE_AGREED = By.id("spospecialties-end_date_time_agreed");
  public static final By BASIC_EDUCATION_LEVEL = By.xpath("//form/div[6]/div/span/span[1]/span");
  public static final By FORM_OF_STUDY = By.xpath("//form/div[7]/div/span/span[1]/span");
  public static final By FORM_OF_PAYMENT = By.xpath("//form/div[8]/div/span/span[1]/span");
  public static final By NUMBER_OF_PLACES = By.id("spospecialties-number_places");
  public static final By TERM_OF_STUDY = By.id("spospecialties-term_study");
  public static final By ENTRANCE_EXAMINATIONS = By.xpath("//*[@id='w0']/div[11]/div/div[1]/div/div/span[2]");
  public static final By MEDICAL_CERTIFICATE = By.xpath("//*[@id='w0']/div[12]/div/div[1]/div/div/span[2]");
  public static final By PROFILE_DISCIPLINES = By.xpath("//*[@id='w0']/div[13]/div/div[1]/div/div/span[2]");
  public static final By ADMISSION_EPGU = By.xpath("//*[@id='w0']/div[14]/div/div[1]/div/div/span[2]");
  public static final By SAVE_BUTTON = By.xpath("//*[@id='w0']/div[15]/div/button");
}
