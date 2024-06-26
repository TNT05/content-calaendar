package Thierno.tuto.contentcalaendar.repository.content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.content.ContentStatus;
import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.model.content.ContentType;

@Repository
public class ContentJdbcTemplateRepository {

  private final JdbcTemplate jdbcTemplate;

  public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Content(rs.getInt("id"),
                       rs.getString("title"),
                       rs.getString("description"),
                       ContentStatus.valueOf(rs.getString("status")),
                       ContentType.valueOf(rs.getString("content_type")),
                       rs.getObject("date_created", LocalDateTime.class),
                       rs.getObject("date_updated", LocalDateTime.class),
                       rs.getString("url")
    );

  }

  public List<Content> findAll(){
    String query = "SELECT * FROM Content";
    return jdbcTemplate.query(query, ContentJdbcTemplateRepository::mapRow);
  }

  public Optional<Content> findById(Integer id){
    String query = "SELECT * FROM Content C WHERE C.id=" + id;

    return jdbcTemplate.query(query, ContentJdbcTemplateRepository::mapRow).stream().findFirst();
  }

  public void addContent(Content content){
    String query = "INSERT INTO Content(title,description,status,content_type,date_created, date_updated, url) " +
    "VALUES ('" + content.title() + "','" + content.description() + "','" + content.status() + "','" + content.contentType() + "','" + LocalDateTime.now() + "'," + content.dateUpdated() + ",'" + content.url() + "')";
    
    jdbcTemplate.update(query);
  }

  public void deleteContent(Integer id){
    String query = "DELETE FROM Content WHERE id="+id;

    jdbcTemplate.update(query);
  }

  public void updateContent(Content content){
    String query =  "UPDATE Content " +
    "SET title='" + content.title() + "', description='" + content.description() + "', status='" + content.status() + "', content_type='" + content.contentType() + "', date_updated='" + LocalDateTime.now() + "', url='" + content.url() + "' " +
    "WHERE id=" + content.id();

    jdbcTemplate.update(query);
  }
    

}
