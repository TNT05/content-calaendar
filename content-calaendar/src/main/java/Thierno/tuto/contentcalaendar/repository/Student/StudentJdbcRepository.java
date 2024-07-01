package Thierno.tuto.contentcalaendar.repository.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Student.Level;
import Thierno.tuto.contentcalaendar.model.Student.Student;

@Repository
public class StudentJdbcRepository {
  private JdbcTemplate jdbcTemplate;
  public StudentJdbcRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public static Student mapRow(ResultSet rs, int rowNum) throws SQLException{
    return new Student(rs.getInt("student_id"), rs.getString("student_fullname"), Level.valueOf(rs.getString("student_level")));
  }

  public void addStudent(Student student){
    String query = "INSERT INTO Student (student_fullname, student_level) VALUES (?,?)";
    
    jdbcTemplate.update(query, student.getFullName(), student.getLevel().name()); 
  } 
}
