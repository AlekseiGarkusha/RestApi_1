package tests.adminOO.addScoreEntranceExams;

import org.openqa.selenium.By;

public class Locators {
  public static final By EDITING_CARD_ENTRANCE_EXAMS = By.xpath("//a[@href='/arm/entrance-examination/update?id=157' and @title='Изменить']");
  public static final By BREAD_CRUMBS_ENTRANCE_EXAMS = By.xpath("//a[contains(text(), \"Тест ВИ для\") and contains(text(), \"автомобильных дорог\")]");
  public static final By COMPLETE_GROUP_ENTRANCE_EXAMS = By.xpath("//a[span[contains(@class, 'fa-users')] and @title='Укомплектовать группу']");
  public static final By COMPLETE_GROUP_ENTRANCE_EXAMS_OK = By.xpath("//button[span[contains(@class, 'fa-check')] and contains(text(), 'Ok')]");

  public static final By OPEN_SCORE_MODAL = By.xpath("//span[@class='far fa-plus-square']");
  public static final By RESULT_ENTRANCE_EXAMS = By.id("resultentranceexamination-score");
  public static final By SAVE_SCORE_BTN = By.xpath("//button[text()='Сохранить']");
}
