package Thierno.tuto.contentcalaendar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Thierno.tuto.contentcalaendar.model.Content;
import Thierno.tuto.contentcalaendar.repository.ContentJdbcTemplateRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/content/jdbc")
public class ContentJdbcController {

  private final ContentJdbcTemplateRepository repository;

  public ContentJdbcController(ContentJdbcTemplateRepository repository){
    this.repository = repository;
  }

  @GetMapping("")
  public List<Content> findAll(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
      return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found !"));
    }

}
