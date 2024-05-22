package Thierno.tuto.contentcalaendar.model;

import java.util.List;

public record Teacher(
  Integer id,
  String name,
  List<String> coursesId
) {

}
