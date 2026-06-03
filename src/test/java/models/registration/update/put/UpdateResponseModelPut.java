package models.registration.update.put;

public record UpdateResponseModelPut(String id, String username,
                                     String firstName, String lastName,
                                     String email, String remoteAddr) {}
