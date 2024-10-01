package org.fastcampus.student_management.application.course;

import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.application.course.interfaces.CourseQueryRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseCommandRepositoryImpl;
import org.fastcampus.student_management.repo.StudentRepository;

public class CourseService {
  private final CourseCommandRepository courseCommandRepository;
  private final CourseQueryRepository courseQueryRepository;
  //private final StudentService studentService; // Service가 아닌 Repository를 직접 의존할 경우
  private final StudentRepository studentRepository;

  public CourseService(CourseCommandRepositoryImpl courseRepository, CourseQueryRepository courseQueryRepository, StudentRepository studentRepository) {
    this.courseCommandRepository = courseRepository;
    this.courseQueryRepository = courseQueryRepository;
    this.studentRepository = studentRepository;
  }

  // Course(고수준) -> CourseInfo(저수준) 컴포넌트로 의존하는 경우
  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentRepository.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto);
    courseCommandRepository.save(course);
  }
  
  // 수강 목록 구현
  // courses(List)를 스트림으로 변환 -> map() DTO 객체로 변환 -> 해당 stream의 모든 요소를 List로 수집해 CourseInfoDto 객체들로 이뤄진 List로 반환 
  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    List<Course> courses = courseQueryRepository.getCourseDayOfWeek(dayOfWeek);
    return courses.stream().map(CourseInfoDto::new).toList();
  }
  
  // 수강료 변경
  public void changeFee(String studentName, int fee) {
	  List<Course> courses = courseQueryRepository.getCourseListByStudent(studentName);
	  // 1급 컬렉션 활용 (CourseList) : 반복문 For 뎁스를 없애고 CourseList 인스턴스 생성 및 내부 메서드 사용
	  CourseList courseList = new CourseList(courses);
	  courseList.changeAllCoursesFee(fee);
  }
}
