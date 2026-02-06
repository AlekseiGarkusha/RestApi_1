package utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FindText {

  public void findText() {
    $("body").shouldBe(visible);
    String pageText = $("body").getText();
  }
}
