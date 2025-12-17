package tests.adminOO.editingUser;

import org.openqa.selenium.By;

public class Locators {

  public final static By ADMINISTRATION_DROPDOWN = By.xpath("//a[contains(@class, 'nav-link')]//p[contains(text(), 'Администрирование')]");
  public final static By USERS_REGISTRY = By.xpath("//a[contains(@class, 'nav-link')]//p[contains(text(), 'Пользователи')]");

  public final static By EDITING_USER_CARD = By.xpath("//a[@title='Изменить' and span[contains(@class, 'fa-pencil-alt')]]");

  public static final By NEXT_BUTTON_REFRESH = By.xpath("//button[@type='submit' and text()='Обновить']");

  public final static By USER_LOGIN = By.id("user-username");
  public final static By USER_EMAIL = By.id("user-email");
  public final static By USER_FULL_NAME = By.id("user-full_name");
  public final static By USER_POSITION = By.id("user-position");
  public final static By USER_PHONE = By.id("user-phone");
}
