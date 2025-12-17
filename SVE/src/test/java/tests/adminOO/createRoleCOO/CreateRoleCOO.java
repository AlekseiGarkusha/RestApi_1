/**
 * Тест создания пользользователя -- роли СОО
 * + Проверка на всплывающий popUp
 */

package tests.adminOO.createRoleCOO;

import data.PopUpMessages;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Base;
import utils.PopUpUtils;
import utils.random.GenerateRandomEmail;
import utils.random.GenerateLoginCOO;

import java.lang.ref.SoftReference;

import static tests.adminOO.createRoleCOO.LocatorsCreateRoleCOO.*;

public class CreateRoleCOO extends Base {

  @Test(priority = 2)
  @Description("Переход к созданию пользователя СОО")
  @Severity(SeverityLevel.CRITICAL)
  public void goToCreatingUser() {
    wait.until(ExpectedConditions.elementToBeClickable(ADMINISTRATION_MENU)).click();
    wait.until(ExpectedConditions.elementToBeClickable(CREATING_USER_MENU)).click();
  }

  @Test(priority = 3)
  @Description("Создание роли СОО")
  @Severity(SeverityLevel.CRITICAL)
  public void addUserCOO() {
    String email = GenerateRandomEmail.generateRandomEmail();

    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_USERNAME)).sendKeys(GenerateLoginCOO.generateLoginCOO());
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_EMAIL)).sendKeys(email);
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_FULL_NAME)).sendKeys(data.addRoleCOO.fullName);
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_USER_POSITION)).sendKeys(data.addRoleCOO.userPosition);
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_USER_PHONE)).sendKeys(data.addRoleCOO.phone);
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_ROLE_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_ROLE_COO)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_MINISTRY_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_MINISTRY)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_ORGANISATION_DROPDOWN)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_ORGANISATION)).click();
    wait.until(ExpectedConditions.elementToBeClickable(ADD_USER_BTN_SAVE)).click();
  }

  @Test(priority = 4)
  @Description("Проверка всплывающего окна")
  @Severity(SeverityLevel.CRITICAL)
  public void popUp() throws InterruptedException {
    SoftAssert softAssert = new SoftAssert();
    new PopUpUtils(driver,wait, softAssert).assertPopUpContainsText(PopUpMessages.ROLE_COO_CREATED);
    softAssert.assertAll();
  }
}
