package models.club;

public record CreateClubBodyModel(
  String bookTitle,
  String bookAuthors,
  String publicationYear,
  String description,
  String telegramChatLink) {}
