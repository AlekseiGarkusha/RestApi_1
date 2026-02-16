package data;

public class Locators {
  // Мониторинг зоны
  public static String MONITORING_ZONY = "//a[.//span[text()='Транспортный мониторинг зоны']]";

  public static String BTN_ADD = "//button[contains(text(),'Добавить')]";
  public static String REGION_DEFINITION = "//h3[contains(normalize-space(), 'Регион поиска')]";

  public static String ZONE_MUNICIPALITY_NAME = "//h3[normalize-space()='Регион поиска']/following-sibling::div[contains(@class,'input-box-content')]";
  public static String ZONE_MUNICIPALITY_DESCRIPTION = "//h3[normalize-space()='Описание']/following-sibling::div[contains(@class,'input-box-content')]";

  public static String FIELD_NAME = "//div[h3[contains(text(),'Название')]]//input";
  public static String FIELD_DESCRIPTION = "//div[h3[contains(text(),'Описание')]]//textarea";

  public static String START_DATE_FIELD = "//h3[normalize-space(text())='Дата начала']" + "/following-sibling::app-date-picker//div[contains(@class,'backdrop-button')]";
  public static String FINAL_DATE_FIELD = "//h3[normalize-space(text())='Дата окончания']" + "/following-sibling::app-date-picker//div[contains(@class,'backdrop-button')]";
  public static String BTN_NEXT_MONTH = "//div[@class='header header-years']/button[contains(@class,'next')]";

  public static String MUNICIPALITY_FIELD = "//h3[normalize-space(text())='Муниципалитет *']/parent::div/following-sibling::div[contains(@class,'select-arrow')]";
  public static String MUNICIPALITY_SYMFEROPOL = "//div[contains(@class,'input-box-content') and contains(@class,'option-item') and normalize-space(text())='Симферополь']";

  public static String CAMERA_FIELD = "//h3[normalize-space(text())='Камера *']/parent::div/following-sibling::div[contains(@class,'select-arrow')]";
  public static String CAMERA_CHOICE_KFU = "//div[contains(@class,'input-box-content') and contains(@class,'option-item') and normalize-space(text())='КФУ 3']";
  public static String CAMERA_CHOICE_159 = "//div[contains(@class,'input-box-content') and contains(@class,'option-item') and normalize-space(text())='Победы /Кечкеметская 159']";

  public static String BTN_CAPTURE_FRAME = "//button[contains(text(),'Захватить кадр')]";
  public static String BTN_SAVE = "//button[contains(text(),'Сохранить')]";
  public static String VIEW_RESULTS = "//a[.//div[contains(text(), 'посмотреть результаты')]]";

  // Поиск
  public static String SEARCH = "//div[contains(@class,'input-filter')]//input";

  // Функциональные кнопки карточки
  public static String LOAD_FOUND = "//app-svg-inline[.//div[contains(@class, 'table-tooltip') and text()='загрузить найденное']]\n";
  public static String BTN_OPEN_PHOTO = "//app-svg-inline[.//div[contains(text(),'открыть фото в отдельном окне')]]";
  public static String BTN_CLOSE_PHOTO = ".icon-container";
  public static String BTN_OPEN_VIDEO = "//app-svg-inline[.//div[contains(text(),'открыть видео в отдельном окне')]]";
  public static String BTN_CLOSE_VIDEO = "//app-svg-inline[.//div[text()='закрыть']]";
}
