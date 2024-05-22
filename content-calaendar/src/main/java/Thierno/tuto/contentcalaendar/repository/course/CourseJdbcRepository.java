package Thierno.tuto.contentcalaendar.repository.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.course.Course;
import Thierno.tuto.contentcalaendar.model.course.CourseStatus;

@Repository
public class CourseJdbcRepository {
  private final JdbcTemplate jdbcTemplate;

  public CourseJdbcRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  /*private static Course mapRow(ResultSet res, int rowNum) throws SQLException{
    return new Course(res.getInt("course_id"),
                     new ArrayList<>(Arrays.asList((Integer[]) res.getArray("students_registered").getArray())),
                      res.getInt("teacher_id"),
                      res.getObject("start_time", LocalTime.class),
                      res.getObject("end_time", LocalTime.class),
                      res.getInt("maximum_capacity"),
                      CourseStatus.valueOf(res.getString("course_status"))
    );

  }*/

  public List<Course> findAll(){
    String query = "SELECT * FROM Course";
    return jdbcTemplate.query(query, CourseJdbcRepository::mapRow);
  }

}
