package org.fastcampus.student_management.application.course;

import java.util.List;

import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }
  // 수강 목록 구현
  // courses(List)를 스트림으로 변환 -> map() DTO 객체로 변환 -> 해당 stream의 모든 요소를 List로 수집해 CourseInfoDto 객체들로 이뤄진 List로 반환 
  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    return courses.stream().map(CourseInfoDto::new).toList();
  }
  
  // 수강료 변경
  public void changeFee(String studentName, int fee) {
	  List<Course> courses = courseRepository.getCourseListByStudent(studentName);
	  // 1급 컬렉션 활용 (CourseList) : 반복문 For 뎁스를 없애고 CourseList 인스턴스 생성 및 내부 메서드 사용
	  CourseList courseList = new CourseList(courses);
	  courseList.changeAllCoursesFee(fee);
  }
}
