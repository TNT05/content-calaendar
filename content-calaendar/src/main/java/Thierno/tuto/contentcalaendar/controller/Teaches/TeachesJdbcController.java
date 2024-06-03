package Thierno.tuto.contentcalaendar.controller.Teaches;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Thierno.tuto.contentcalaendar.model.Teaches.Teaches;
import Thierno.tuto.contentcalaendar.repository.Teaches.TeachesJdbcRepository;

@RestController
@RequestMapping("api/Teaches/jdbc")
@CrossOrigin
public class TeachesJdbcController {

  private TeachesJdbcRepository teachesJdbcRepository;

  public TeachesJdbcController(TeachesJdbcRepository teachesJdbcRepository){
    this.teachesJdbcRepository = teachesJdbcRepository;
  }

  @GetMapping("/{id}")
  public List<Integer> findAllCourseTeachedByTeacherId(@PathVariable Integer id){
    return teachesJdbcRepository.findAllCourseTeachedByTeacherId(id);
  }

  @PostMapping("/addTeaching")
  public void addTeaching(@RequestBody Teaches teaching){
    teachesJdbcRepository.addTeaching(teaching);
  }

}
