package models.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginResponseModel(String id, String username,
                                 String firstName, String lastName,
                                 String email, String remoteAddr,
                                 String refresh, String access) {}
