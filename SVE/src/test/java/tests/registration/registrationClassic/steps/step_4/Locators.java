package tests.registration.registrationClassic.steps.step_4;

import org.openqa.selenium.By;

public class Locators {
  public static final By SPO_ORGANISATION = By.xpath("//*[@id=\"msform\"]/div[1]/div/span/span[1]/span");
  public static final By EDUCATION_LEVEL = By.xpath("//*[@id=\"msform\"]/div[2]/div/span/span[1]/span");
  public static final By NEXT_BUTTON_STEP_4 = By.xpath("//button[@type='submit' and text()='Далее']");
}
