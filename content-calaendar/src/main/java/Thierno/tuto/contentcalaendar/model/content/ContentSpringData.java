package Thierno.tuto.contentcalaendar.model.content;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Table("CONTENT")
public record ContentSpringData(
  @Id
  Integer id,
  @NotBlank String title,
  String description,
  ContentStatus status,
  ContentType contentType,
  LocalDateTime dateCreated,
  LocalDateTime dateUpdated,
  String url
  ) {

   
}
