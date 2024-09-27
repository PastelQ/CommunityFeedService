package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }
  
  // 학생 활성화하기
  public void activateStudent(String name) {
	  Student student = getStudent(name);
	  student.activate(); // 어떤 동작을 할지 메서드 명으로 전달하기 때문에 가독성 증가
	  //student.setActivated(false);
  }
  
  // 학생 비활성화하기
  public void deactivateStudent(String name) {
	  Student student = getStudent(name);
	  student.deactivate(); // 어떤 동작을 할지 메서드 명으로 전달하기 때문에 가독성 증가
	  //student.setActivated(false);
  }
}
