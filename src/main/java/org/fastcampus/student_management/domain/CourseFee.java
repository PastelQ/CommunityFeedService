package org.fastcampus.student_management.domain;

// 수강료 관련 유효성 검사를 VO를 생성해서 진행
public class CourseFee {

	private int fee;
	
	public CourseFee(int fee) {
		this.fee = fee;
	}
	
	// 수강료 변경
	public void changeFee(int fee) {
		this.fee = fee;
	}
	
	// fee 값 검사(유효성 검사 : 음수인지)
	public void checkFee(int fee) {
		if(fee < 0) {
			throw new IllegalArgumentException("수강료는 0원 이상이어야 합니다.");
		}
	}
	
	public int getFee() {
		return fee;
	}
}