package models.login;

public record UpdateResponseModel(String id, String username, String firstName,
                                  String lastName, String email, String remoteAddr) {}

