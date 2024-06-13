package Thierno.tuto.contentcalaendar.model.course;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

public record CourseSpringData(
  @Id
  int courseId,
  String courseName,
  LocalTime startTime,
  LocalTime endTime,
  int maxCapacity
) {

}
