package Thierno.tuto.contentcalaendar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.Content;
import Thierno.tuto.contentcalaendar.model.Status;
import Thierno.tuto.contentcalaendar.model.Type;

@Repository
public class ContentJdbcTemplateRepository {

  private final JdbcTemplate jdbcTemplate;

  public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Content(rs.getInt("id"),
                       rs.getString("title"),
                       rs.getString("desc"),
                       Status.valueOf(rs.getString("status")),
                       Type.valueOf(rs.getString("content_type")),
                       rs.getObject("date_created", LocalDateTime.class),
                       rs.getObject("date_updated", LocalDateTime.class),
                       rs.getString("url")
    );
  }

  public List<Content> findAll(){
    String query = "SELECT * FROM Content";
    return = jdbcTemplate.query(query, ContentJdbcTemplateRepository::mapRow);
  }

}
