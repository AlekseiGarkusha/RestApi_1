package models.login;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateResponseModel_Put(String username, String firstname, String lastname, String email) {}
