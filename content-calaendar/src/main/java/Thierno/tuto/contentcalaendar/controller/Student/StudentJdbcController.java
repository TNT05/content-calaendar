package Thierno.tuto.contentcalaendar.controller.Student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Thierno.tuto.contentcalaendar.model.Student.Student;
import Thierno.tuto.contentcalaendar.repository.Student.StudentJdbcRepository;

@RestController
@RequestMapping("api/student/jdbc")
@CrossOrigin
public class StudentJdbcController {
  private StudentJdbcRepository studentJdbcRepository;
  public StudentJdbcController(StudentJdbcRepository studentJdbcRepository){
    this.studentJdbcRepository = studentJdbcRepository;
  }

  @PostMapping("")
  public void addStudent(@RequestBody Student student){
    studentJdbcRepository.addStudent(student);
  }
}
