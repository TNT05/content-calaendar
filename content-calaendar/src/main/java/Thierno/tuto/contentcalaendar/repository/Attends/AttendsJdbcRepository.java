package Thierno.tuto.contentcalaendar.repository.Attends;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Attend.Attends;

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
    String query = "INSERT INTO Attends (student_id, course_id) VALUES (?,?)";
    jdbcTemplate.query(query, new PreparedStatementSetter() {
      public void setValues(PreparedStatement ps) throws SQLException{
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
      }
    }, AttendsJdbcRepository::mapRow);
  }

}
