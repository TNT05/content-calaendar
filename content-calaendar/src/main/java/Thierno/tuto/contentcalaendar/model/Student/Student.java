package Thierno.tuto.contentcalaendar.model.Student;

public class Student {

  private int studentId;
  private String fullName;
  private Level level;

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public Student(int studentId, String fullName, Level level){
    this.studentId = studentId;
    this.fullName = fullName;
    this.level = level;
  }

}
