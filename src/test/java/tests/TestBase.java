package tests;

import clients.AuthClient;
import clients.ApiClubClient;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
  AuthClient api = new AuthClient();
  ApiClubClient apiClub = new ApiClubClient();

  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "https://book-club.qa.guru/";
    System.setProperty("https.protocols", "TLSv1.2");
  }

}
