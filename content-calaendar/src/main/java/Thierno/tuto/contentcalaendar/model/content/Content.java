package Thierno.tuto.contentcalaendar.model.content;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Content(
  Integer id,
  @NotBlank String title,
  String desc,
  ContentStatus status,
  ContentType contentType,
  LocalDateTime dateCreated,
  LocalDateTime dateUpdated,
  String url
  ) {

   
}
