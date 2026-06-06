package tests;

import helpers.GenerateRandomSeries;
import io.qameta.allure.Allure;
import models.club.ClubBodyModel;
import models.club.ClubResponseModel;
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClubsTests extends TestBase {

  String username = "qaguru777";
  String password = "qaguru123";

  private String bookTitle = "NEWbookTitle" + GenerateRandomSeries.generateRandomSeries();
  private String bookAuthors = "NEWbookAuthors";
  private Integer publicationYear = 1990;
  private String description = "NEWdescription";
  private String telegramChatLink = "https://t.me/ams_simferopol/486865";

  private String newBookTitle = "updateNEWbookTitle" + GenerateRandomSeries.generateRandomSeries();
  private String newBookAuthors = "updateNEWbookAuthors";
  private Integer newPublicationYear = 1999;
  private String newDescription = "updateNEWdescription";
  private String newTelegramChatLink = "https://t.me/ams_simferopolupdate/486865";

  ClubBodyModel clubBodyModel = new ClubBodyModel(
    bookTitle,
    bookAuthors,
    publicationYear,
    description,
    telegramChatLink);

  ///  todo CreateClubs  ..
  @Test
  @DisplayName("Cоздание клуба")
  public void createClub() {
    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel clubResponseModel = step("Создание", () ->
      apiClub.create(clubBodyModel, token));

    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(clubBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(clubBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(clubBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(clubBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(clubBodyModel.telegramChatLink());
    });
  }

  ///  todo ReadClubs..
  @Test
  @DisplayName("Получение клуба по id")
  public void readClub() {
    String id = "2";

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel clubResponseModel = step("Чтение", () ->
      apiClub.read(clubBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.id()).isEqualTo("2");
      assertThat(clubResponseModel.bookAuthors()).isNotEmpty();
      assertThat(clubResponseModel.publicationYear()).isNotNull();
      assertThat(clubResponseModel.description()).isNotEmpty();
      assertThat(clubResponseModel.telegramChatLink()).isNotEmpty();
    });

    System.out.println(clubResponseModel.id());
    System.out.println(clubResponseModel.bookAuthors());
    System.out.println(clubResponseModel.publicationYear());
    System.out.println(clubResponseModel.description());
    System.out.println(clubResponseModel.telegramChatLink());
  }

  ///  todo UpdateClubs..
  ///  // БАГА,,!!! 500
  @Test
  @DisplayName("Обновление клуба - Patch")
  public void updateClub_Patch() {
    String id = "1";

    ClubBodyModel updateBodyModel = new ClubBodyModel(
      newBookTitle,
      newBookAuthors,
      newPublicationYear,
      newDescription,
      newTelegramChatLink
    );

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel clubResponseModel = step("Обновление", () ->
      apiClub.update_Patch(updateBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(updateBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(updateBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(updateBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(updateBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(updateBodyModel.telegramChatLink());

      System.out.println(updateBodyModel.bookTitle());
      System.out.println(updateBodyModel.bookAuthors());
      System.out.println(updateBodyModel.description());
      System.out.println(updateBodyModel.telegramChatLink());
    });
  }

  /// БАГА,,!!! 500
  @Test
  @DisplayName("Обновление клуба - Put")
  public void updateClub_Put() {
    String id = "1";

    ClubBodyModel updateBodyModel = new ClubBodyModel(
      newBookTitle,
      newBookAuthors,
      newPublicationYear,
      newDescription,
      newTelegramChatLink
    );

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel clubResponseModel = step("Обновление", () ->
      apiClub.update_Put(updateBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(updateBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(updateBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(updateBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(updateBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(updateBodyModel.telegramChatLink());

      System.out.println(updateBodyModel.bookTitle());
      System.out.println(updateBodyModel.bookAuthors());
      System.out.println(updateBodyModel.description());
      System.out.println(updateBodyModel.telegramChatLink());
    });
  }

  ///  todo DeleteClubs..
  /// /// БАГА,,!!! 500
  @Test
  @DisplayName("")
  public void deleteClub() {
    ClubResponseModel ValidatableResponse;
    String id = "2";

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ValidatableResponse = step("Чтение", () ->
      apiClub.read(clubBodyModel, token, id));

    step("Удаление", () ->
      apiClub.deleteClub(token, id));

    step("Проверка", () -> {
      assertThat(ValidatableResponse.id()).isNull();
    });
  }
}
