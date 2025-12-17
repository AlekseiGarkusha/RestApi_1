package tests.registration.registrationClassic.steps.step_5;

import org.openqa.selenium.By;

public class Locators {
  public static final By LIST_SPECIALITIES = By.xpath("//span[contains(@class, 'select2-selection') and contains(text(), 'Выберите специальность')]");
  public static final By SPECIALITY = By.xpath("//li[contains(@class, 'select2-results__option') and b[contains(normalize-space(text()), '08.02.12 Строительство и эксплуатация автомобильных дорог')]]");
  public static final By NEXT_BUTTON_STEP_5 = By.xpath("//button[@type='submit' and text()='Далее']");
}
