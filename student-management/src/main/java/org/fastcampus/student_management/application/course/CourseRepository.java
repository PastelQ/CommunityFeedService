package org.fastcampus.student_management.application.course;

import java.util.List;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

/** Application에 Repository Interface를 놓을 경우의 이점
 1. Interface로 의존성 분리
  - 고수준 -> 저수준 컴포넌트 의존을 방지하기 위해 서로의 의존성을 Interface로 분리
  - 인터페이스 사용으로 인해 유연성 증가
  ex) InMemory -> JDBC 방식 변경 시 구현체만 변경하면 됨
 2. 왜 Application Layer에 넣을까?
  - 해당 레이어에서 Repo 인터페이스를 사용함으로 실제 데이터 저장 방식에 대해 신경쓰지 않아도 됨
  ex) JDBC에서 또 다른 데이터 접근 기술(JPA..등)으로 변경할 때 해당 레이어만 수정하면 됨
  - 명확한 역할 분리를 통해 코드 가독성, 유지 보수성을 높임
  - Repo Layer는 데이터 저장소와의 상호작용을 처리하는데 집중
  - App Layer는 비즈니스 로직과 애플리케이션 흐름 제어에 집중 */
public interface CourseRepository {

  void save(Course course);
  
  List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek);
  
  List<Course> getCourseListByStudent(String studentName);
}
