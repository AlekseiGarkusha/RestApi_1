package tests.registration.registrationComparisonFields.steps.step_7;

import org.openqa.selenium.By;

public class Locators {
  // =============== Справка об инвалидности ===========
  public static final By SPECIAL_CONDITIONS_FORM_SERIAL_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[1]");
  public static final By SPECIAL_CONDITIONS_FORM_NUMBER_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[2]");
  public static final By SPECIAL_CONDITIONS_FORM_GROUP_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[3]");
  public static final By SPECIAL_CONDITIONS_FORM_REASON_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[4]");
  public static final By SPECIAL_CONDITIONS_FORM_DATE_START_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[5]");
  public static final By SPECIAL_CONDITIONS_FORM_ORGANIZATION_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[6]");
  public static final By SPECIAL_CONDITIONS_FORM_EXPIRATION_DATE_FIELD = By.xpath("//*[@id=\"certificate-disability-index-container\"]/table/tbody/tr/td[7]");
  // ==================Имеется преимущественное право (льгота) ================
  public static final By BENEFIT_1_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[1]/td[1]");
  public static final By BENEFIT_2_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[2]/td[1]");
  public static final By BENEFIT_3_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[3]/td[1]");
  public static final By BENEFIT_4_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[4]/td[1]");
  public static final By BENEFIT_5_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[5]/td[1]");
  public static final By BENEFIT_6_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[6]/td[1]");
  public static final By BENEFIT_7_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[7]/td[1]");
  public static final By BENEFIT_8_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[8]/td[1]");
  public static final By BENEFIT_9_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[9]/td[1]");
  public static final By BENEFIT_10_FIELD = By.xpath("//*[@id=\"benefits-index-container\"]/table/tbody/tr[10]/td[1]");
  // ==  Справка 086У ==
  public static final By REFERENCE_086U_SERIES_FIELD = By.xpath("//*[@id=\"reference-086u-index-container\"]/table/tbody/tr/td[2]");
  public static final By REFERENCE_086U_NUMBER_FIELD = By.xpath("//*[@id=\"reference-086u-index-container\"]/table/tbody/tr/td[3]");
  public static final By REFERENCE_086U_DATE_FIELD = By.xpath("//*[@id=\"reference-086u-index-container\"]/table/tbody/tr/td[6]");
  // == Специальные условия для ВИ ==
  public static final By SPECIAL_CONDITIONS_VI_FIELD = By.xpath("//*[@id=\"w11\"]/tbody/tr[2]/td/div[1]");
  public static final By INDIVIDUAL_ACHIEVEMENTS_FIELD = By.xpath("//*[@id=\"personal-achievement-index-container\"]/table/tbody/tr/td[1]");
  public static final By INDIVIDUAL_ACHIEVEMENTS_SCORE_FIELD = By.xpath("//*[@id=\"personal-achievement-index-container\"]/table/tbody/tr/td[2]");

  // Step_8
  public static final By LEGAL_REPRESENTATIVE_FIO_FIELD = By.xpath("//*[@id=\"w23\"]/tbody/tr[1]/td/div[1]");
  public static final By LEGAL_REPRESENTATIVE_PHONE_FIELD = By.xpath("//*[@id=\"w23\"]/tbody/tr[2]/td/div[1]");
  public static final By LEGAL_REPRESENTATIVE_EMAIL_FIELD = By.xpath("//*[@id=\"w23\"]/tbody/tr[3]/td/div[1]");
}
