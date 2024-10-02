package org.fastcampus.student_management.domain;

import java.util.List;

/* 1급 컬렉션
- 1급 컬렉션을 활용할 경우 장점
1. 로직을 쉽게 파악하기 쉬움(메서드 명만으로 쉽게 로직을 파악하기 쉬움)
2. 재사용이 가능
3. Test가 쉬워짐 : Service 레이어의 종속성을 구현하지 않아도 됨 */
public class CourseList {

	private List<Course> courses;
	
	public CourseList(List<Course> courses) {
		this.courses = courses;
	}
	
	public void changeAllCoursesFee(int fee) {
		for (Course course : courses) {
			if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
				course.changeFee((int)(fee * 1.5));
			}
			course.changeFee(fee);
		}
	}
}
