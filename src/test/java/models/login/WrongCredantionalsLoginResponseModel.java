package models.login;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record WrongCredantionalsLoginResponseModel(String detail, String username,
                                                   String password, String wrongPass,
                                                   String wrongUsername) {}
