package tests.adminOO.addGroupsEntranceExams.main;

import org.openqa.selenium.By;

public class Locators {

  public static final By ENTRANCE_EXAMS_MENU = By.xpath("//a[contains(@class, 'nav-link')]//p[contains(text(), 'Вступительные испытания')]");
  public static final By VIEW_CARD_ENTRANCE_EXAMS = By.xpath("//a[./span[contains(@class, 'fa-eye')]]");
  public static final By ADD_ENTRANCE_GROUP_BUTTON = By.xpath("//a[@title='Добавление группы вступительных испытаний']");
  public static final By ENTRANCE_EXAMS_GROUP_NAME = By.id("examinationgroupform-name");
  public static final By ENTRANCE_EXAMS_GROUP_LOCATION = By.id("examinationgroupform-location_exam");
  public static final By ENTRANCE_EXAMS_GROUP_NUMBER_SEATS= By.id("examinationgroupform-number_places");
  public static final By ENTRANCE_EXAMS_GROUP_DATE_TIME = By.id("examinationgroupform-exam_date_time");
  public static final By ENTRANCE_EXAMS_GROUP_BTN_SAVE = By.xpath("//button[@type='submit' and text()='Сохранить']");
}
