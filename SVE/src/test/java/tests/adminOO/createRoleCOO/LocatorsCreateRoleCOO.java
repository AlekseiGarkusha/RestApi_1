package tests.adminOO.createRoleCOO;

import org.openqa.selenium.By;

public class LocatorsCreateRoleCOO {
  public static final By ADMINISTRATION_MENU = By.xpath("//a[@class='nav-link ']//p[contains(text(), 'Администрирование')]");
  public static final By CREATING_USER_MENU = By.xpath("//a[@class='nav-link ']//p[contains(text(), 'Создание пользователя')]");

  // Создание Пользователя
  public static final By ADD_USER_USERNAME = By.id("user-username");
  public static final By ADD_USER_EMAIL = By.id("user-email");
  public static final By ADD_USER_FULL_NAME = By.id("user-full_name");
  public static final By ADD_USER_USER_POSITION = By.id("user-position");
  public static final By ADD_USER_USER_PHONE = By.id("user-phone");
  public static final By ADD_USER_ROLE_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите роль')]]");
  public static final By ADD_USER_ROLE_COO = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Пользователь СОО')]");
  public static final By ADD_USER_MINISTRY_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите')]]");
  public static final By ADD_USER_MINISTRY = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Министерство образования, науки и молодежи Республики Крым')]");
  public static final By ADD_USER_ORGANISATION_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(@class, 'select2-selection__placeholder') and contains(text(), 'Выберите организацию')]]");
  public static final By ADD_USER_ORGANISATION = By.xpath("//ul[contains(@class, 'select2-results__options')]//li[contains(text(), 'Государственное бюджетное профессиональное образовательное учреждение Республики Крым «Симферопольский автотранспортный техникум»')]");
  public static final By ADD_USER_BTN_SAVE = By.xpath("//button[@type='submit' and text()='Сохранить']");
}
