package Thierno.tuto.contentcalaendar.controller.course;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Thierno.tuto.contentcalaendar.model.course.CourseSpringData;
import Thierno.tuto.contentcalaendar.repository.course.CourseSpringDataRepository;


@CrossOrigin
@RequestMapping("api/course/springData")
@RestController
public class CourseSpringDataController {
  private CourseSpringDataRepository courseSpringDataRepository;

  public CourseSpringDataController(CourseSpringDataRepository courseSpringDataRepository){
    this.courseSpringDataRepository = courseSpringDataRepository;
  }

  @GetMapping("")
  public List<CourseSpringData> findAll() {
      return courseSpringDataRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<CourseSpringData> getMethodName(@PathVariable int id) {
      return courseSpringDataRepository.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable int id){
    courseSpringDataRepository.deleteById(id);
  }

}
