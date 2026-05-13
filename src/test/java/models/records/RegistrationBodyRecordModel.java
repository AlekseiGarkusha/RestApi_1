package models.records;

public record RegistrationBodyRecordModel(
  Integer id,
  String userName,
  String firstName,
  String lastName,
  String email,
  String remoteAddr) {
}


