package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import setup.Auth;
import setup.TestBase;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MandatoryFields extends TestBase {

  @Test
  void login() {
    Auth auth = new Auth();
    auth.fillLoginAndPassword(
      UserData.LOGIN,
      UserData.PASSWORD
    );
  }

  @Test(priority = 1)
  void goToCreateDoo() {
    SoftAssert softAssert = new SoftAssert();
    $x("//span[normalize-space()='Организации']").click();
    $x("//div[@role='button' and .//span[normalize-space()='Детские сады']]").click();
    $x("//button[.//text()[normalize-space()='Добавить детский сад']]").click();
  }

  @Test(priority = 2)
  void mandatoryFields() {
    $x("//button[normalize-space()='Сохранить']").click();

    ElementsCollection hints = $$("form[novalidate] .MuiFormHelperText-root");

    List<SelenideElement> requiredHints = new ArrayList<>();

    for (SelenideElement hint : hints) {
      if (hint.getText().equals("Поле обязательно для заполнения")) {
        requiredHints.add(hint);
      }
    }
    Assert.assertEquals(requiredHints.size(),13, "Количество валидационных полей не соответсвует");
  }
}
