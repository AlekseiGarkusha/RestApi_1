package tests.registration.registrationComparisonFields.steps.step_7;

import data.SpecialConditions;
import data.TestDataRegistration;
import utils.ConditionUtils;
import utils.JsonUtils;
import java.util.Arrays;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  // ====== Справка об инвалидности ====
  public static String expectedSpecialConditionsFormSerial = data.step_7.disabilityCertificate.series;
  public static String expectedSpecialConditionsFormNumber = data.step_7.disabilityCertificate.number;
  public static String expectedSpecialConditionsFormGroup = data.step_7.disabilityCertificate.group;
  public static String expectedSpecialConditionsFormReason = data.step_7.disabilityCertificate.reason;
  public static String expectedSpecialConditionsFormIssued = data.step_7.disabilityCertificate.issued;
  public static String expectedSpecialConditionsFormIssueDate = data.step_7.disabilityCertificate.issueDate;
  public static String expectedSpecialConditionsFormExpirationDate = data.step_7.disabilityCertificate.expirationDate;
  // ======= Льгота ==========
  public static String expectedBenefit_1 = data.step_7.benefits.benefit_1;
  public static String expectedBenefit_2 = data.step_7.benefits.benefit_2;
  public static String expectedBenefit_3 = data.step_7.benefits.benefit_3;
  public static String expectedBenefit_4 = data.step_7.benefits.benefit_4;
  public static String expectedBenefit_5 = data.step_7.benefits.benefit_5;
  public static String expectedBenefit_6 = data.step_7.benefits.benefit_6;
  public static String expectedBenefit_7 = data.step_7.benefits.benefit_7;
  public static String expectedBenefit_8 = data.step_7.benefits.benefit_8;
  public static String expectedBenefit_9 = data.step_7.benefits.benefit_9;
  public static String expectedBenefit_10 = data.step_7.benefits.benefit_10;
  // ====== Справка по форме 086/у ===========
  public static String expectedReference_086USeries = data.step_7.reference086u.o86uSeries;
  public static String expectedReference_086UNumber = data.step_7.reference086u.o86uNumber;
  public static String expectedReference_086UDate = data.step_7.reference086u.o86uDate;

  // ====== Специальные условия ВИ ====
  public static String getExpectedConditions(SpecialConditions cond) {
    return Arrays.toString(ConditionUtils.toArray(cond));
  }
  public static String expectedConditions =  Expected.getExpectedConditions(data.step_7.specialConditions);;

  // ====== Индивидуальные достижения ====
  public static String expectedIndividualAchievements = data.step_7.individualAchievements.iAch_1;
  public static String expectedIndividualAchievementsScore_1 = data.step_7.individualAchievements.score_1;
}
