package models.registration.update.patch;


public record UpdateBodyModel(String username,
                              String firstName,
                              String lastName,
                              String email) {}
