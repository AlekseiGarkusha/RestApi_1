package tests.registration.registrationComparisonFields.steps.step_8;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedLegalRepresentativeFio = data.step_8.legalRepresentative.fio;
  public static String expectedLegalRepresentativePhone = data.step_8.legalRepresentative.phone;
  public static String expectedLegalRepresentativeEmail = data.step_8.legalRepresentative.email;
}
