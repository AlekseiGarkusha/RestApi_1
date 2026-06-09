package models.club;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClubBodyModel(
  String bookTitle,
  String bookAuthors,
  Integer publicationYear,
  String description,
  String telegramChatLink) {}
