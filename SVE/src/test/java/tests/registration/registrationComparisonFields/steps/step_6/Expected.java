package tests.registration.registrationComparisonFields.steps.step_6;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedMathematicsScore = data.step_6.mathematics;
  public static String expectedComputerScienceScore  = data.step_6.computerScience;
  public static String expectedPhysicsScore  = data.step_6.physics;
  public static String expectedGeographyScore  = data.step_6.geography;
  public static String expectedChineseScore  = data.step_6.chinese;
  public static String expectedLiteratureScore  = data.step_6.literature;
  public static String expectedSpanishScore  = data.step_6.spanish;
  public static String expectedGermanScore  = data.step_6.german;
}
