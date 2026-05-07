package utils;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FindText {

  private List<String> elements;

  public boolean findText() {
    $("body").shouldBe(visible);
    String pageText = $("body").getText();
    return false;
  }

  public boolean isTextPresent(String text) {
    if (elements == null) {
      throw new IllegalStateException("Сначала вызови findText()");
    }
    return elements.contains(text);
  }

}
