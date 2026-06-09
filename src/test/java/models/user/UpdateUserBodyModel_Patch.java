package models.user;

public record UpdateUserBodyModel_Patch (String username, String firstName,
                                        String lastName, String email) {}
