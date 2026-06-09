package models.login;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateResponseModel_Patch(String id, String username, String firstName,
                                  String lastName, String email, String remoteAddr) {}

