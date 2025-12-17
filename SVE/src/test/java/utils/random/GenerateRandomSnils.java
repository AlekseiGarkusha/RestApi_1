/** Генегация рандомного СНИЛС */

package utils.random;

import java.util.Random;


public class GenerateRandomSnils {
  public static String generateRandomSnils() {
    Random rand = new Random();
    StringBuilder snils = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      snils.append(rand.nextInt(10));
    }

    int sum = 0;
    for (int i = 0; i < 9; i++) {
      int digit = snils.charAt(i) - '0';
      sum += digit * (9 - i);
    }

    int controlNumber;
    if (sum < 100) {
      controlNumber = sum;
    } else if (sum == 100 || sum == 101) {
      controlNumber = 0;
    } else {
      int mod = sum % 101;
      if (mod == 100 || mod == 101) {
        controlNumber = 0;
      } else {
        controlNumber = mod;
      }
    }

    String control = String.format("%02d", controlNumber);

    return snils.toString() + control;
  }
}
