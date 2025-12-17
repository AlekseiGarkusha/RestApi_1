package tests.adminOO.WIP_workingWithStatuses;

import org.openqa.selenium.By;

public class Locators {
  public static final By STATEMENTS_MENU  = By.xpath("//a[contains(@class, 'nav-link') and .//p[contains(text(), 'Заявления')]]");
  public static final By REGISTER_OF_APPLICATIONS  = By.xpath("//a[contains(@class, 'nav-link') and .//p[contains(text(), 'Реестр заявлений')]]");


  public static final By FILTER_BY_STATUSES = By.id("select2-applicationview-status_id-container");
  public static final By FILL_STATUS_APPLICATION_ACCEPTED = By.xpath("//li[text()='Заявление принято']");

  public static final By APPLICATION_CARD  = By.xpath("(//tbody/tr[not(contains(@style, 'display:none'))])[1]//a[@title='Просмотр' and @aria-label='Просмотр' and span[contains(@class, 'fa-eye')]]");

  public static final By CHANGE_STATUS_BTN = By.xpath("//button[text()='Смена статуса']");

  public static final By CHANGE_STATUS_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите статус заявления')]]");
  public static final By CHANGE_STATUS_DEVIATION = By.xpath("//li[text()='Заявление отклонено']");

  public static final By CHANGE_STATUS_HINT = By.xpath("//div[contains(@class, 'invalid-feedback') and contains(text(), 'Необходимо заполнить «Причина изменения статуса».')]");
  public static final By CHANGE_STATUS_TEXTAREA= By.id("application-description_status");

  public static final By CHANGE_STATUS_BTN_SAVE = By.xpath("//button[text()='Сохранить']");
}
