package Thierno.tuto.contentcalaendar.repository.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Teacher.Teacher;

@Repository
public class TeacherJdbcRepository {

private JdbcTemplate jdbcTemplate;

public TeacherJdbcRepository(JdbcTemplate jdbc){
  this.jdbcTemplate = jdbc;
}

private static Teacher mapRow(ResultSet res, int rowNum) throws SQLException{
  return new Teacher(res.getInt("teacher_id"), res.getString("teacher_name"));
}

public List<Teacher> findAll(){
  String query = "SELECT * FROM Teacher";
  return jdbcTemplate.query(query, TeacherJdbcRepository::mapRow);
}

}
