package Thierno.tuto.contentcalaendar.controller.Attends;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Thierno.tuto.contentcalaendar.model.Attend.Attends;
import Thierno.tuto.contentcalaendar.repository.Attends.AttendsJdbcRepository;



@RestController
@RequestMapping("/api/jdbc/attends")
@CrossOrigin
public class AttendsJdbcController {

  private AttendsJdbcRepository attendsJdbcRepository;

  public AttendsJdbcController(AttendsJdbcRepository attendsJdbcRepository){
    this.attendsJdbcRepository = attendsJdbcRepository;
  }

  @PostMapping("")
  public void addAttendance(@RequestBody Attends attendence) {

    switch(attendsJdbcRepository.getCourseStatus(attendence.getCourseId())){
      case AVAILABLE: attendsJdbcRepository.addAttendance(attendence.getStudentId(), attendence.getCourseId());
      break;
      case FULL: throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course is full");
      case CANCELED: throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course is canceled");
      case UNAVAILABLE: throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course is unavailable");
    }
    

  }
  
}
