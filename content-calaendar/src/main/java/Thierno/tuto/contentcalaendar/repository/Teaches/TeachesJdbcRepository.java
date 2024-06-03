package Thierno.tuto.contentcalaendar.repository.Teaches;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Teaches.Teaches;

@Repository
public class TeachesJdbcRepository {

  private JdbcTemplate jdbcTemplate;
  
  public TeachesJdbcRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Teaches mapRow(ResultSet res, int rowNum) throws SQLException{
    return new Teaches(res.getInt("teacher_id"),
                      res.getInt("course_id"));
  }

  public List<Integer> findAllCourseTeachedByTeacherId(Integer teacherId){
    String query = "SELECT T.course_id From Teaches T WHERE T.teacher_id = " + teacherId;
    return jdbcTemplate.queryForList(query, Integer.class);
  }

  public void addTeaching(Teaches teaching) {
    String query = "INSERT INTO Teaches(teacher_id, course_id) " + "VALUES(" + teaching.teacherId() + ", " + teaching.courseId() + ");";
    jdbcTemplate.update(query);
  }
}
