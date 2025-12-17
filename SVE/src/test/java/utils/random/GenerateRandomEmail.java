package utils.random;

public class GenerateRandomEmail {
  public static String generateRandomEmail() {
    return "user" + (int)(Math.random() * 10000) + "@test.com";
  }
}
