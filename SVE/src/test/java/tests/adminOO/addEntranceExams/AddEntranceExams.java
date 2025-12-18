/** Тест создания ВИ для роли Администратор ОО*/

package tests.adminOO.addEntranceExams;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;
import utils.random.GenerateRandomNumber;

import static tests.adminOO.addEntranceExams.Locators.*;

public class AddEntranceExams extends Base {

//  @Test(priority = 2)
//  @Description("Переход к добавлению ВИ")
//  @Severity(SeverityLevel.CRITICAL)
//  public void goToAddEntranceExams() {
//    wait.until(ExpectedConditions.elementToBeClickable(SCHEDULE_ENTRANCE_TEST_MENU)).click();
//    wait.until(ExpectedConditions.elementToBeClickable(ADD_ENTRANCE_TEST)).click();
//  }

  @Test(priority = 3)
  @Description("Переход к добавлению ВИ")
  @Severity(SeverityLevel.CRITICAL)
  public void addEntranceExams() {
    String number = GenerateRandomNumber.generateRandomNumber();

    wait.until(ExpectedConditions.elementToBeClickable(NAME_ENTRANCE_TEST)).sendKeys(data.addEntranceExams.name + " " + "+" + " " + number);

    wait.until(ExpectedConditions.elementToBeClickable(SPO_INSTITUTION_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPO_INSTITUTION)).click();

    wait.until(ExpectedConditions.elementToBeClickable(FORM_STUDY_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(FORM_STUDY_FULL_TIME)).click();

    wait.until(ExpectedConditions.elementToBeClickable(BASIC_EDUCATION_LEVEL_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(BASIC_EDUCATION_LEVEL_9_CLASS)).click();

    wait.until(ExpectedConditions.elementToBeClickable(FORM_PAYMENT_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(FORM_PAYMENT_BUDGET)).click();

    wait.until(ExpectedConditions.elementToBeClickable(SPECIALITY_PROFESSION_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SPECIALITY_PROFESSION)).click();

    wait.until(ExpectedConditions.elementToBeClickable(SYSTEM_ENTRANCE_EXAM_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(SYSTEM_ENTRANCE_EXAM)).click();

    wait.until(ExpectedConditions.elementToBeClickable(THRESHOLD_SCORE_ENTRANCE_EXAM)).sendKeys(data.addEntranceExams.score);

    wait.until(ExpectedConditions.elementToBeClickable(ADD_ENTRANCE_TEST_BTN_SAVE)).click();
  }

  @Test(priority = 4)
  @Description("Проверка всплывающего окна")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    Thread.sleep(3000);
    SoftAssert softAssert = new SoftAssert();
    PopUpUtils popUpUtils = new PopUpUtils(driver,wait, softAssert);

    popUpUtils.assertPopUpContainsText(PopUpMessages.ENTRANCE_EXAM_CREATED);
    softAssert.assertAll();
  }
}
