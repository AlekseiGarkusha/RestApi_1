package models.login;

public record LoginResponseModel(
  String id, String username,
  String firstName, String lastName,
  String email, String remoteAddr,
  String refresh, String access) {

}

