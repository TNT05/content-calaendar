package Thierno.tuto.contentcalaendar.controller.course;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Thierno.tuto.contentcalaendar.model.course.Course;
import Thierno.tuto.contentcalaendar.repository.course.CourseJdbcRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("api/course/jdbc")
public class CourseJdbcController {

  private CourseJdbcRepository courseJdbcRepository;

  public CourseJdbcController(CourseJdbcRepository courseJdbcRepository){
    this.courseJdbcRepository = courseJdbcRepository;
  }

  @GetMapping("")
  public List<Course> findAll(){
    return courseJdbcRepository.findAll();
  }

  @GetMapping("/{courseId}")
  public Course findById(@PathVariable Integer courseId){
    return courseJdbcRepository.findCourseById(courseId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found !"));
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public void addContent(@Valid @RequestBody Course newCourse){
    courseJdbcRepository.addCourse(newCourse);
  }

  @GetMapping("/findAllCourseByStatusByDecreasingId/{courseStatus}")
  public List<Course> findAllCourseByStatusByDecreasingId(@PathVariable String courseStatus) {
      
    List<Course> matchCourses = courseJdbcRepository.findAllCourseByStatusByDecreasingId(courseStatus);

      Comparator<Course> comparator = new Comparator<Course>() {
        public int compare(Course course1, Course course2){
          if(course2.courseId() > course1.courseId()){
            return 1;
          }
          else{
            return -1;
          }
        }
      };

      matchCourses.sort(comparator);
      return matchCourses;
      
  }
  

}
