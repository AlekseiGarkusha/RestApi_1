package models.login;

public record WrongCredantionalsLoginResponseModel(String detail, String username,
                                                   String password, String wrongPass,
                                                   String wrongUsername) {}
