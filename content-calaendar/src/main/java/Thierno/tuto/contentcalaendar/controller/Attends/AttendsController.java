package Thierno.tuto.contentcalaendar.controller.Attends;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Thierno.tuto.contentcalaendar.model.Attend.Attends;
import Thierno.tuto.contentcalaendar.repository.Attends.AttendsJdbcRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api/jdbc/attends")
@CrossOrigin
public class AttendsController {

  private AttendsJdbcRepository attendsJdbcRepository;

  public AttendsController(AttendsJdbcRepository attendsJdbcRepository){
    this.attendsJdbcRepository = attendsJdbcRepository;
  }

  @PostMapping("")
  public void addAttendance(@RequestBody Attends attendence) {

    attendsJdbcRepository.addAttendance(attendence.getStudentId(), attendence.getCourseId());

  }
  
}
