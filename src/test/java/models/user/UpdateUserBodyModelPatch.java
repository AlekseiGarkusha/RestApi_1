package models.user;

public record UpdateUserBodyModelPatch(String username, String firstName,
                                       String lastName, String email) {}
