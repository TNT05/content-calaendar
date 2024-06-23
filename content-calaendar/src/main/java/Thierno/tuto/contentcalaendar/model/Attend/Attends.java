package Thierno.tuto.contentcalaendar.model.Attend;


public class Attends {
  private int studentId;
  private int courseId;
  public int getStudentId() {
    return studentId;
  }
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
  public int getCourseId() {
    return courseId;
  }
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  public Attends(int studentId, int courseId){
    this.studentId = studentId;
    this.courseId = courseId;
  }
  
}
