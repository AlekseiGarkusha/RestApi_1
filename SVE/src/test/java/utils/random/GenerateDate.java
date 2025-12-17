package utils.random;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateDate {

  public static String getTodayDate() {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    return today.format(formatter);
  }

  public static String getDateThreeMonthsFromNow() {
    LocalDateTime futureDateTime = LocalDateTime.now()
      .plusMonths(3)
      .withHour(10)
      .withMinute(30);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    return futureDateTime.format(formatter);
  }
}
