package org.fastcampus.student_management.repo;

import java.util.List;
import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.application.course.interfaces.CourseQueryRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

// Jdbc는 조회만 진행으로 save() 삭제
public class CourseJdbcCommandRepository implements CourseQueryRepository {

  @Override
  public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Course> getCourseListByStudent(String studentName) {
    // TODO Auto-generated method stub
    return null;
  }

}
