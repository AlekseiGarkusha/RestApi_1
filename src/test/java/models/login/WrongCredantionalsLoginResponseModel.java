package models.login;

import java.util.List;

public record WrongCredantionalsLoginResponseModel(
  String detail,
  String username,
  String password,
  String wrongPass,
  String wrongUsername
  ) {


}
