package data;

import utils.GenerateDate;
import utils.GenerateRandomSeries;

public class Constants {
  public static final String DAY_TODAY = ".day.full-day";
  public static final String FIRST_DAY = "//div[@class='day' and text()='1']";

  public static final String ZONE_NAME = "Автотест-создание зоны " + GenerateRandomSeries.generateRandomSeries();
  public static final String ZONE_DESCRIPTION = "Автотест-описание";
}
