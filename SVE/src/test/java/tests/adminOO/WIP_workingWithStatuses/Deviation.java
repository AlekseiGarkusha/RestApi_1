package tests.adminOO.WIP_workingWithStatuses;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;

import static tests.adminOO.WIP_workingWithStatuses.Locators.*;

public class Deviation extends Base {

  @Test(priority = 2)
  @Description("Переход к созданному заявлению")
  @Severity(SeverityLevel.CRITICAL)
  public void goToRegistryApplications() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    Methods methods = new Methods(driver, wait);

   methods.goToRegisterOfApplications();
   methods.checkFilterStatusAccepted();
   methods.goToApplicationCard();
   methods.changeStatusApplicant();
   methods.clickBtnSave();

   String expectedHint = "Необходимо заполнить «Причина изменения статуса».";
   WebElement hint = wait.until(ExpectedConditions.elementToBeClickable(CHANGE_STATUS_HINT));
   String actual = hint.getText();
   softAssert.assertEquals(actual, expectedHint, "Ошибка обязательного поля: 'Причина изменения статуса'");

   methods.fillTextAreaComments();
   methods.clickBtnSave();

   new PopUpUtils(driver, wait, softAssert).assertPopUpContainsText("PopUpMessages.");
   softAssert.assertAll();
  }
}
