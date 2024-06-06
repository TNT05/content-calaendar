package Thierno.tuto.contentcalaendar.controller.content;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.model.content.ContentSpringData;
import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.repository.content.ContentCollectionRepository;
import Thierno.tuto.contentcalaendar.repository.content.ContentSpringDataRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content/springData")
@CrossOrigin
public class ContentSpringDataController {

  private final ContentSpringDataRepository repository;

  public ContentSpringDataController(ContentSpringDataRepository repository){
    this.repository = repository;
  }

  @GetMapping("")
  public List<ContentSpringData> findAll(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ContentSpringData findById(@PathVariable Integer id){
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found !")); 
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void addContent(@Valid @RequestBody ContentSpringData content){
    repository.save(content);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("{id}")
  public void updateContent(@RequestBody ContentSpringData content, @PathVariable Integer id){
    if(!repository.existsById(id)){
      // learn how to create custom exceptions
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found !");
    }
    repository.save(content);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public void deleteContent(@PathVariable Integer id){
    if(!repository.existsById(id)){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found !");
    }
    repository.deleteById(id);
  }

}
