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

  private String newBookTitle_PATCH = "updatePatchBookTitle" + GenerateRandomSeries.generateRandomSeries();
  private String newBookAuthors_PATCH = "updatePatchBookAuthors";
  private Integer newPublicationYear_PATCH = 2000;
  private String newDescription_PATCH = "updatePatchdescription";
  private String newTelegramChatLink_PATCH = "https://t.me/ams_simferopolupdatePatch/486865";

  private String newBookTitle_PUT = "updatePutBookTitle" + GenerateRandomSeries.generateRandomSeries();
  private String newBookAuthors_PUT = "updatePutBookAuthors";
  private Integer newPublicationYear_PUT = 1999;
  private String newDescription_PUT = "updatePutdescription";
  private String newTelegramChatLink_PUT = "https://t.me/ams_simferopolupdatePut/486865";

  ClubBodyModel clubBodyModel = new ClubBodyModel(
    bookTitle,
    bookAuthors,
    publicationYear,
    description,
    telegramChatLink);

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

    System.out.println("Вот ID" + clubResponseModel.id());
    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(clubBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(clubBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(clubBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(clubBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(clubBodyModel.telegramChatLink());
    });
  }

  @Test
  @DisplayName("Получение клуба по id")
  public void readClub() {
    String id = "72";

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel clubResponseModel = step("Чтение", () ->
      apiClub.read(clubBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.id()).isEqualTo("72");
      assertThat(clubResponseModel.bookAuthors()).isNotEmpty();
      assertThat(clubResponseModel.publicationYear()).isNotNull();
      assertThat(clubResponseModel.description()).isNotEmpty();
      assertThat(clubResponseModel.telegramChatLink()).isNotEmpty();
    });
  }

  @Test
  @DisplayName("Обновление клуба - Patch")
  public void updateClub_Patch() {
    ClubBodyModel updateBodyModel = new ClubBodyModel(
      newBookTitle_PATCH,
      newBookAuthors_PATCH,
      newPublicationYear_PATCH,
      newDescription_PATCH,
      newTelegramChatLink_PATCH
    );

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel createClub = step("Создание", () ->
      apiClub.create(clubBodyModel, token));

    String id = createClub.id();

    ClubResponseModel clubResponseModel = step("Обновление", () ->
      apiClub.update_Patch(updateBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(updateBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(updateBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(updateBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(updateBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(updateBodyModel.telegramChatLink());
    });
  }

  @Test
  @DisplayName("Обновление клуба - Put")
  public void updateClub_Put() {
    ClubBodyModel updateBodyModel = new ClubBodyModel(
      newBookTitle_PUT,
      newBookAuthors_PUT,
      newPublicationYear_PUT,
      newDescription_PUT,
      newTelegramChatLink_PUT
    );

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    ClubResponseModel createClub = step("Создание", () ->
      apiClub.create(clubBodyModel, token));

    String id = createClub.id();

    ClubResponseModel clubResponseModel = step("Обновление", () ->
      apiClub.update_Put(updateBodyModel, token, id));

    step("Проверки", () -> {
      assertThat(clubResponseModel.bookTitle()).isEqualTo(updateBodyModel.bookTitle());
      assertThat(clubResponseModel.bookAuthors()).isEqualTo(updateBodyModel.bookAuthors());
      assertThat(clubResponseModel.publicationYear()).isEqualTo(updateBodyModel.publicationYear());
      assertThat(clubResponseModel.description()).isEqualTo(updateBodyModel.description());
      assertThat(clubResponseModel.telegramChatLink()).isEqualTo(updateBodyModel.telegramChatLink());
    });
  }

  @Test
  @DisplayName("Удаление клуба")
  public void deleteClub() {
    ClubResponseModel clubResponseModel;

    LoginBodyModel registrationData = Allure.step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = Allure.step("Авторизация", () ->
      api.login(registrationData));

    String token = loginResponse.access();

    clubResponseModel = step("Создание", () ->
      apiClub.create(clubBodyModel, token));

    String id = clubResponseModel.id();

    step("Удаление", () ->
      apiClub.deleteClub(token, id));

    step("Проверка что id больше не существует", () ->
      apiClub.getDeteletedIdClub(token, id));
  }
}
