package Thierno.tuto.contentcalaendar.repository.Attends;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Attend.Attends;
import Thierno.tuto.contentcalaendar.model.course.Course;
import Thierno.tuto.contentcalaendar.model.course.CourseStatus;
import Thierno.tuto.contentcalaendar.repository.course.CourseJdbcRepository;

@Repository
public class AttendsJdbcRepository {

  private JdbcTemplate jdbcTemplate;

  public AttendsJdbcRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public static Attends mapRow(ResultSet rs, int rowNum) throws SQLException{
    return new Attends(rs.getInt("student_id"), rs.getInt("course_id"));
  }

  public void addAttendance(int studentId, int courseId){
    if(getCourseStatus(courseId) == CourseStatus.AVAILABLE){

    String query = "INSERT INTO Attends (student_id, course_id) VALUES (?,?)";
    
    jdbcTemplate.update(query, studentId, courseId);
  }
}

  public CourseStatus getCourseStatus(int courseId){
    
    String query = "SELECT * FROM Course C WHERE C.course_id=" + courseId;

    Optional<Course> course = jdbcTemplate.query(query, CourseJdbcRepository::mapRow).stream().findFirst();

    return course.isPresent() ? course.get().status() : CourseStatus.UNAVAILABLE;

  }

}
