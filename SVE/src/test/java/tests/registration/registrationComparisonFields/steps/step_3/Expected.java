package tests.registration.registrationComparisonFields.steps.step_3;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedEducationDocumentIssued = data.step_3.educationDocumentIssued;
  public static String expectedEducationDocumentSeries = data.step_3.educationDocumentSeries;
  public static String expectedEducationDocumentNumber = data.step_3.educationDocumentNumber;
  public static String expectedEducationDocumentIssueDate = data.step_3.educationDocumentIssueDate;
}
