package tests.registration.registrationClassic.steps.step_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;
import utils.random.GenerateRandomSnils;

import java.time.Duration;

import static tests.registration.registrationClassic.steps.step_1.Locators.*;

public class MainStep_1 extends BaseSteps {

  public static String Snils;
  private final MethodsStep_1 methodsStep_1;

  public MainStep_1(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.methodsStep_1 = new MethodsStep_1(driver, this.wait);  }

  public void fillStep_1() {
    String currentAction = "";
    Snils = GenerateRandomSnils.generateRandomSnils();

    try {
      currentAction = "ввод фамилии. Локатор: " + APPLICANT_LASTNAME;
      methodsStep_1.fillApplicantLastname(data.step_1.lastName);

      currentAction = "ввод имени. Локатор: " + APPLICANT_NAME;
      methodsStep_1.fillApplicantName(data.step_1.name);

      currentAction = "ввод отчества. Локатор: " + APPLICANT_PATRONYMIC;
      methodsStep_1.fillApplicantPatronymic(data.step_1.patronymic);

      currentAction = "ввод даты рождения. Локатор: " + APPLICANT_BIRTH_DATE;
      methodsStep_1.fillApplicantBirthdate(data.step_1.birthDate);

      currentAction = "выбор пола. Локатор: " + APPLICANT_GENDER_DROPDOWN;
      methodsStep_1.fillApplicantGender();

      currentAction = "ввод email. Локатор: " + APPLICANT_EMAIL;
      methodsStep_1.fillApplicantEmail(data.step_1.email);

      currentAction = "ввод места рождения. Локатор: " + APPLICANT_BIRTH_PLACE;
      methodsStep_1.fillApplicantBirthPlace(data.step_1.birthPlace);

      currentAction = "ввод адреса по месту рождения. Локатор: " + APPLICANT_BIRTH_ADDRESS;
      methodsStep_1.fillApplicantBirthAddress(data.step_1.address);

      currentAction = "ввод индекса. Локатор: " + APPLICANT_INDEX;
      methodsStep_1.fillApplicantIndex(data.step_1.index);

      currentAction = "ввод СНИЛС. Локатор: " + APPLICANT_SNILS;
      methodsStep_1.fillApplicantSnils(Snils);

      currentAction = "ввод телефона. Локатор: " + APPLICANT_PHONE;
      methodsStep_1.fillApplicantPhone(data.step_1.phone);

      currentAction = "нажатие кнопки Далее. Локатор: " + NEXT_BUTTON_STEP_1;
      methodsStep_1.clickNext();
    } catch (Exception e) {
      Assert.fail("Шаг 1: ошибка при " + currentAction);
    }
  }
}
