package models.login;

public record WrongCredantionalsLoginResponseModel(
  String username,
  String wrongPass,
  String wrongUsername,
  String detail) {


}
