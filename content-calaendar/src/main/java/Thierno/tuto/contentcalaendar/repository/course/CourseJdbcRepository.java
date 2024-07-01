package Thierno.tuto.contentcalaendar.repository.course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

  public static Course mapRow(ResultSet res, int rowNum) throws SQLException{
    return new Course(res.getInt("course_id"),
                      res.getTime("start_time").toLocalTime(),
                      res.getTime("end_time").toLocalTime(),
                      res.getInt("maximum_capacity"),
                      res.getInt("remaining_capacity"),
                      CourseStatus.valueOf(res.getString("course_status"))
    );

  }

  public List<Course> findAll(){
    String query = "SELECT * FROM Course";
    return jdbcTemplate.query(query, CourseJdbcRepository::mapRow);
  }

  public Optional<Course> findCourseById(Integer courseId){
    String query = "SELECT * FROM Course WHERE course_id = " + courseId;
    return jdbcTemplate.query(query, CourseJdbcRepository::mapRow).stream().findFirst();
  }

  public void addCourse(Course newCourse){
    /*String query0 = "INSERT INTO Course (maximum_capacity, remaining_capacity, course_status, start_time, end_time) " +
    "VALUES (" + newCourse.maximumCapacity() + ",'" + newCourse.status() + "','" + newCourse.startTime() + "','" + newCourse.endTime() + "')";*/

    String query = "INSERT INTO Course (maximum_capacity, remaining_capacity, course_status, start_time, end_time) VALUES (?,?,?,?,?)";

    jdbcTemplate.update(query, newCourse.maximumCapacity(),newCourse.remainingCapacity(), newCourse.status().name(), newCourse.startTime(), newCourse.endTime());
  }

  public List<Course> findAllCourseByStatusByDecreasingId(CourseStatus status){
    String query = "SELECT * FROM Course WHERE course_status = ?";
    PreparedStatementSetter pss = new PreparedStatementSetter() {
      public void setValues(PreparedStatement ps) throws SQLException{
        // this is where we set the values of the ? of the prepared statement
        ps.setString(1, status.name());
      }
    };

    return jdbcTemplate.query(query, pss, CourseJdbcRepository::mapRow);
  }
}
