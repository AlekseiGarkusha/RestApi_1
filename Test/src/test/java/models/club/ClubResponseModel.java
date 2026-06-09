package models.club;

import java.util.List;

public record ClubResponseModel(
  String id,
  String bookTitle,
  String bookAuthors,
  Integer publicationYear,
  String description,
  String telegramChatLink,
  String owner,
  List<Integer> members,
  List<Object> reviews,
  String created,
  String access,
  String refresh,
  String modified) {}
