package tests.adminOO.addEntranceExams;

import org.openqa.selenium.By;

public class Locators {
  public static final By SCHEDULE_ENTRANCE_TEST_MENU = By.xpath("//a[@class='nav-link ']//p[contains(text(), 'Расписание ВИ')]");
  public static final By ADD_ENTRANCE_TEST = By.xpath("//a[@class='nav-link ']//p[contains(text(), 'Добавление вступительного испытания')]");

  public static final By NAME_ENTRANCE_TEST = By.id("entranceexaminationform-name_subject");

  public static final By SPO_INSTITUTION_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите организацию')]]");
  public static final By SPO_INSTITUTION = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Государственное бюджетное профессиональное образовательное учреждение Республики Крым «Симферопольский автотранспортный техникум»')]");

  public static final By FORM_STUDY_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите форму обучения')]]");
  public static final By FORM_STUDY_FULL_TIME = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Очная')]");

  public static final By BASIC_EDUCATION_LEVEL_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите уровень образования')]]");
  public static final By BASIC_EDUCATION_LEVEL_9_CLASS = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Основное общее (9 классов)')]");

  public static final By FORM_PAYMENT_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите форму оплаты')]]");
  public static final By FORM_PAYMENT_BUDGET = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Бюджетная')]");

  public static final By SPECIALITY_PROFESSION_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите специальность')]]");
  public static final By SPECIALITY_PROFESSION = By.xpath("//li[contains(@class, 'select2-results__option') and .//b[contains(text(), 'Строительство и эксплуатация автомобильных дорог')]]");

  public static final By SYSTEM_ENTRANCE_EXAM_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите систему оценивания')]]");
  public static final By SYSTEM_ENTRANCE_EXAM = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Бальная')]");

  public static final By THRESHOLD_SCORE_ENTRANCE_EXAM = By.id("entranceexaminationform-threshold_score");

  public static final By ADD_ENTRANCE_TEST_BTN_SAVE = By.xpath("//button[@type='submit' and text()='Сохранить']");;
}
