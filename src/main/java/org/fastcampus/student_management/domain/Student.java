package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }
  
  /* 조금 더 효율적으로 setter Met 대신 activate(),deactivate()를 작성
  public void setActivated(boolean activated) {
	  // 둘다 true일 경우
	  if(activated && this.activated) {
		  throw new IllegalArgumentException(); 
	  }
	  // 둘다 false일 경우
	  if(!activated && this.activated) {
		  throw new IllegalArgumentException();
	  }
	  this.activated = activated;
  }*/
  // setter() 대신 활성화, 비활성화 메서드 생성 -> 분할로 유연성 증가
  public void activate() {
	  if(this.activated) {
		  throw new IllegalArgumentException();
	  }
	  
	  this.activated = true;
  }
  
  public void deactivate() {
	  if(!this.activated) {
		  throw new IllegalArgumentException();
	  }
	  
	  this.activated = false;
  }
  
  
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
  public boolean isActivate() {
    return activated;
  }
}
