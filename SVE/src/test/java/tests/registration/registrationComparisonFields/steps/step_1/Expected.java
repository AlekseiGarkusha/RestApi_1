package tests.registration.registrationComparisonFields.steps.step_1;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedApplicantLastName = data.step_1.lastName;
  public static String expectedApplicantName = data.step_1.name;
  public static String expectedApplicantSurname = data.step_1.patronymic;
  public static String expectedApplicantBirthDate = data.step_1.birthDate;
  public static String expectedApplicantGender = data.step_1.gender;
  public static String expectedApplicantEmail = data.step_1.email;
  public static String expectedApplicantBirthPlace = data.step_1.birthPlace;
  public static String expectedApplicantAddress = data.step_1.address;
  public static String expectedApplicantIndex = data.step_1.index;
  public static String expectedApplicantPhone = data.step_1.phone;
}
