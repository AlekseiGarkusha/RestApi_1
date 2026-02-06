/** Функция генерации рандомной серии паспорта */

package utils;

import java.util.Random;

public class GenerateRandomSeries {

  public static String generateRandomSeries() {
    StringBuilder series = new StringBuilder();
    Random random = new Random();

      for (int i = 0; i < 4; i++) {
        int digit = random.nextInt(10);
        series.append(digit);
      }
    return series.toString();
  }
}

