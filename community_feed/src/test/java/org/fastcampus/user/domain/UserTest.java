package org.fastcampus.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

// User 객체 테스트 클래스
class UserTest {

  private final UserInfo userInfo = new UserInfo("test", "");
  private final User user1 = new User(1L, userInfo);
  private final User user2 = new User(2L, userInfo);
  
  @Test // 다른 유저일 경우 equals() false 반환 여부 테스트
  void givenTwoUser_whenEqual_thenReturnFalse() {
    // when
    boolean value = user1.equals(user2);
    
    // then
    assertFalse(value);
  }
  
  @Test // 같은 유저일 경우 equals() true 반환 여부 테스트
  void givenTwoSameIdUser_whenEquals_thenReturnTrue() {
    // given
    User sameUser = new User(1L, userInfo);
    
    // when
    boolean isSame = user1.equals(sameUser);
    
    // then
    assertTrue(isSame);
  }
  
  @Test // 서로 다른 유저의 HashCode 동일하지 않은 지 확인 테스트
  void givenTwoUser_whenHashCode_thenNotEqual() {
    // when
    int hashCode1 = user1.hashCode();
    int hashCode2 = user2.hashCode();
    
    // then
    assertNotEquals(hashCode1, hashCode2);
  }
  
  @Test // 같은 유저의 HashCode가 동일한 지 확인 테스트
  void givenTwoSameIdUser_whenHashCode_thenEqual() {
    // given
    User sameUser = new User(1L, userInfo);
    
    // when
    int hashCode1 = user1.hashCode();
    int sameUserHashCode = sameUser.hashCode();
    
    // then
    assertEquals(hashCode1, sameUserHashCode);
  }
  
  @Test
  void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
    // when
    
  }
}