package Thierno.tuto.contentcalaendar.model.course;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public record Course(
  Integer courseId,
  //List<Integer> studentsRegistered,
  //Integer teacherId,
  LocalTime startTime,
  LocalTime endTime,
  Integer maximumCapacity,
  CourseStatus status 
) {

  
}
