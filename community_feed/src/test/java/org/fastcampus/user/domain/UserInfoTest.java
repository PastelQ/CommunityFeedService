package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class UserInfoTest {
  // name, profile를 제공했을 때 예외 throw하지 않는 지 확인
  @Test
  void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
    // given
    String name = "abcd";
    String profileImageUrl = ""; // 해당 필드는 공백이어도 문제 없음
    
    // when(생성), given(예외 throw 여부 확인)
    assertDoesNotThrow(() -> new UserInfo(name, profileImageUrl));
  }
  
  // name이 공백일 경우 예외가 발생해 throw 하는 지 확인
  @Test
  void givenBlankNameAndProfileImage_whenCreated_thenThrowError() {
    // given
    String name = "";
    String profileImageUrl = "";
    
    // when, then
    assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImageUrl));
  }
}
