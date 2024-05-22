package Thierno.tuto.contentcalaendar.repository.content;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.model.content.ContentType;
import Thierno.tuto.contentcalaendar.model.content.ContentStatus;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {

  private final List<Content> content = new ArrayList<>();

  public ContentCollectionRepository(){

  }

  public List<Content> findAll(){
    return content;
  }

  public Optional<Content> findById (Integer id){
    return content.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void addContent(Content newContent){
    content.removeIf(c -> c.id().equals(newContent.id()));
    content.add(newContent);
  }

  
  public boolean existById(Integer id) {
    return content.stream().filter(c -> c.id().equals(id)).count() == 1;
  }

  public void deleteContent(Integer id){
    content.removeIf(c -> c.id().equals(id));
  }


  @PostConstruct
  private void init(){
    Content c1 = new Content(1,
           "My First Blog Post",
            "My first blog post",
            ContentStatus.IDEA,
                  ContentType.ARTICLE,
                  LocalDateTime.now(),
      null,
              "");
  
    content.add(c1);
  
    Content c2 = new Content(2,
    "My Second Blog Post",
     "My second blog post",
     ContentStatus.IDEA,
           ContentType.ARTICLE,
           LocalDateTime.now(),
  null,
       "");
    
    content.add(c2);
  }

}
