package Thierno.tuto.contentcalaendar.model.course;

import java.time.LocalTime;

public record Course(
  Integer courseId,
  LocalTime startTime,
  LocalTime endTime,
  Integer maximumCapacity,
  Integer remainingCapacity,
  CourseStatus status 
) {

  
}
