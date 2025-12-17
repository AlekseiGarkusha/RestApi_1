package utils.random;

import java.util.Random;

public class GenerateLoginCOO {

  public static String generateLoginCOO() {
    int length = 8; // длина логина

    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits = "0123456789";
    String specials = "!@#$%^&*";
    String all = "abcdefghijklmnopqrstuvwxyz" + upper + digits + specials;

    Random random = new Random();

    // Гарантированно добавляем по одному символу нужных типов
    StringBuilder login = new StringBuilder();
    login.append(upper.charAt(random.nextInt(upper.length())));
    login.append(digits.charAt(random.nextInt(digits.length())));
    login.append(specials.charAt(random.nextInt(specials.length())));

    // Остальные символы — любые из допустимых
    while (login.length() < length) {
      login.append(all.charAt(random.nextInt(all.length())));
    }

    // Перемешиваем результат (чтобы спецсимвол не всегда был на 3-м месте)
    return shuffle(login.toString());
  }

  private static String shuffle(String input) {
    char[] chars = input.toCharArray();
    Random rnd = new Random();
    for (int i = chars.length - 1; i > 0; i--) {
      int j = rnd.nextInt(i + 1);
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
    return new String(chars);
  }
}


