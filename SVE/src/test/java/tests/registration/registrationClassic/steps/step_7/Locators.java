package tests.registration.registrationClassic.steps.step_7;

import org.openqa.selenium.By;

public class Locators {
  // == Справка об инвалидности ==
  public static final By SELECT_SPECIAL_CONDITIONS_FORM_DROPDOWN = By.xpath("//*[@id=\"msform\"]/div[1]/div/div[1]/div/div/span[2]");
  public static final By SPECIAL_CONDITIONS_FORM_SERIAL = By.id("specialconditionsform-serial");
  public static final By SPECIAL_CONDITIONS_FORM_NUMBER = By.id("specialconditionsform-number");
  public static final By SPECIAL_CONDITIONS_FORM_GROUP = By.id("specialconditionsform-group");
  public static final By SPECIAL_CONDITIONS_FORM_REASON = By.id("specialconditionsform-reason");
  public static final By SPECIAL_CONDITIONS_FORM_ISSUED = By.id("specialconditionsform-issued");
  public static final By SPECIAL_CONDITIONS_FORM_ISSUE_DATE = By.id("specialconditionsform-issue_date");
  public static final By SPECIAL_CONDITIONS_FORM_EXPIRATION_DATE = By.id("specialconditionsform-expiration_date");
  // == Льгота ==
  // 1
  public static final By SELECT_BENEFITS = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/div[3]/div/div[1]/div/div/span[3]");
  public static final By BENEFITS_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_1 = By.xpath("//li[text()='Герои России и обладатели трёх орденов Мужества']");
  // 2
  public static final By ADD_BENEFIT_TEMPLATE_2 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_2 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_2 = By.xpath("//li[text()='Участники боевых действий и служащие на территориях проведения специальной военной операции (СВО) и граничащих с ними, а также их дети']");
  // 3
  public static final By ADD_BENEFIT_TEMPLATE_3 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_3 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_3 = By.xpath("//li[text()='Ветераны и участники боевых действий — кроме участников СВО']");
  // 4
  public static final By ADD_BENEFIT_TEMPLATE_4 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_4 = By.xpath("//span[@class='select2-selection__placeholder' and text()='Выберете льготу ...']");
  public static final By BENEFIT_LIST_ITEM_4 = By.xpath("//li[contains(@class, 'select2-results__option') and contains(text(), 'Военнослужащие и сотрудники силовых ведомств')]");
  // 5
  public static final By ADD_BENEFIT_TEMPLATE_5 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_5 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_5 = By.xpath("//li[text()='Дети военнослужащих и сотрудников силовых ведомств — кроме детей участников СВО']");
  // 6
  public static final By ADD_BENEFIT_TEMPLATE_6 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_6 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_6 = By.xpath("//li[text()='Дети участников боевых действий за границей']");
  // 7
  public static final By ADD_BENEFIT_TEMPLATE_7 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_7 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_7 = By.xpath("//li[text()='Дети умерших от COVID-19 медработников']");
  // 8
  public static final By ADD_BENEFIT_TEMPLATE_8 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_8 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_8 = By.xpath("//li[text()='Дети-сироты и дети, оставшиеся без попечения родителей']");
  // 9
  public static final By ADD_BENEFIT_TEMPLATE_9 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_9 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_9 = By.xpath("//li[text()='Дети-инвалиды']");
  // 10
  public static final By ADD_BENEFIT_TEMPLATE_10 = By.xpath("//div[contains(@class, 'multiple-input-list__btn') and contains(@class, 'js-input-plus')]");
  public static final By BENEFIT_DROPDOWN_ROW_10 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете льготу')]]");
  public static final By BENEFIT_LIST_ITEM_10 = By.xpath("//li[text()='Люди с инвалидностью I или II группы']");

  // == Справка по форме 086/у ==
  public static final By SELECT_REFERENCE_086U = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/div[5]/div/div[1]/div/div/span[2]");
  public static final By REFERENCE_086U_SERIES = By.id("specialconditionsform-reference_086u_series");
  public static final By REFERENCE_086U_NUMBER = By.id("specialconditionsform-reference_086u_number");
  public static final By REFERENCE_086U_DATE = By.id("specialconditionsform-reference_086u_creation_date");
  // == Расширенная медицинская справка ==
  public static final By EXTENDED_MEDICAL_CERTIFICATE = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/div[7]/div/div[1]/div/div/span[2]");
  // == Имеется заключение психолого-медико-педагогической комиссии ==
  public static  final By CONCLUSION_PMPK = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/div[8]/div/div[1]/div/div/span[2]");

  // == Имеется потребность в специальных условиях при прохождении ВИ ==
  public static final By SPECIAL_CONDITIONS = By.xpath("//*[@id=\"msform\"]/div[9]/div/div[1]/div/div/span[2]");
  // 1
  public static final By SPECIAL_CONDITIONS_DROPDOWN = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_1 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'Для слепых')]");
  // 2
  public static final By ADD_SPECIAL_CONDITIONS_2 = By.xpath("//*[@id=\"special_condition{multiple_index}\"]/td[2]/div");
  public static final By SPECIAL_CONDITIONS_DROPDOWN_2 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_2 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'Для слабовидящих')]");
  // 3
  public static final By ADD_SPECIAL_CONDITIONS_3 = By.xpath("//*[@id=\"special_condition{multiple_index}\"]/td[2]/div");
  public static final By SPECIAL_CONDITIONS_DROPDOWN_3 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_3 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'Для глухих и слабослышащих')]");
  // 4
  public static final By ADD_SPECIAL_CONDITIONS_4 = By.xpath("//*[@id=\"special_condition{multiple_index}\"]/td[2]/div");
  public static final By SPECIAL_CONDITIONS_DROPDOWN_4 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_4 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'Для слепоглухих')]");
  // 5
  public static final By ADD_SPECIAL_CONDITIONS_5 = By.xpath("//*[@id=\"special_condition{multiple_index}\"]/td[2]/div");
  public static final By SPECIAL_CONDITIONS_DROPDOWN_5 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_5 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(), 'Для лиц с тяжелыми нарушениями речи')]");
  // 6
  public static final By ADD_SPECIAL_CONDITIONS_6 = By.xpath("//*[@id=\"special_condition{multiple_index}\"]/td[2]/div");
  public static final By SPECIAL_CONDITIONS_DROPDOWN_6 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберите')]]");
  public static final By SPECIAL_CONDITIONS_6 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(), 'Для лиц с нарушениями опорно-двигательного аппарата')]");

  // == Имеется потребность в общежитии ==
  public static final By ADD_DORMITORY = By.xpath("/html/body/div/div[1]/div[2]/div/div/div/div/div[2]/form/div[11]/div/div[1]/div/div/span[2]");

  // == Имеется Имеются индивидуальные достижения ==
  public static final By ADD_INDIVIDUAL_ACHIEVEMENTS = By.xpath("//*[@id=\"msform\"]/div[12]/div/div[1]/div/div/span[2]");
  ///  !!!!!!!!!!!!!!!!!!! Исправить после исправления бага, на букбу И
  public static final By INDIVIDUAL_ACHIEVEMENTS_DROPDOWN_1 = By.xpath("//span[contains(@class, 'select2-selection') and .//span[contains(text(), 'Выберете')]]");
  public static final By INDIVIDUAL_ACHIEVEMENTS_1 = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(), 'Победа в олимпиадах или иных конкурсах')]");
  public static final By INDIVIDUAL_ACHIEVEMENTS_SCORE_1 = By.id("specialconditionsform-personal_achievement-0-personal_achievement_score");
  public static final By NEXT_BUTTON_STEP_7 = By.xpath("//button[@type='submit' and text()='Далее']");
}
