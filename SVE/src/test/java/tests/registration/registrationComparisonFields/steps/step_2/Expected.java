package tests.registration.registrationComparisonFields.steps.step_2;

import data.TestDataRegistration;
import utils.JsonUtils;

public class Expected {
  static TestDataRegistration data = JsonUtils.readTestData("TestData.json");

  public static String expectedApplicantTypeOfDocument = data.step_2.documentType;
  public static String expectedDocumentIssued = data.step_2.documentIssued;
  public static String expectedDocumentIssueDate = data.step_2.documentIssueDate;
  public static String expectedDocumentDepartmentCode = data.step_2.documentDepartmentCode;
}
