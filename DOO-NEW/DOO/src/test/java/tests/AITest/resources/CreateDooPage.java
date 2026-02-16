package tests.AITest.resources;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateDooPage {

  // ========== Поля формы ==========
  private SelenideElement title = $x("//span[normalize-space()='Добавление детского сада']");
  private SelenideElement saveButton = $x("//button[normalize-space()='Сохранить']");

  // ========== Методы для взаимодействия ==========
  public CreateDooPage fillInput(String label, String value) {
    $x("//label[contains(.,'" + label + "')]/following::input[1]")
      .shouldBe(Condition.visible)
      .setValue(value);
    return this;
  }

  public CreateDooPage selectValue(String label, String option) {
    $x("//label[contains(.,'" + label + "')]/following::div[contains(@class,'MuiSelect')][1]")
      .shouldBe(Condition.visible)
      .click();
    $x("//li[@role='option' and normalize-space()='" + option + "']")
      .shouldBe(Condition.visible)
      .click();
    return this;
  }

  public CreateDooPage checkCheckbox(String label) {
    $x("//div[.//span[text()='" + label + "']]")
      .shouldBe(Condition.visible)
      .click();
    return this;
  }

  public CreateDooPage save() {
    saveButton.shouldBe(Condition.enabled).click();
    return this;
  }

  public void shouldBeVisible() {
    title.shouldBe(Condition.visible);
  }
}