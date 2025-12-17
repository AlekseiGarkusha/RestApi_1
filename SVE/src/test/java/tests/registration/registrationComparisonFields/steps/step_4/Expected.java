package tests.registration.registrationComparisonFields.steps.step_4;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedSPOOrganisation = data.step_4.spoOrganisation;
  public static String expectedEducationLevel = data.step_4.educationLevel;
}
