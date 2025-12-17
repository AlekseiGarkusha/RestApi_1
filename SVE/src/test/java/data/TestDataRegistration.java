package data;

public class TestDataRegistration {
  public Step_1 step_1;
  public Step_2 step_2;
  public Step_3 step_3;
  public Step_4 step_4;
  public Step_5 step_5;
  public Step_6 step_6;
  public Step_7 step_7;
  public Step_8 step_8;

  public SpecialityPage specialityPage;
  public AddRoleCOO addRoleCOO;
  public AddEntranceExams addEntranceExams;
  public AddGroupEntranceExams addGroupEntranceExams;
  public AddScoreEntranceExams addScoreEntranceExams;
  public EditingUser editingUser;
  public ExpectedData expectedData;

  public static class Step_1 {
    public String lastName;
    public String name;
    public String patronymic;
    public String birthDate;
    public String gender;
    public String email;
    public String birthPlace;
    public String address;
    public String index;
    public String snils;
    public String phone;
  }

  public static class Step_2 {
    public String documentType;
    public String documentIssued;
    public String documentIssueDate;
    public String documentDepartmentCode;
  }

  public static class Step_3 {
    public String educationDocumentIssued;
    public String educationDocumentSeries;
    public String educationDocumentNumber;
    public String educationDocumentIssueDate;
    public String gradesFives;
    public String gradesFours;
    public String gradesThrees;
  }

  public static class Step_4 {
    public String spoOrganisation;
    public String educationLevel;
  }

  public static class Step_5 {
    public String speciality;
  }

  public static class Step_6 {
    public String mathematics;
    public String computerScience;
    public String physics;
    public String geography;
    public String chinese;
    public String literature;
    public String spanish;
    public String german;
  }

  public static class Step_7 {
    public DisabilityCertificate disabilityCertificate;
    public Benefits benefits;
    public Reference086u reference086u;
    public SpecialConditions specialConditions;
    public IndividualAchievements individualAchievements;

    public static class DisabilityCertificate {
      public String series;
      public String number;
      public String group;
      public String reason;
      public String issued;
      public String issueDate;
      public String expirationDate;
    }

    public static class Reference086u {
      public String o86uSeries;
      public String o86uNumber;
      public String o86uDate;
    }

    public static class IndividualAchievements {
      public String iAch_1;
      public String score_1;
    }
  }

  public static class Step_8 {
    public LegalRepresentative legalRepresentative;
  }

  public static class LegalRepresentative {
    public String fio;
    public String phone;
    public String email;
  }

  public static class SpecialityPage {
    public String SPOOrganisationName;
    public String numberOfReceptionPlaces;
    public String termOfStudy;
  }

  public static class AddRoleCOO {
    public String fullName;
    public String userPosition;
    public String phone;
  }

  public static class AddEntranceExams {
    public String name;
    public String score;
  }

  public static class AddGroupEntranceExams {
    public String groupName;
    public String location;
    public String numberSeats;
    public String dateTime;
  }

  public static class AddScoreEntranceExams {
    public String score_1;
    public String score_2;
    public String score_3;
  }

  public static class EditingUser {
    public String login;
    public String email;
    public String fullName;
    public String position;
    public String phone;
  }

  public static class ExpectedData {
    public String expectedNewApplicantSurname;
    public String expectedNewApplicantName;
    public String expectedNewApplicantPatronymic;
    public String expectedNewApplicantBirthDate;
    public String expectedNewApplicantBirthPlace;
    public String expectedNewApplicantIndex;
    public String expectedNewApplicantEmail;
    public String expectedNewApplicantPhone;
    public String expectedNewApplicantAddress;
  }
}
