package tests.registration.registrationClassic.steps.step_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BaseSteps;

public class MainStep_7 extends BaseSteps {

  public final MethodsStep_7 methodsStep_7;

  public MainStep_7(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    this.methodsStep_7 = new MethodsStep_7(driver,this.wait);
  }

  public void fillStep_7() {
    String currentAction = "";

    try {
      currentAction = "выбор значения в dropdown специальных условий";
      methodsStep_7.fillSpecialConditionsFormDropdown();

      currentAction = "ввод серии справки об инвалидности";
      methodsStep_7.fillSpecialConditionsFormSerial(data.step_7.disabilityCertificate.series);

      currentAction = "ввод номера справки об инвалидности";
      methodsStep_7.fillSpecialConditionsFormNumber(data.step_7.disabilityCertificate.number);

      currentAction = "ввод группы инвалидности";
      methodsStep_7.fillSpecialConditionsFormGroup(data.step_7.disabilityCertificate.group);

      currentAction = "ввод причины инвалидности";
      methodsStep_7.fillSpecialConditionsFormReason(data.step_7.disabilityCertificate.reason);

      currentAction = "ввод выдавшей организации инвалидности";
      methodsStep_7.fillSpecialConditionsFormIssued(data.step_7.disabilityCertificate.issued);

      currentAction = "ввод даты выдачи справки об инвалидности";
      methodsStep_7.fillSpecialConditionsFormIssueDate(data.step_7.disabilityCertificate.issueDate);

      currentAction = "ввод срока действия справки об инвалидности";
      methodsStep_7.fillSpecialConditionsFormExpirationDate(data.step_7.disabilityCertificate.expirationDate);

      currentAction = "нажатие кнопки 'Льгота'";
      methodsStep_7.clickBenefit();

      currentAction = "заполнение льготы 1";
      methodsStep_7.fillBenefit_1();

      currentAction = "заполнение льготы 2";
      methodsStep_7.fillBenefit_2();

      currentAction = "заполнение льготы 3";
      methodsStep_7.fillBenefit_3();

      currentAction = "заполнение льготы 4";
      methodsStep_7.fillBenefit_4();

      currentAction = "заполнение льготы 5";
      methodsStep_7.fillBenefit_5();

      currentAction = "заполнение льготы 6";
      methodsStep_7.fillBenefit_6();

      currentAction = "заполнение льготы 7";
      methodsStep_7.fillBenefit_7();

      currentAction = "заполнение льготы 8";
      methodsStep_7.fillBenefit_8();

      currentAction = "заполнение льготы 9";
      methodsStep_7.fillBenefit_9();

      currentAction = "заполнение льготы 10";
      methodsStep_7.fillBenefit_10();

      currentAction = "нажатие кнопки 'Справка 086у'";
      methodsStep_7.clickReference();

      currentAction = "ввод серии справки 086у";
      methodsStep_7.fillReferenceSeries(data.step_7.reference086u.o86uSeries);

      currentAction = "ввод номера справки 086у";
      methodsStep_7.fillReferenceNumber(data.step_7.reference086u.o86uNumber);

      currentAction = "ввод даты справки 086у";
      methodsStep_7.fillReferenceDate(data.step_7.reference086u.o86uDate);

      currentAction = "добавление расширенной медицинской справки";
      methodsStep_7.addExtendedMedicalCertificate();

      currentAction = "добавление заключения ПМПК";
      methodsStep_7.addConclusion_PMPK();

      currentAction = "добавление бинарной отметки специальных условий";
      methodsStep_7.addSpecialConditions();

      currentAction = "заполнение специальных условий 1";
      methodsStep_7.fillSpecialConditions_1();

      currentAction = "заполнение специальных условий 2";
      methodsStep_7.fillSpecialConditions_2();

      currentAction = "заполнение специальных условий 3";
      methodsStep_7.fillSpecialConditions_3();

      currentAction = "заполнение специальных условий 4";
      methodsStep_7.fillSpecialConditions_4();

      currentAction = "заполнение специальных условий 5";
      methodsStep_7.fillSpecialConditions_5();

      currentAction = "заполнение специальных условий 6";
      methodsStep_7.fillSpecialConditions_6();

      currentAction = "добавление общежития";
      methodsStep_7.addDormitory();

      currentAction = "добавление бинарной отметки достижений";
      methodsStep_7.addIndividualAchievements();

      currentAction = "заполнение индивидуального достижения 1";
      methodsStep_7.fillIndividualAchievement_1();

      currentAction = "заполнение оценки индивидуального достижения 1";
      methodsStep_7.fillIndividualAchievement_1_score(data.step_7.individualAchievements.score_1);

      currentAction = "нажатие кнопки Далее";
      methodsStep_7.clickNext();

    } catch (Exception e) {
      Assert.fail("Шаг 7: ошибка при " + currentAction + ". Сообщение: " + e.getMessage(), e);
    }
  }
}
