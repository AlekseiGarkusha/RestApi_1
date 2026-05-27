package models.registration.update.patch;

public record UpdateResponseModel(Integer id, String username, String firstName,
                                  String lastName, String email) {}
