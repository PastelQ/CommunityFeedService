package org.fastcampus.student_management.application.course.interfaces;

import java.util.List;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

/** # Repo Interface를 조회와 저장을 분리하는 것이 좋다
- DB는 조회와 저장 2가지의 작업을 수행하는데 데이터가 많아지면 저장과 조회를 다른 DB에서 진행할 때가 있음
- 조회의 경우 NoSQL이나 인메모리 캐시 등 빠른 조회 성능을 이용
- 저장의 경우 RDBMS를 이용하여 트랜잭션 처리에 강하고 복잡한 관계를 관리하는 데 효과적으로 저장 */
// Repository 조회 인터페이스
public interface CourseQueryRepository {

  List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek);
  
  List<Course> getCourseListByStudent(String studentName);
}
