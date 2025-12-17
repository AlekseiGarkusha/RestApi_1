/** Генерация рандомного номера паспорта */

package utils.random;

import java.util.Random;

public class GenerateRandomNumber {
  public static String generateRandomNumber() {

    StringBuilder number = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < 6; i++) {
      int digit = random.nextInt(10);
      number.append(digit);
    }
    return number.toString();
  }
}
