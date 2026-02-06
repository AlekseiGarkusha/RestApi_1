/** Util - генерация рандомных дат */

package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateDate {

  public static String getDayToday() {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
    return today.format(formatter);
  }

  public static String getDayTenDaysFromNow() {
    LocalDate today = LocalDate.now();
    LocalDate targetDate = today.plusDays(10);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
    return targetDate.format(formatter);
  }

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
