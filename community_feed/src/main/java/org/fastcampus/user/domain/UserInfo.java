package org.fastcampus.user.domain;

// UserInfo VO : 유저의 이름, 프로필 사진 URL 정보
public class UserInfo {

	private final String name;
	private final String profileImageUrl;
	
	// 생성자 생성 시 name 필드가 null이거나 공백일 경우 예외 발생(유효성 검사)
	public UserInfo(String name, String profileImageUrl) {
		
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}
}
