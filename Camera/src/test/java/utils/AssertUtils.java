/**
 * Util - сокращения, для выполнения сравнения чере Assert.
 * Используется для упрощения написания кода
 */


  package utils;

import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;
import setup.BaseSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AssertUtils extends BaseSteps {

  public static AssertUtils assertUtils;
  private final SoftAssert softAssert;

  public AssertUtils(SoftAssert softAssert) {
    this.softAssert = softAssert;
  }

  public String assertElementTextEquals(String locator, String expectedText, String fieldName) {
    SelenideElement element;

    if (locator.startsWith("/")) {
      element = $x(locator);
    } else if (locator.startsWith("#")) {
      element = $(locator);
    } else {
      element = $("#" + locator);
    }

    /// Попытка 1: получить текст из kv-attribute, если элемент вложен в td
    String actual = "";
    try {
      SelenideElement td = element.closest("td");
      if (td.exists()) {
        SelenideElement kvAttribute = td.$(".kv-attribute");
        if (kvAttribute.exists()) {
          actual = kvAttribute.getText().trim();
        }
      }
    } catch (Exception ignored) {}

    /// Попытка 2: напрямую из текста
    if (actual.isEmpty()) {
      try {
        actual = element.getText().trim();
      } catch (Exception ignored) {}
    }

    /// Попытка 3: из value
    if (actual.isEmpty()) {
      try {
        String value = element.getValue();
        actual = value != null ? value.trim() : "";
      } catch (Exception ignored) {}
    }

    /// Форматирование даты
    if (fieldName.toLowerCase().contains("дата") && actual.matches("\\d{4}-\\d{2}-\\d{2}")) {
      String[] parts = actual.split("-");
      actual = parts[2] + "." + parts[1] + "." + parts[0];
    }

    softAssert.assertEquals(actual, expectedText, "❌ Ошибка соответствия - поле: '" + fieldName + "'");
    return actual;
  }
}