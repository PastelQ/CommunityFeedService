package org.fastcampus.student_management.domain;

import org.fastcampus.student_management.application.course.dto.CourseInfoDto;

public class Course {
  private final Student student;
  private final String courseName;
  private CourseFee fee; // VO타입 변경
  private final DayOfWeek dayOfWeek;
  private final Long courseTime;

  // 도메인의 매개변수를 Dto로 받아 의존성이
  public Course(Student student, CourseInfoDto courseInfoDto) {
    if (student == null) {
      throw new IllegalArgumentException("학생은 필수 입력값입니다.");
    }

    this.student = student;
    this.courseName = courseInfoDto.getCourseName();
    this.fee = new CourseFee(courseInfoDto.getFee());
    this.dayOfWeek = courseInfoDto.getDayOfWeek();
    this.courseTime = courseInfoDto.getCourseTime();
  }
  
  // 수강료 변경 
  public void changeFee(int fee) {
	  //this.fee.checkFee(fee);
	  this.fee.changeFee(fee);
  }

  public String getCourseName() {
    return courseName;
  }

  public boolean isSameDay(DayOfWeek dayOfWeek) {
    return this.dayOfWeek.equals(dayOfWeek);
  }

  public boolean isActivateUser() {
    return student.isActivate();
  }

  public String getStudentName() {
    return student.getName();
  }

  public int getFee() {
    return fee.getFee();
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public Long getCourseTime() {
    return courseTime;
  }
}
