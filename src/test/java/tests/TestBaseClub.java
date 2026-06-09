package tests;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseClub {
  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "https://book-club.qa.guru";
    System.setProperty("https.protocols", "TLSv1.2");
  }
}
