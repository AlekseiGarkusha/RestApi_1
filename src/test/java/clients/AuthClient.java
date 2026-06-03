package clients;

import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import org.openqa.selenium.devtools.v145.network.model.Response;

import static spec.LoginSpec.successfulLoginResponseSpec;
import static spec.LoginSpec.wrongRegistrationLoginSpec;

public class AuthClient extends ApiClient {
  public LoginResponseModel login(LoginBodyModel body) {
    return request()
      .body(body)
      .when()
      .post("/auth/token/")
      .then()
      .spec(successfulLoginResponseSpec)
      .extract()
      .as(LoginResponseModel.class);
  }

  public WrongCredantionalsLoginResponseModel loginWithWrongCredentials(LoginBodyModel body) {
    return request()
      .body(body)
      .when()
      .post("/auth/token/")
      .then()
      .spec(wrongRegistrationLoginSpec)
      .extract()
      .as(WrongCredantionalsLoginResponseModel.class);
  }

  public Response logout(String refreshToken) {
    return (Response) request()
      .body(java.util.Map.of("refresh", refreshToken))
      .when()
      .post("/auth/logout/");
  }

  public Response refreshToken(String refreshToken) {
    return (Response) request()
      .body(java.util.Map.of("refresh", refreshToken))
      .when()
      .post("/auth/token/refresh/");
  }
}