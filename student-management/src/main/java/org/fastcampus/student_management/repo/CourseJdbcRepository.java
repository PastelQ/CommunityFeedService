package org.fastcampus.student_management.repo;

import java.util.List;
import org.fastcampus.student_management.application.course.CourseRepository;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public class CourseJdbcRepository implements CourseRepository {

  @Override
  public void save(Course course) {
    // TODO Auto-generated method stub
    
  }

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
