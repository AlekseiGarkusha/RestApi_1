/** Util -  для поиска небходимых разделов*/

package utils;

import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import static com.codeborne.selenide.Selenide.$;

public class AssertPartitionsPresent extends BaseSteps {

  public AssertPartitionsPresent(SoftAssert softAssert) {
    super();
    this.softAssert = softAssert;
  }

  public void assertPartitionsPresent(String[] hints) {

    String pageSource = $("body").getText();
      for (String hint : hints) {
        softAssert.assertTrue(pageSource.contains(hint), "❌ Ожидалась подсказка: " + hint);
      }
    }
  }
