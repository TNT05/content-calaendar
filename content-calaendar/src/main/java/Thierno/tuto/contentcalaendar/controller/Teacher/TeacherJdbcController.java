package Thierno.tuto.contentcalaendar.controller.Teacher;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Thierno.tuto.contentcalaendar.model.Teacher.Teacher;
import Thierno.tuto.contentcalaendar.repository.Teacher.TeacherJdbcRepository;

@RestController
@CrossOrigin
@RequestMapping("api/teacher/jdbc")
public class TeacherJdbcController {

  private TeacherJdbcRepository teacherJdbcRepository;

  public TeacherJdbcController(TeacherJdbcRepository teacherJdbcRepository){
    this.teacherJdbcRepository = teacherJdbcRepository;
  }

  @GetMapping("")
  public List<Teacher> findAll(){
    return teacherJdbcRepository.findAll();
  }

}
